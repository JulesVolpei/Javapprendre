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


<form method="POST" action="modification_exercice.php"> <!--Petit formulaire pour la modification de l'exercice-->

    <div class="form-group">

        <input type="mail" name="nomExo" class="form-control" required="required" />
        <label>Nom de l'exercice</label>
    </div>
    <div class="form-group">

        <input type="text" name="descriptionExo" class="form-control" required="required" />
        <label>Description de l'exercice</label>
    </div>
    <div class="button">
        <div class="inner"></div>
        <button name="enregistrement"> Confirmer modification</button>
     

        