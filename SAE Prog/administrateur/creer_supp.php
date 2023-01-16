<?php

//On commence la session
session_start();

$conn = new PDO('sqlite:../db/javapprendre.sqlite3');
$idExo = $_SESSION['id'];


if(ISSET($_POST['creer'])){ //Vérifie si l'utilisateur a appuyé sur le bouton créer l'exo
    $nom = $_POST['nom'];
    $description = $_POST['description'];
    $contenuExo = $_POST['contenu'];
    $obj = $_POST['objectifs'];
    $test = $_POST['testsUnitaires'];
    $nom_test = "Test" . $nom;
    $filePath = "../javatests/" . $nom . ".java";
    $filesPath = "../javatests/" . "Test" . $nom . ".java"; 
    $programFile = fopen($filePath, "w") or die("Unable to open file!");
    $programFiles = fopen($filesPath, "w") or die("Unable to open file!");
    fwrite($programFile, $contenuExo);
    fwrite($programFiles, $test);
    fclose($programFile);
    fclose($programFiles);
   
    $query = "INSERT INTO exos ( nom_exo,description_exo,objectif_exo,text_de_base,fichier_test, numFichiersTests, fichier) VALUES ( :nom, :description, :objectifs ,:contenu, :nom_test, 1, :nom)"; //On insert dans la table exos le nom de l'exo, la description et le contenu
    $stmt = $conn->prepare($query);
    $stmt -> bindParam( ':nom', $nom);
    $stmt -> bindParam( ':description', $description);
    $stmt -> bindParam( ':objectifs', $obj);
    $stmt->bindParam(':contenu', $contenuExo);
    $stmt -> bindParam( ':nom_test', $nom_test);
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