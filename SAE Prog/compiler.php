<?php
    $pdo = new PDO('sqlite:db/exos_database.db');

    try {
        $res = $pdo -> query('select * from exos');
        $rows = $res->fetchAll(PDO::FETCH_ASSOC);
    }

    catch(PDOException $e)
    {
        print("exception " . $e->getMessage());
    }
    //Getting data from web server
    $code = $_POST['code'];
    $idExo = $_POST['id'];
    $chemin_fichier_test = $rows[$idExo]['fichier_test'];
    //echo $code;
    //Opening java file
    $filePath = substr($chemin_fichier_test, 4);
    $programFile = fopen($filePath, "w")  or die("Unable to open file!");
    //Inserting code into java file
    fwrite($programFile, $code);
    fclose($programFile);
    /*compile*/
    //Compiling source file into a class file that can run on Java Virtual Machine
    shell_exec("javac ". $filePath);
    //Run code and put answer in the output div
    $output = shell_exec("java " . $filePath. " 2>&1"); 
    echo $output;
    
    shell_exec("javac ". $chemin_fichier_test);
    //Run code and put answer in the output div
    $output = shell_exec("java " . $chemin_fichier_test. " 2>&1"); 
    echo $output;
?>