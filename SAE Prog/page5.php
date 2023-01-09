<?php

require_once 'conn.php';
try {
    $res = $conn -> query('select * from exos');
    $rows = $res->fetchAll(PDO::FETCH_ASSOC);
}

catch(PDOException $e)
{
    print("exception " . $e->getMessage());
}


  session_start();
  $idExo = $_GET['id'];

  function reset_code(){

    
  }
?>

<!DOCTYPE html>
<html>
    <head>
    <title>Page 5</title>
    <link rel =  "stylesheet" type = "text/css" href = "css/page4.css">
    <link rel =  "stylesheet" type = "text/css" href = "prism/prism.css">
    <link rel =  "stylesheet" type = "text/css" href = "css/page5.css">
    
    </head>
<body>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset=""utf-8>
    <title> Titre de la page </title>
</head>
<body>
    <!--Navigation bar -->
    <section class="navigation">
        <div class="nav-container">
          <div class="brand">
            <a href="#!">Logo</a>
          </div>
          <!--<nav>-->
            <!--<ul class="nav-list">
              <li> -->
                
                <div id = "nom_exo"><?php echo $idExo." ".$rows[$idExo]['nom_exo'] ; ?></div>
             <!-- </li>
              <li> -->
              <a href="#" class="bn14">Indice</a>
            <!--  </li>
            </ul> -->
        <!--  </nav> -->
        </div>
      </section>
     <!-- Form for inserting code --> 
    <div class = "form-code">
        <a href="#" class="brese" onclick = "javascript:reset_code();"> Reset </a>  
      
        <textarea id = "editing" spellcheck = "false" autocomplete = "off" oninput  = "update(this.value); sync_scroll(this);" onscroll="sync_scroll(this);" onkeydown="check_tab(this, event);"><?php echo $rows[$idExo]['text_de_base'] ?></textarea>
      <!-- Pre and code tags because otherwise we can not use Prism.js in a textarea-->
      
      <pre id = "highlighting" aria-hidden = "true"><code class = "language-java" id = "highlighting-content"></code></pre>
      
      <!-- Execute code button -->
      <a href = "#" class = "brese" onclick = "executeCode()">Run </a>

      </div>
    <!-- Rendu visuel -->
    <div class = "visuel"></div>
    <!-- Console -->          
    <div class="output">Output</div>
    <!-- Objectif -->
    <div class = "float-container">
    <div class = "objectif float-child"><?php echo $rows[$idExo]['objectif_exo'] ?></div>
    <!-- Tests unitaires-->
    <!--<div class = "test float-child">Tests</div> -->       
    <!--Tests unitaires -->
    </div>

    <script src = "js/page5.js"> </script>
    <!-- Script for Prism.js library -->
    <script src = "prism/prism.js"></script>
    <!-- JQUERY -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</body>
</html>