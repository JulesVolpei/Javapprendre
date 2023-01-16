<?php
//starting the session
session_start();
if (!isset($_SESSION['pseudo'])) {
  header('Location: index.php');
  exit();
}

?>
<?php
//DEFINE PDO
$conn = new PDO('sqlite:db/javapprendre.sqlite3');
$pseudo = $_SESSION['pseudo'];
$tyty = $conn->prepare('select mem_id from membre where pseudo = :pseudo ');
$tyty->bindValue(':pseudo', $pseudo);
$tyty->execute();
$result = $tyty->fetch(PDO::FETCH_ASSOC);
$mem_id =  $result['mem_id'];

$progression = 'SELECT COUNT(id_exo) ti from score where mem_id = "'.$mem_id.'"';
$stmt = $conn->prepare($progression);
$stmt->execute();
$row = $stmt->fetch();
$count = $row['ti'];

$testo = 'select count(id_exo) compt from exos';
$tooo = $conn->prepare($testo);
$tooo->execute();
$roow = $tooo->fetch();
$couunt = $roow['compt'];


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
  <link rel="stylesheet" type="text/css" href="css/page4.css">
  <link rel="stylesheet" type="text/css" href="css/swiper.css">
  <script src="js/page4.js"></script>
  <link rel="stylesheet" href="css/test2.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.css" />
</head>

<body>
  <section class="navigation">
    <div class="nav-container">
      <a href="index.php"><img src="images/logo.png" alt="Logo"></a>
      
      <div class="bouttons">
         <a class="bn14">Progression :  <?php echo $count; ?>/<?php echo $couunt; ?> </a>
        <a href="formulaire/deconnexion.php" class="bn14">Déconnexion</a>
        <a href="administrateur/admin.php" class="bn14">Admin</a>
      </div>

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
          ' <a href="exercice.php?id=' . $x . '"><button class="learn-more" id="button1">
          <span class="circle" aria-hidden="true">
            <span class="icon arrow"></span>
          </span>
          <span class="button-text">voir exo</span>
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


  <div class="wrapper">
    <div id="cent">
      <a href="aPropos.html" class="bn14 btn-footer-right">À propos</a>
      <a href="https://github.com/JulesVolpei/Javapprendre" class="bn14 btn-footer-left">GitHub</a>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>

  <script src="js/swiper.js"></script>


  <div class="popup">
    <button id="close">&times;</button>
    <h2>Information </h2>
    <p>

      Bonjour <strong><?php echo htmlentities(trim($_SESSION['pseudo'])); ?> </strong> </h3> nous sommes heureux de vous (re)voir. Nous espérons que notre site vous permettra d'apprendre de nombreuses choses !
    </p>

  </div>
  <!--Script-->
  <script src="js/test2.js"></script>
</body>

</html>
