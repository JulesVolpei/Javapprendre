<!DOCTYPE html>
<?php
//On commence la session
session_start();
?>
<!doctype html>
<html lang="fr"> <!--Page de création d'exercice -->

<head>
    <meta charset="utf-8">  

    <title>Créer exercice </title>
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
                    <textarea id="nom" name="nom" required="required"></textarea><br>
                </div>

                <div class="flex-container2">
                    <label for="description">Description de l'exercice:</label><br>
                    <textarea id="description" name="description" required="required"></textarea><br>

                </div>

                <div class="flex-container3">
                    <label for="objectifs">Objectifs de l'exercice:</label><br>
                    <textarea id="objectifs" name="objectifs" required="required"></textarea><br>
                </div>

                <div class="button">
                    <button name="creer"> Confirmer la création</button>
                </div>

            </div>

            <div class="right-flex-box">

                <div class="flex-container4">
                    <label for="contenu">Contenu de l'exercice:</label></br>
                    <textarea id="contenu" name="contenu" required="required"></textarea><br>
                </div>

                <div class="flex-container5">
                    <label for="testsUnitaires">Tests unitaires:</label></br>
                    <textarea id="testsUnitaires" name="testsUnitaires" required="required"></textarea><br>
                </div>

            </div>




        </div>
    </form>

</body>