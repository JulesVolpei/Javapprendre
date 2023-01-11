<?php
	session_start();
	$conn = new PDO('sqlite:../db/bd_marche.sqlite3');
	if(ISSET($_POST['login'])){  //Initialisation des variables
		$pseudo = $_POST['pseudo']; //Affecte le post de pseudo (saisie de l'utilisateur) dans la variable pseudo
		$motdepasse = hash("sha256",$_POST['motdepasse']); //Mot de passe chiffré
		$_SESSION['pseudo'] = $_POST['pseudo'];
		
		$query = "SELECT COUNT(*) as count FROM `membre` WHERE `pseudo` = :pseudo AND `motdepasse` = :motdepasse";   
//Regarde si un pseudo ou mot de passe entré par l'utilisateur sont les mêmes que dans la base de données, si oui on les comptes et affecte le nombre à query 
		$stmt = $conn->prepare($query);
		$stmt->bindParam(':pseudo', $pseudo);
		$stmt->bindParam(':motdepasse', $motdepasse);
		$stmt->execute();
		$row = $stmt->fetch();
		
		$count = $row['count'];
		
		if($count > 0){     //Si count est supérieur à 0 alors son compte existe dans la base de donnée
			header('location:../choix_exercice.php');
		}else{ //Si count est égal à 0 alors son compte n'existe pas dans la base de donnée
			$_SESSION['erreur'] = "Votre pseudo ou mot de passe est invalide";
			header('location:connexion.php');
		}
	}
?>