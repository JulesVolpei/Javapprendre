<?php
session_start();
$conn = new PDO('sqlite:db/javapprendre.sqlite3');

// Récupération de la variable "data" envoyée par la fonction AJAX
$temps = $_POST['data'];
$pseudo = $_SESSION['pseudo'];

$tyty = $conn->prepare('select mem_id from membre where pseudo = :pseudo ');
$tyty->bindValue(':pseudo', $pseudo);
$tyty->execute();
$result = $tyty->fetch(PDO::FETCH_ASSOC);
$mem_id =  $result['mem_id'];


if ($temps != null) {
    // Insertion de la variable dans la base de données
    $query = $conn->prepare("SELECT * FROM score WHERE mem_id = :mem_id");
    $query->bindValue(':mem_id', $mem_id);
    $query->execute();
    $results = $query->fetch(PDO::FETCH_ASSOC);
    if ($results) {
        //met à jour si le temps est meilleur 
        $query = $conn->prepare("UPDATE score SET temps = :temps WHERE mem_id = :mem_id and temps > :temps");
        $query->bindValue(':temps', $temps);
        $query->bindValue(':mem_id', $mem_id);
        $query->execute();
    } else {
        //inserér le temps 
        $query = $conn->prepare("INSERT INTO score (temps, mem_id) VALUES (:temps, :mem_id)");
        $query->bindValue(':temps', $temps);
        $query->bindValue(':mem_id', $mem_id);
        $query->execute();
    }
}
header('location: tableau_score.php');
