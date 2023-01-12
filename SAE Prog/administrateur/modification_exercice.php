<?php

//On commence la session
session_start();

$conn = new PDO('sqlite:../db/javapprendre.sqlite3');
$idExo = $_SESSION['id'];



if(ISSET($_POST['enregistrement'])){  //Vérifie si l'utilisateur a appuyé sur le bouton modification de l'exo
    //Initialisation des variables
	//On créé les variables 
    
	$nomExo = $_POST['nomExo'];
    $descriptionExo = $_POST['descriptionExo'];
    $req = $conn->query('UPDATE exos SET description_exo = "'.$nomExo.'" where id_exo = "'.$idExo.'"');
    $req = $conn->query('UPDATE exos SET nom_exo = "'.$descriptionExo.'" where id_exo = "'.$idExo.'"');

echo "Succès ! L'exercice vient d'être modifié. Redirection automatique dans 3 secondes ";


header("Refresh: 3;choix_exercice_admin.php");
}


if(ISSET($_POST['creer'])){ //Vérifie si l'utilisateur a appuyé sur le bouton créer l'exo
    $nom = $_POST['nom'];
    $description = $_POST['description'];
    $contenuExo = $_POST['contenu'];
    $filePath = "../javatests/" . $nom;
    $programFile = fopen($filePath, "w") or die("Unable to open file!");
    fwrite($programFile, $contenuExo);
    fclose($programFile); 
   
    $query = "INSERT INTO exos ( nom_exo,description_exo,text_de_base) VALUES ( :nom, :description, :contenu )"; //On insert dans la table exos le nom de l'exo, la description et le contenu
    $stmt = $conn->prepare($query);
    $stmt -> bindParam( ':nom', $nom);
    $stmt->bindParam(':contenu', $contenuExo);
    $stmt -> bindParam( ':description', $description);
    $stmt->execute();    
    
    echo "Succès ! L'exercice vient d'être créé. Redirection automatique dans 3 secondes ";

header("Refresh: 3;choix_exercice_admin.php");

}

if(ISSET($_POST['supprimer'])){ //Vérifie si l'utilisateur a appuyé sur le bouton supprimer l'exo
    $nom = $_POST['nom'];
    $description = $_POST['description'];
   
    $query = 'DELETE from exos where id_exo = "'.$idExo.'"';
    $stmt = $conn->prepare($query);
  
    $stmt->execute();    
    echo "Succès ! L'exercice vient d'être supprimé. Redirection automatique dans 3 secondes ";

header("Refresh: 3;choix_exercice_admin.php");

}