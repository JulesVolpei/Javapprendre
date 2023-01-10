<?php
//starting the session
session_start();
if (!isset($_SESSION['pseudo'])) {
  header('Location: ../index.php');
  exit();
}
?>
<?php
//DEFINE PDO
$conn = new PDO('sqlite:../db/db_membre.sqlite3');
try {
  $res = $conn->query('select * from exos');
  $rows = $res->fetchAll(PDO::FETCH_ASSOC);
  //get length of rows:
  $number_of_rows = count($rows);
  $index = 0;
} catch (PDOException $e) {
  print("exception " . $e->getMessage());
}
?>

<!DOCTYPE html>
<html lang="fr">

<head>
<link rel="icon" href="https://1000logos.net/wp-content/uploads/2020/09/Java-Emblem.jpg">
  <title>Exercice</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width = device-width, initial-scale = 1.0">
  <title>Page 4</title>
  <link rel="stylesheet" type="text/css" href="../css/page4.css">
  <link rel="stylesheet" type="text/css" href="../css/swiper.css">
  <script src="../js/page4.js"></script>
  <link rel="stylesheet" href="../css/test2.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.css" />
</head>

<body>
  <section class="navigation">
    <div class="nav-container">
      <div class="brand">
        <a href="../index.php">Logo</a>
      </div>
      <nav>
        <ul class="nav-list">
          <li>
          <form method="POST" action="modification_exercice.php">
            <a href="creer.php" name= "test" class="bn14 creer-exo">Créer exo</a>
          </form>
          </li>
          <li>
            <a href="../formulaire/deconnexion.php" class="bn14">Déconnexion</a>
        

          </li>
        </ul>
      </nav>
    </div>
  </section>
  <!-- Slider main container -->
  <div class="swiper-container">
    <!-- Additional required wrapper -->
    <div class="swiper-wrapper">
      <!-- Slides -->
      <?php
      for ($x = 0; $x < $number_of_rows; ++$x)
        echo '<div class = "swiper-slide c1">' . $rows[$x]['nom_exo'] . '<br>' . '<br>' . '<br>' . $rows[$x]['description_exo'] . '<br><br><br><br><br><br><br><br><br><br><br><br>' .
          ' <a href="modifier.php?id='.$rows[$x]['id_exo'].'"><button class="learn-more" id="button1">
              <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
              </span>
              <span class="button-text">Modifier</span>
              </button>
              </a>
              
              <a href="../page5.php?id='.$x.'"><button class="learn-more" id="button1">
              <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
              </span>
              <span class="button-text">voir exo</span>
              </button>
              </a>
              <a href="supprimer.php?id='.$rows[$x]['id_exo'].'"><button class="learn-more" id="button1">
              <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
              </span>
              <span class="button-text">Supprimer</span>
              </button>
              </a>'
          . '</div>'
      ?>
    </div>

    <!-- If we need pagination -->
    <div class="swiper-pagination"></div>

    <!-- If we need navigation buttons -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
  </div>

  <a href="#" class="custom-btn btn-5">Voir tous les exercices</a>
  <div class="wrapper">
    <div id="cent">
      <a href="../aPropos.html" class="bn14 btn-footer-right">À propos</a>
      <a href="https://github.com/JulesVolpei/Javapprendre" class="bn14 btn-footer-left">GitHub</a>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>

  <script src="../js/swiper.js"></script>


  <div class="popup">
    <button id="close">&times;</button>
    <h2>Admninistration </h2>
    <p>
 
    Bonjour <strong><?php echo htmlentities(trim($_SESSION['pseudo']) ); ?> </strong> </h3>vous avez maintenant le grade <strong>Admninistrateur</strong>. Vous avez la possibilité de créer des exercices. <strong><?php echo htmlentities(trim($_SESSION['exo']) ); ?> </strong>
    </p>

  </div>
  <!--Script-->
  <script src="../js/test2.js"></script>
</body>

</html>