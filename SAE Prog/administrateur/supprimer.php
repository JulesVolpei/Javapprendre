

<!DOCTYPE html>
<?php
//On commence la session
session_start();

$idExo = $_GET['id'];
$_SESSION['id'] = $idExo;
?>

<head>
    <title>Modifier exercice </title>
    <link rel="icon" href="../images/logo.ico">
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" />
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="../css/supprimer.css" />
</head>

<form method="POST" action="creer_supp.php">
 

 <div class="button">
     <button name="supprimer"> Confirmer la suppression</button>
 </div>