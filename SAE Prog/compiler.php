<?php
    $pdo = new PDO('sqlite:db/javapprendre.sqlite3');

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
    $idExo = $_POST['id'] - 1;
    $index = $_POST['index'];
    //echo $code;
    $chemin_fichier_test = $rows[$idExo]['fichier_test'];

    $files = explode("\n", $chemin_fichier_test);
     
    $nouveau_chemin_fichier_test = $files[$index] . ".java";
    //Opening java file
    
    $filePath = $rows[$idExo]['fichier'];

    $filePath = "javatests/" . $filePath . ".java";
    $programFile = fopen($filePath, "w")  or die("Unable to open file!");
    //Inserting code into java file
    fwrite($programFile, $code);
    fclose($programFile);
    /*compile*/
    //Compiling source file into a class file that can run on Java Virtual Machine
    //shell_exec("javac ". $filePath);
    //echo $filePath;
    

    //$output = shell_exec("java " . $filePath. " 2>&1");
    //echo $output;
    $output = null;
    //Compiling source file into a class file that can run on Java Virtual Machine
    exec('javac ' .$filePath. ' && java '. $filePath, $output, $returnValue);
    if ($returnValue != 0) { //compilation error:
        //compiling and running again this time using shell_exec to output the error:
        shell_exec("javac ". $filePath);
        $output = shell_exec("java " . $filePath. " 2>&1");
        echo $output;
    } 
    else {
    $nouveau_chemin_fichier_test = "javatests/" . $nouveau_chemin_fichier_test;
    
    //Run code and put answer in the output div
    
    shell_exec("javac ". $nouveau_chemin_fichier_test);
  
    //Run code and put answer in the output div
    $output = shell_exec("java " . $nouveau_chemin_fichier_test. " 2>&1"); 
    echo $output;
    }
?>