<?php
$erreur = "";
if (isset($A_vue['erreur'])) {
    $erreur = $A_vue['erreur'];
} else if (isset($A_vue['reussite'])){
    $erreur = $A_vue['reussite'];
}

?>
<!DOCTYPE html>

<html lang="fr">
<head>
    <title>Connexion</title>
    <link rel="icon" href="https://1000logos.net/wp-content/uploads/2020/09/Java-Emblem.jpg">
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="/css/formulaire.css"/>
</head>
<body>

<div class="col-md-3"></div>
<div class="col-md-6 well">
    <h3 class="text-primary">Connexion</h3>
    <hr style="border-top:1px dotted #ccc;"/>
    <!-- Lien pour s'inscrire -->
    <a href="index.php?url=Utilisateur/inscription">Pas encore inscrit ? S'inscrire...</a>
    <br style="clear:both;"/><br />
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <!-- Formulaire -->
        <form method="POST" action="index.php?url=ChoixExercice">

            <div class="form-group">

                <input type="mail" name="mail" class="form-control" required="required" />
                <label>Adresse mail</label>
            </div>
            <div class="form-group">

                <input type="password" name="motdepasse" class="form-controle" required="required"/>
                <span class="show">MONTRER</span>
                <label>Mot de passe</label>
            </div>
            <!---      <?php
            //Regarde si la session  'error' est set. Erreur si le pseudo et le mot de passe n'est pas valide.
          //  if(ISSET($_SESSION['erreur'])){
            //    ?>

               <div class="alert alert-danger"><?php // echo $_SESSION['erreur']?></div>
                <?php

              //  session_unset($_SESSION['erreur']);
     //       }
            ?>  --->
            <div class="button">
                <div class="inner"></div>
                <button class="btn btn-primary btn-block" name="login"><span class="glyphicon glyphicon-log-in"></span> Connexion</button>
        </form>
        <?php echo $erreur?>
    </div>
</div>
<script type="text/javascript" src="/js/motdepasse.js"></script>
</body>
</html>