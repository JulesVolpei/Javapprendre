<!DOCTYPE html>
<?php
//starting the session
session_start();

$idExo = $_GET['id'];
echo $idExo;
$_SESSION['id'] = $idExo;
?>

<head>
    <title>Modifier exercice </title>
    <link rel="icon" href="https://1000logos.net/wp-content/uploads/2020/09/Java-Emblem.jpg">
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" />
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/formulaire.css" />
</head>

<form method="POST" action="modification_exercice.php">
 

 <div class="button">
     <div class="inner"></div>
     <button name="supprimer"> Supprimer</button>