<?php
session_start();
$pdo = new PDO('sqlite:db/javapprendre.sqlite3');
// Requête pour récupérer les données de la table

$membres = $pdo->prepare('select pseudo, temps from membre, score where membre.mem_id=score.mem_id ORDER BY temps ASC');
$membres->execute();

?>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title> Tableau de score </title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }

        th, td {
            border: 1px solid #3c6382;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #3c6382;
            color: white;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #d9edf7;
        }
        tr:nth-child(odd) {
            background-color: #ffffff;
        }

    </style>
</head>

<body>
    <table>
        <tr>
            <th>Pseudo</th>
            <th>Temps</th>
        </tr>
        <?php while ($test = $membres -> fetch() )
  { ?>
        <tr>
            <td><?= $test['pseudo'] ?></td>
            <td><?= $test['temps'] ?></td>
        </tr>
        <?php } ?>
    </table>
</body>

</html>

