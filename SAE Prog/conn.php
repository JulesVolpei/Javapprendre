<?php
	//regarde si la base de données est créée sinon on l'a créée
	if(!is_file('db/db_membre.sqlite3')){
		file_put_contents('db/db_membre.sqlite3', null);
	}
	// connexion à la base de données
	$conn = new PDO('sqlite:db/db_membre.sqlite3');
	//Paramètre attribut de connexion
	$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	//Query pour créer la table des membres dans la base de données si elle n'existe pas encore.
	$query = "CREATE TABLE IF NOT EXISTS membre(mem_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, mail TEXT, pseudo TEXT, motdepasse TEXT, exo TEXT)";
	//On execute query
	$conn->exec($query);
?>