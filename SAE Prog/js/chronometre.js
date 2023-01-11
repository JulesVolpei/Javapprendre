var stopAlarme = true;
var centi = 0;
var sec = 0;
var min = 0;
var h = 0;
var loc;
var compt = 0;

function chrono() {
    centi++;
    //Passage en dixièmes de secondes
    centi * 10;
    //Remise à zéro lorsque 1 seconde, 1 minute, 1 heure, 1 jour est atteinte
    if (stopAlarme == true) {
        if (centi > 9) {
            centi = 0;
            sec++;
        }

        if (sec > 59) {
            sec = 0;
            min++;
        }

        if (min > 59) {
            min = 0;
            h++;
        }

        // Ajout d'un zéro pour avoir 1h01:05sec
        if (sec < 10) {
            var sec_ = "0" + sec;
        } else {
            var sec_ = sec;
        }

        if (min < 10) {
            var min_ = "0" + min;
        } else {
            var min_ = min;
        }

        // Mise à jour de la variable loc avec le temps courant
        loc = h + ":" + min_ + ":" + sec_ + ":" + centi;

        var temps = min_ + ":" + sec_;
        // Affichage du temps dans l'élément HTML avec l'id "time"
        document.getElementById("time").innerHTML = temps;

        // Lancement du chrono toutes les 10 centièmes de seconde
        reglage = window.setTimeout(chrono, 100);
    }
}

$('.output').bind('DOMSubtreeModified', function() {
    var d = document.querySelector(".output");
    if (d.innerHTML == "Exercice fini :)\n") {
        console.log("stop");
        stopAlarme = false;
        // Envoie du temps réel chronométré dans la requête AJAX
        $.ajax({
            type: "POST",
            url: "./score.php",
            data: { data: loc },
            success: function(response) {
                console.log(response);
            }
        });
        setTimeout(function(){ 
            window.open('score.php'); 
        }, 3000); // redirection après 3 secondes
    }
});
chrono();
