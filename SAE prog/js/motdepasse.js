var input = document.querySelector('.form-controle');
var show = document.querySelector('.show');
var a = 0;
show.addEventListener('click', active);

function active() {
    if (input.type === "motdepasse") {
        input.type = "text";
        show.style.color = "#1DA1F2";
        show.textContent = "CACHER";
    } else {
        input.type = "motdepasse";
        show.textContent = "MONTRER";
        show.style.color = "#111";
    }
}

function active() {
    if (input.type === "motdepasse2") {
        input.type = "text";
        show.style.color = "#1DA1F2";
        show.textContent = "CACHER";
    } else {
        input.type = "motdepasse2";
        show.textContent = "MONTRER";
        show.style.color = "#111";
    }
}

//form validatetion
function validateForm() {
    var x = document.forms["myForm"]["mail"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
        alert("Votre adresse mail n'est pas valide");
        return false;
    }
}

/* --------------------------------------------------------------------------------------------- */
/* --------------------------------------------------------------------------------------------- */
/* --------------------------------------------------------------------------------------------- */
/* --------------------------------------------------------------------------------------------- */
/* --------------------------------------------------------------------------------------------- */
/* --------------------------------------------------------------------------------------------- */
/* --------------------------------------------------------------------------------------------- */



let parameters = {
    count: false,
    letters: false,
    numbers: false,
    special: false
}

let strengthBar = document.getElementById("strength-bar");
let msg = document.getElementById("msg");

function strengthChecker() {
    let password = document.getElementById("motdepasse").value;

    parameters.letters = (/[A-Za-z]+/.test(password)) ? true : false;
    parameters.numbers = (/[0-9]+/.test(password)) ? true : false;
    parameters.special = (/[!\"$%&/()=?@~`\\.\';:+=^*_-]+/.test(password)) ? true : false;
    parameters.count = (password.length > 7) ? true : false;
    parameters.uppercase = (/[A-Z]+/.test(password)) ? true : false;

    let barLength = Object.values(parameters).filter(value => value);

    console.log(Object.values(parameters), barLength);

    strengthBar.innerHTML = "";
    for (let i in barLength) {
        let span = document.createElement("span");
        span.classList.add("strength");
        strengthBar.appendChild(span);
    }

    let spanRef = document.getElementsByClassName("strength");
    for (let i = 0; i < spanRef.length; i++) {
        switch (spanRef.length - 1) {
            case 0:
                spanRef[i].style.background = "#ff3e36";
                msg.textContent = "Votre mot de passe est très faible";

                break;
            case 1:
                spanRef[i].style.background = "#ff691f";
                msg.textContent = "Votre mot de passe est faible";

                break;
            case 2:
                spanRef[i].style.background = "#ffda36";
                msg.textContent = "Votre mot de passe est moyen";

                break;
            case 3:
                spanRef[i].style.background = "#9FE855";
                msg.textContent = "Votre mot de passe est bon";
                break;
            case 4:
                spanRef[i].style.background = "#22780F";
                msg.textContent = "Votre mot de passe est fort";
                var a = a + 1;
                break;
        }
        /*if (a != 1) {
            alert("Votre mot de passe n'est pas assez fort !");
            return false;
        }*/
    }

}