<?php
session_start();
final class ControleurUtilisateur {

    public function connexionAction() {
        if (isset($_SESSION['connecte']) && $_SESSION['connecte']) {
        // Charge la vue pour l'utilisateur connecté
        $membre = $_SESSION['membre'];
        $pseudo = $membre['pseudo'];
        Vue::montrer('ChoixExercice/voir');
    } else {
        // Redirige l'utilisateur vers la page de connexion
        Vue::montrer("Utilisateur/connexion");
    }
    }

    public function inscriptionAction() {
        Vue::montrer('Utilisateur/inscription');
    }

    public function traitementConnexionAction() {
            $O_Connexion = new Utilisateur();
            $mail = $_POST['mail'];
            $mdp = $_POST['motdepasse'];
            if ($O_Connexion->connexion($mail, $mdp)) {
                Vue::montrer('ChoixExercice/voir');

            } else {
                Vue::montrer('Utilisateur/connexion', array('erreur' => 'Nom d\'utilisateur ou mot de passe incorrect'));

            }
    }
    public function deconnexionAction() {
        // Gérer la déconnexion de l'utilisateur ici
        $_SESSION['connecte'] = false;
        session_destroy();
        // Redirection vers la page d'accueil
        Vue::montrer('Utilisateur/connexion');
    }

    public function traitementInscriptionAction(array $urlParameters, array $A_postParams = null)
    {
        $pseudo = $A_postParams['pseudo'];
        $email = $A_postParams['mail'];
        $mdp = $A_postParams['motdepasse'];
        $mdpConfirme =  $A_postParams['motdepasse2'];

        $O_Inscription = new Utilisateur();
        if ($O_Inscription->estValide($pseudo, $email, $mdp, $mdpConfirme)){
            if ($O_Inscription->checkPasswordStrength($mdp)){
            $O_Inscription->verificationEmail($email);
            $O_Inscription->inscription($email, $mdp, $pseudo );
            // Enregistrement réussi, rediriger l'utilisateur vers la page de connexion
                $_SESSION['pseudo'] = $pseudo;
                Vue::montrer("Utilisateur/connexion", array('reussite'=> 'Compte crée avec succès'));

        }
        else {
            Vue::montrer("Utilisateur/inscription", array('erreur'=> 'Mot de passe pas assez fort (il faut que la barre soit verte foncée ^^)'));
        }}
        else
         {
            // Enregistrement échoué, afficher un message d'erreur
            Vue::montrer("Utilisateur/inscription", array('erreur'=> 'Erreur lors de l\'inscription'));
        }

    }

}
