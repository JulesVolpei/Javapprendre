<?php

//On commence la session
session_start();

$conn = new PDO('sqlite:../db/db_membre.sqlite3');

if (isset($_POST['enregistrement'])) {
	//On créé les variables 
	$mail = $_POST['mail'];
	$pseudo = $_POST['pseudo'];
	$motdepasse = hash("sha256",$_POST['motdepasse']);
    $motdepasse2 =  hash("sha256",$_POST['motdepasse2']);

	$reponse = $conn->prepare('SELECT COUNT(*) AS nbre_adresse_mail FROM membre WHERE mail=:mail');
	$reponse->execute(array('mail' => $mail));
	$donnees = $reponse->fetch();




	if (($motdepasse == $motdepasse2))  //Si les 2 mots de passe sont les mêmes 
		$query = "INSERT INTO `membre` (mail, pseudo, motdepasse, exo) VALUES(:mail, :pseudo,:motdepasse, 0)";
	$stmt = $conn->prepare($query);
	$stmt->bindParam(':mail', $mail);
	$stmt->bindParam(':pseudo', $pseudo);
	$stmt->bindParam(':motdepasse', $motdepasse);

	if ($donnees['nbre_adresse_mail'] < 1){
		if ($motdepasse == $motdepasse2) {
			if ($stmt->execute()) {

				//On initialise les erreurs  et succès
				$_SESSION['succes'] = "Compte créé avec succès";
				header('location: inscription.php');
			}
		} else {
			$_SESSION['erreur2'] = "Les 2 mots de passe sont différents "; //Si les mots de passe sont différents
			header('location: inscription.php');
		}
	} else {
		$_SESSION['erreur3'] = "Vous avez déjà un compte associé à cette adresse mail"; //L'adresse mail existe déjà
			header('location: inscription.php');
	}
	




}