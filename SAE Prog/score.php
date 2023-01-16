<?php
session_start();
$conn = new PDO('sqlite:db/javapprendre.sqlite3');

// Récupération de la variable "data" envoyée par la fonction AJAX
$temps = $_POST['data'];
$pseudo = $_SESSION['pseudo'];
$id_Exo = $_SESSION['id'];

$tyty = $conn->prepare('select mem_id from membre where pseudo = :pseudo ');
$tyty->bindValue(':pseudo', $pseudo);
$tyty->execute();
$result = $tyty->fetch(PDO::FETCH_ASSOC);
$mem_id =  $result['mem_id'];


if ($temps != null) {
    // Selection de la variable dans la base de données
    $query = $conn->prepare("SELECT * FROM score WHERE mem_id = :mem_id");
    $query->bindValue(':mem_id', $mem_id);
    $query->execute();
    $results = $query->fetch(PDO::FETCH_ASSOC);
    $quest = $conn->prepare("SELECT id_exo FROM score WHERE id_exo = :id_exo");
    $quest->bindValue(':id_exo', $id_Exo);
    $quest->execute();
    $resultss = $quest->fetch(PDO::FETCH_ASSOC);
    if (!$results || !$resultss) {
        //inserér le temps 
        $query = $conn->prepare("INSERT INTO score (id_exo, temps, mem_id) VALUES (:id_exo, :temps, :mem_id)");
        $query->bindValue(':temps', $temps);
        $query->bindValue(':id_exo', $id_Exo + 1);
        $query->bindValue(':mem_id', $mem_id);
        $query->execute();
    }
}
header('location: tableau_score.php');
