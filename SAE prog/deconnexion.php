<?php
session_start();
session_unset(); 
session_destroy(); // On va detruire la session et ramener l'utilisateur au menu principal
header('Location: index.php');
exit();
?>
