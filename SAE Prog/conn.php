<?php

	// connexion à la base de données
	$conn = new PDO('sqlite:../db/javapprendre.sqlite3');
	//Paramètre attribut de connexion
	$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	//Query pour créer la table des membres dans la base de données si elle n'existe pas encore.
	$query = "CREATE TABLE IF NOT EXISTS membre(mem_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, mail TEXT, pseudo TEXT, motdepasse TEXT, exo TEXT)";
	//On execute query
	$conn->exec($query);
?>