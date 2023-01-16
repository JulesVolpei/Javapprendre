<?php
session_start();
$pdo = new PDO('sqlite:db/javapprendre.sqlite3');
// Requête pour récupérer les données de la table
$idExo = $_SESSION['id'] + 1;
$membres = $pdo->prepare('select pseudo, temps from membre, score where membre.mem_id=score.mem_id and id_exo = :id_Exo ORDER BY temps ASC');
$membres->bindParam("id_Exo", $idExo); // lié l'id de l'exercice à la requête
$membres->execute();
$res = $pdo->query('select * from exos'); // sélectionner toutes les données de la table exos
$rows = $res->fetchAll(PDO::FETCH_ASSOC);

?>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <link rel="icon" href="images/logo.ico">
    <title> Tableau de score </title>
    <meta name="Tableau des scores" content="Page de tableau des scores" />
    <link rel="stylesheet" type="text/css" href="css/tableau_score.css">

</head>

<body>
    <section class="navigation">
        <div class="nav-container">

            <div class="brand">
                <a href="choix_exercice.php"><img src="images/logo.png" alt="Logo"></a>

            </div>

            <div id="nom_exo">

                <?php


                echo $idExo  . ". " . $rows[$idExo - 1]['description_exo']; ?><!-- Affichage de l'id de l'exercice et de sa description -->
            </div>

        </div>
    </section>
    <table>
        <tr>
            <th>Pseudo</th>
            <th>Temps</th>
        </tr>
        <?php while ($test = $membres->fetch()) { ?>
            <tr>
                <td><?= $test['pseudo'] ?></td> <!-- affiche le pseudo du membre-->
                <td><?= $test['temps'] ?></td> <!-- affiche le temps du membre-->
            </tr>
        <?php } ?>
    </table>
</body>

</html>