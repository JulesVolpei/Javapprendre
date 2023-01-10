<?php
session_start();
$conn = new PDO('sqlite:db/db_membre.sqlite3');
var_dump($_POST['temps']);
$temps = $_POST['temps'];

echo $temps;