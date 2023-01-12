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


  session_start();
  $idExo = $_GET['id'];
  $numFichiersTests = $rows[$idExo]['numFichiersTests'];
    //getting all the test files as a single string:
  
  $chemin_fichier_test = $rows[$idExo]['fichier_test'];
  //splitting the test files into an array:
  $files = explode("\n", $chemin_fichier_test);

?>

<!DOCTYPE html>
<html>
    <head>
    <title>Exercice</title>
    <link rel =  "stylesheet" type = "text/css" href = "css/page4.css">
    <link rel =  "stylesheet" type = "text/css" href = "prism/prism.css">
    <link rel =  "stylesheet" type = "text/css" href = "css/exercice.css">
    
    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script>
   var n = "<?php echo"$numFichiersTests"?>";
   for(let i = 0; i < n; ++i)
    {
      //console.log("#dialog-"+i);
      //console.log($("dialog-"+i));
      $(function() {
      $( "#dialog-"+i).dialog({
       autoOpen: false, 
       modal: true,
       draggable: false,
       height: 600,
       width: 600,
       resizeable: false,
       buttons: {
          OK: function() {$(this).dialog("close");}
       },
    });
    $( "#opener-"+i).click(function() {
      console.log("clicked");
       $( "#dialog-"+i).dialog( "open" );
    });
  });
}
  </script>
    </head>
<body>
<body>
    <!--Navigation bar -->
    <section class="navigation">
        <div class="nav-container">
          
          <div class="brand">
            <a href="#!">Logo</a>
          </div>
          
           <div name="affi" id="time"></div>  
          <div id = "nom_exo">
            <?php echo $idExo." ".$rows[$idExo]['nom_exo'] ; ?>
          </div>

         

          <div id = "dialog-4" title = "Indice exo">
            <?php echo $rows[$idExo]['indice'] ; ?>
          </div>

     
                
                <!--<a href="#" class="bn14">Indice</a>-->
        </div>
      </section>
     <!-- Form for inserting code --> 
    <div class = "form-code">
        <a href="#" class="brese" onclick = "javascript:reset_code();"> Reset </a>  
      
        <textarea id = "editing" spellcheck = "false" autocomplete = "off" oninput  = "update(this.value); sync_scroll(this);" onscroll="sync_scroll(this);" onkeydown="check_tab(this, event);"><?php echo $rows[$idExo]['text_de_base'] ?></textarea>
      <!-- Pre and code tags because otherwise we can not use Prism.js in a textarea-->
      
      <pre id = "highlighting" aria-hidden = "true"><code class = "language-java" id = "highlighting-content"></code></pre>
      
     <!-- Execute code button -->
     <a href = "#" class = "brese" onclick = "executeCode(0, this)">Run </a>

      </div>
    <!-- Rendu visuel -->
    <div class = "visuel"></div>
    <!-- Console -->          
    <div class="output">Output</div>
    <!-- Objectif -->
    <div class = "float-container">
    <div class = "objectif float-child"><?php echo $rows[$idExo]['objectif_exo'] ?></div>
    <!-- Tests unitaires-->
   <div class = "test float-child">
   <?php 
      for($x = 1; $x < $numFichiersTests; ++$x)
        { 
          echo '<br><div class = "test-child">Test ' . $files[$x] .'<div id = "dialog-'.$x.'" title = "Indice exo"></div> <button id = "opener-'.$x.'" class = "bn15">Voir indice</button><button class = "bn15" onclick = "executeCode('.$x. ', this)">Run</button></div><br>';
        }
      ?>

    </div>       
    <!--Tests unitaires -->
    </div>

    <script src = "js/exercice.js"> </script>
    <script src = "js/chronometre.js"> </script>
    <!-- Script for Prism.js library -->
    <script src = "prism/prism.js"></script>
    <!-- JQUERY -->
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>-->

</body>
</html>