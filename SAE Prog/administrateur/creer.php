<!DOCTYPE html>
<?php
//starting the session
session_start();
?>

<head>
    <title>Créer exercice </title>
    <link rel="icon" href="https://1000logos.net/wp-content/uploads/2020/09/Java-Emblem.jpg">
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="../css/creation_modif.css" />
</head>

<body>
    <form method="POST" action="modification_exercice.php">

                <div class="all-container">

                    <div class="left-flex-box">

                        <div class="flex-container1">
                            <label for="nom">Titre de l'exercice:</label><br>
                            <textarea id="nom" name="nom" required="required"></textarea><br>
                        </div>

                        <div class="flex-container2">
                            <label for="description">Description de l'exercice:</label><br>
                            <textarea id="description" name="description"
                                required="required"></textarea><br>

                        </div>

                        <div class="flex-container3">
                            <label for="objectifs">Objectifs de l'exercice:</label><br>
                            <textarea id="objectifs" name="objectifs"
                                required="required"></textarea><br>
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
                            <textarea id="testsUnitaires" name="testsUnitaires"
                                required="required"></textarea><br>
                        </div>

                    </div>




                </div>
    </form>

</body>