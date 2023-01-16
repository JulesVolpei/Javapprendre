<?php

//On commence la session
session_start();

require_once '../conn.php';
//Mot de passe fort
function checkPasswordStrength($motdepasse)
{
	$uppercase = preg_match('@[A-Z]@', $motdepasse);
	$lowercase = preg_match('@[a-z]@', $motdepasse);
	$number = preg_match('@[0-9]@', $motdepasse);
	$specialChars = preg_match('@[^\w]@', $motdepasse);

	if ($uppercase && $lowercase && $number && $specialChars && strlen($motdepasse) >= 8) {
		return true;
	} else {
		return false;
	}
}
if (isset($_POST['enregistrement'])) {
	//On créé les variables 
	$mail = $_POST['mail'];
	$pseudo = $_POST['pseudo'];
	$motdepasse1 = hash("sha256", $_POST['motdepasse']);
	$motdepasse2 = hash("sha256", $_POST['motdepasse2']);
	$motdepasse3 = $_POST['motdepasse'];
	$reponse = $conn->prepare('SELECT COUNT(*) AS nbre_adresse_mail FROM membre WHERE mail=:mail');
	$reponse->execute(array('mail' => $mail));
	$donnees = $reponse->fetch();
	if (($motdepasse1 == $motdepasse2)) { //Si les 2 mots de passe sont les mÃªmes 
		$query = "INSERT INTO `membre` (mail, pseudo, motdepasse, exo) VALUES(:mail, :pseudo,:motdepasse, 0)";
		$stmt = $conn->prepare($query);
		$stmt->bindParam(':mail', $mail);
		$stmt->bindParam(':pseudo', $pseudo);
		$stmt->bindParam(':motdepasse', $motdepasse1);
	}


	if ($donnees['nbre_adresse_mail'] < 1) {
        if ($motdepasse1 == $motdepasse2) {
            if (checkPasswordStrength($motdepasse3)){
                if ($stmt->execute()) {
                    //On initialise les erreurs  et succès
                    $_SESSION['succes'] = "Compte créé avec succès";
                    header('location: ../formulaire/inscription.php');
                }
            } else {
                $_SESSION['erreur4'] = "Mot de passe faible, veuillez en choisir un autre.";
                header('location: ../formulaire/inscription.php');
            }
        }
        else {
            $_SESSION['erreur2'] = "Les 2 mots de passe sont différents "; //Si les mots de passe sont différents
            header('location: ../formulaire/inscription.php');
        }
    } else {
        $_SESSION['erreur3'] = "Vous avez déjà un compte associé à cette adresse mail"; //L'adresse mail existe déjà
        header('location: ../formulaire/inscription.php');
    }
}
