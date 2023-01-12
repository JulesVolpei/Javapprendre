<?php
session_start();
$conn = new PDO('sqlite:../db/javapprendre.sqlite3');

$utilisateur = $_SESSION['pseudo'];


$compte = $conn->query("SELECT COUNT(*) as compte  FROM admin, membre WHERE admin.mem_id = membre.mem_id and membre.pseudo = '" . $utilisateur . "'");
//On compte le nombre de personnes qui ont le même id que la table admin

$row = $compte->fetch();
$admin = $row['compte'];

if ($admin > 0) { //Si $admin est supérieur à 0 alors c'est un admin
    header('location:choix_exercice_admin.php');
} else { //Si admin est égal à 0 alors ce n'est pas un admin
    echo "Erreur : Vous n'êtes pas un admin. Vous allez être redirigé dans 3 secondes ";

    header("Refresh: 3;../choix_exercice.php");
}




?>