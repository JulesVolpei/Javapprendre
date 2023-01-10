var stopAlarme = true;
var centi = 0;
var sec = 0;
var min = 0;
var h = 0;
var loc;
var compt = 0;

function chrono() {
    centi++;
    centi * 10; //=======pour passer en dixièmes de sec
    //=== on remet à zéro quand on passe à 1seconde, 1min, 1heure, 1jour
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


        //======

        //================ On ajoute un zero pour avoir 1h01:05sec

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
        //===============

        var loc = h + ":" + min_ + ":" + sec_ + ":" + centi;
        var temps = min_ + ":" + sec_;
        //================= Pour que cela s'affiche dans l'élément "time"
        document.getElementById("time").innerHTML = temps;

        //=================lancement du chrono

        reglage = window.setTimeout("chrono();", 100);
    }

}
chrono();
$('.output').bind('DOMSubtreeModified', function() {
    var d = document.querySelector(".output");
    //console.log(d.innerHTML);
    if (d.innerHTML == "Exercice fini :)\n") {
        console.log("stop");
        stopAlarme = false;
        temps = "test";
        window.open('https://javascript.info');
        $.ajax({
            url: "score.php",
            type: "POST",
            data: { temps: temps },

        });



    }
});