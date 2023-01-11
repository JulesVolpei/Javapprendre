<?php
session_start();
$conn = new PDO('sqlite:db/bd_marche.sqlite3');

// Récupération de la variable "data" envoyée par la fonction AJAX
$temps = $_POST['data'];
if ($temps != null) {
    // Insertion de la variable dans la base de données
    $query = $conn->prepare("INSERT INTO score (temps) VALUES (:temps)");
    $query->bindParam(':temps', $temps);
    $query->execute();
    header('Location: page5.php');
}
?>
