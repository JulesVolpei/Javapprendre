<?php
//starting the session
session_start();
?>
<!DOCTYPE html>
<html lang="fr">

<head>
	<title>Inscription</title>
	<link rel="icon" href="../images/logo.ico">
	<link rel="icon" href="https://1000logos.net/wp-content/uploads/2020/09/Java-Emblem.jpg">
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="Inscription" content="Page d'inscription de notre site" />
	<link rel="stylesheet" type="text/css" href="../css/formulaire.css" />
</head>

<body>


	<div class="col-md-3"></div>
	<div class="col-md-6 well">
		<h3 class="text-primary">Inscription</h3>
		<hr style="border-top:1px dotted #ccc;" />

		<a href="connexion.php">Déjà inscrit ? Se connecter...</a>
		<br style="clear:both;" /><br />
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<!-- Formulaire d'inscription -->
			<form method="POST" name="myForm" onsubmit="return validateForm();" action="inscription_membre.php">

				<div class="form-group">

					<input type="text" name="mail" class="form-control" required="required" />
					<label>Adresse mail</label>
				</div>
				<div class="form-group">

					<input type="text" name="pseudo" class="form-control" required="required" />
					<label>Pseudo</label>
				</div>

				<div class="form-group">
					<input type="password" id="motdepasse" name="motdepasse" class="form-controle" required="required" oninput="strengthChecker()"><span class="show">MONTRER</span>
					<label>Mot de passe</label>
					<div id="strength-bar"></div>
					<p id="msg"></p>
				</div>

				<div class="form-group">

					<input type="password" id="motdepasse2" name="motdepasse2" class="form-controle" required="required" />
					<span class="show">MONTRER</span>
					<label>Confirmation Mot de passe</label>

				</div>

				<?php
				$_SESSION['pseudo'] = $_POST['pseudo'];
				//Regarde si la session  'succes' est set. Succes est le message lors du succè d'inscription
				if (isset($_SESSION['succes'])) {
				?>
					<!-- Afficher le message de réussite de l'enregistrement -->
					<div class="alert alert-success"><?php echo $_SESSION['succes'] ?></div>


				<?php
					//Annulation de la session 'succès' après l'affichage du message. 
					unset($_SESSION['succes']);
				}
				?>
				<?php

				//Regarde si la session  'erreur2' est set. Erreur2 est le message d'erreur lorsqu'il y a 2 mot de passe différents.
				if (isset($_SESSION['erreur2'])) {
				?>
					<!-- Afficher le message de réussite de l'enregistrement -->
					<div class="alert alert-success"><?php echo $_SESSION['erreur2'] ?></div>


				<?php

					unset($_SESSION['erreur2']);
				}
				?>

				<?php

				//Regarde si la session  'erreur3' est set. Erreur3 est le message d'erreur lorsqu'il y a déjà l'email mis dans la base de donnée 
				if (isset($_SESSION['erreur3'])) {
				?>
					<!-- Afficher le message de réussite de l'enregistrement -->
					<div class="alert alert-success"><?php echo $_SESSION['erreur3'] ?></div>


				<?php

					unset($_SESSION['erreur3']);
				}
				?>

				<?php

				//Regarde si la session  'erreur3' est set. Erreur3 est le message d'erreur lorsqu'il y a déjà l'email mis dans la base de donnée 
				if (isset($_SESSION['erreur4'])) {
				?>
					<!-- Afficher le message de réussite de l'enregistrement -->
					<div class="alert alert-success"><?php echo $_SESSION['erreur4'] ?></div>


				<?php

					unset($_SESSION['erreur4']);
				}
				?>

				<div class="button">
					<div class="inner"></div>
					<button name="enregistrement"> S'enregistrer</button>
				</div>
			</form>
		






		</div>
	</div>



		<script type="text/javascript" src="../js/motdepasse.js"></script>

</body>


</html>