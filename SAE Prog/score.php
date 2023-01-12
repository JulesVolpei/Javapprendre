<?php
session_start();
$conn = new PDO('sqlite:db/javapprendre.sqlite3');

// Récupération de la variable "data" envoyée par la fonction AJAX
$temps = $_POST['data'];
$email = $_POST['mail'];
$mem_id = $conn->prepare('select mem_id from membre where mail = :mail');
$mem_id->execute();
$test = $mem_id -> fetch();
if ($temps != null) {
    // Insertion de la variable dans la base de données
    $query = $conn->prepare("INSERT INTO score (temps, mem_id) VALUES (:temps, :mem_id)");
    $query->bindParam(':temps', $temps);
    $query->bindParam(':mem_id', $email);
    $query->execute();
    header('Location: tableau_score.php');
}
?>