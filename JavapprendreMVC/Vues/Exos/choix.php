<?php echo $_SESSION['membre']['pseudo'] ?>
<form action="index.php?url=Utilisateur/deconnexion" method="post">
    <button type="submit" name="logout">Se déconnecter</button>
</form>