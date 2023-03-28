<?php
final class Utilisateur {
    private $pdo;

    public function __construct()
    {
        $this->pdo = Connection::getInstance()->pdo;
    }

    public function checkPasswordStrength(string $password): bool
    {
        $uppercase = preg_match('@[A-Z]@', $password);
        $lowercase = preg_match('@[a-z]@', $password);
        $number = preg_match('@[0-9]@', $password);
        $specialChars = preg_match('@[^\w]@', $password);

        return $uppercase && $lowercase && $number && $specialChars && strlen($password) >= 8;
    }
    public function estValide($pseudo, $email, $mdp, $mdpConfirme)
    {
        return !empty($pseudo) && !empty($email) && !empty($mdp) &&  !empty($mdpConfirme)
            && $mdp === $mdpConfirme;
    }

    public function verificationEmail($email)
    {
        $connection = Connection::getInstance();
        $result = $this->pdo->prepare('SELECT mail FROM membre WHERE mail = ?');
        while(!$result ->execute(array($email))) {
            $result ->execute(array($email));
        }
        $stmt = $result -> fetchAll(PDO::FETCH_ASSOC);
        if (!empty($stmt)) {
            echo "L'e-mail est déjà associé à un compte, veuillez vous connecter avec le compte associé à ce mail, ou bien créez un nouveau compte.";
            die;
        }
    }

    public function inscription($email, $mdp, $pseudo )
    {
// Hachage du mot de passe
        $mdphash = password_hash($mdp, PASSWORD_DEFAULT);
        // Insertion des données dans la base de données
        $insert = $this->pdo->prepare('INSERT INTO membre(mail, pseudo, motdepasse) VALUES(?, ?, ?)');
        $insert->execute(array($email, $pseudo, $mdphash));
        // Redirection vers la page d'accueil
    }
    public function connexion($email, $mdp)
    {
        $stmt = $this->pdo->prepare('SELECT * FROM membre WHERE mail = ?');
        $stmt->execute(array($email));
        $utilisateur = $stmt->fetch();
        if ($utilisateur && password_verify($mdp, $utilisateur['motdepasse'])) {
            $_SESSION['connecte'] = true;
            $_SESSION['membre'] = $utilisateur;
            $_SESSION['mail'] = $utilisateur['mail'];
            $_SESSION['mem_id'] = $utilisateur['mem_id'];
            return true;
        } else {
            return false;
        }
    }

    public function connexionAdmin($email) {
        $stmt = $this->pdo->prepare('SELECT mem_id FROM membre WHERE mail = ?');
        $stmt->execute(array($email));
        $admin= $stmt->fetch();
        if ($admin['id_admin'] == 1 ) {
            $_SESSION['admin'] = true;
            return true;
        } else {
            return false;
        }
    }





    public function registerUser(string $email, string $pseudo, string $password): bool
    {
        $hashedPassword = hash("sha256", $password);

        return $this->database->insert('membre', [
            'mail' => $email,
            'pseudo' => $pseudo,
            'motdepasse' => $hashedPassword,
            'exo' => 0,
        ]);
    }
}