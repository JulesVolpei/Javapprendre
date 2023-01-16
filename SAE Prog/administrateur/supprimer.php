

<!DOCTYPE html>
<?php
//starting the session
session_start();

$idExo = $_GET['id'];
$_SESSION['id'] = $idExo;
?>

<head>
    <title>Modifier exercice </title>
    <link rel="icon" href="https://1000logos.net/wp-content/uploads/2020/09/Java-Emblem.jpg">
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" />
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="../css/supprimer.css" />
</head>

<form method="POST" action="creer_supp.php">
 

 <div class="button">
     <button name="supprimer"> Confirmer la suppression</button>
 </div>