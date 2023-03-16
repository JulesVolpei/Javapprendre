<!DOCTYPE html>
<?php
//On commence la session
session_start();
$pdo = new PDO('sqlite:../db/javapprendre.sqlite3');
// Requête pour récupérer les données de la table
$idExo = $_GET['id'];
$_SESSION['id'] = $idExo;
$membres = $pdo->prepare('select nom_exo,description_exo,objectif_exo,text_de_base,fichier_test, numFichiersTests, fichier, indices from exos where id_exo = "' . $idExo . '" ');
$membres->execute();


//Récupération des données de l'exercice
$donneesExo = $membres->fetch(PDO::FETCH_ASSOC);
?>
<!doctype html>
<html lang="fr"> <!--Page de création d'exercice -->

<head>
    <meta charset="utf-8">  

    <title>Modifier exercice </title>
    <link rel="icon" href="../images/logo.ico">
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="../css/creation_modif.css" />
</head>

<body>
    <a href="../choix_exercice.php"><img src="../images/logo.png" alt="Logo" class="logo"></a>
    <form method="POST" action="creer_supp.php">

        <div class="all-container">

            <div class="left-flex-box">

                <div class="flex-container1">
                    <label for="nom">Titre de l'exercice:</label><br>
                    <textarea id="nom" name="nom" required="required"><?php echo $donneesExo['nom_exo']?> </textarea><br>
                </div>

                <div class="flex-container2">
                    <label for="description">Description de l'exercice:</label><br>
                    <textarea id="description" name="description" required="required"><?php echo $donneesExo['description_exo']?></textarea><br>

                </div>

                <div class="flex-container3">
                    <label for="objectifs">Objectifs de l'exercice:</label><br>
                    <textarea id="objectifs" name="objectifs" required="required"><?php echo $donneesExo['objectif_exo']?></textarea><br>
                </div>

                <div class="button">
                    <button name="modifier"> Confirmer la modification</button>
                </div>

            </div>

            <div class="right-flex-box">

                <div class="flex-container4">
                    <label for="contenu">Contenu de l'exercice:</label></br>
                    <textarea id="contenu" name="contenu" required="required"><?php echo $donneesExo['text_de_base']?></textarea><br>
                </div>

                <div class="flex-container5">
                    <label for="testsUnitaires">Tests unitaires:</label></br>
                    <textarea id="testsUnitaires" name="testsUnitaires" required="required"><?php echo $donneesExo['fichier_test']?></textarea><br>
                </div>

            </div>




        </div>
    </form>

</body>