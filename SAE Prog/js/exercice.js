var text_base;

function update(text) {
    let result_element = document.querySelector("#highlighting-content");
    // Handle final newlines
    if (text[text.length - 1] == "\n") { // If the last character is a newline character
        text += " "; // Add a placeholder space character to the final line 
    }
    result_element.innerHTML = "";
    //Update code
    result_element.innerHTML = text.replace(/</g, "&lt;").replace(/>/g, "&gt;");
    //Syntax Highlight
    Prism.highlightElement(result_element);
}

/* Function to reset to base code */
function reset_code() {
    //document.getElementById("editing").innerHTML = text_base;
    //document.getElementById("editing").innerHTML = "";
    //console.log(document.getElementById("editing").innerHTML);
    document.getElementById("editing").value = text_base;
    console.log(document.getElementById("editing").innerHTML);
    console.log("text de base reset:");
    console.log(text_base);
    update(document.getElementById("editing").innerHTML);
}

/*
We used both a <pre><code> tag and a textarea for the syntax 
highlighting. The inner Text on the <pre><code> tag changes on input.
Used css and javascript to make it look like we are editing only one element
*/

window.onload = function() {
    var nom = document.getElementById("nom_exo").innerText.substring(12).split(' ').join('');
    var image = document.querySelectorAll(".visuel")[0];
    image.style.backgroundImage = "url(images/" +nom+ ".png)";
    text_base = document.getElementById("editing").value;
    console.log(text_base);
    let result_element = document.querySelector("#highlighting-content");
    let text = document.querySelector("#editing").innerHTML;
    // Handle final newlines (see article)
    if (text[text.length - 1] == "\n") { // If the last character is a newline character
        text += " "; // Add a placeholder space character to the final line 
    }

    //Syntax Highlight
    result_element.innerHTML = text.replace(/</g, "&lt;").replace(/>/g, "&gt;");
    //console.log(text.length);
    //console.log(result_element.innerHTML.length);
    //text_base = document.querySelector("#editing").innerHTML;
    //console.log("Text de base:");
    //console.log(text_base);
    Prism.highlightElement(result_element);
}

function sync_scroll(element) {
    /* Scroll result to scroll coords of event - sync with textarea */
    let result_element = document.querySelector("#highlighting");
    // Get and set x and y
    result_element.scrollTop = element.scrollTop;
    result_element.scrollLeft = element.scrollLeft;
}


function check_tab(element, event) {
    let code = element.value;
    if (event.key == "Tab") {
        /* Tab key pressed */
        event.preventDefault(); // stop normal
        console.log(code);
        let before_tab = code.slice(0, element.selectionStart); // text before tab
        let after_tab = code.slice(element.selectionEnd, element.value.length); // text after tab
        let cursor_pos = element.selectionEnd + 1; // where cursor moves after tab - moving forward by 1 char to after tab
        console.log(after_tab.length);
        console.log(after_tab === "");
        console.log(before_tab === "");
        /*if(!(after_tab === "") && !(before_tab === ""))
        {
          element.value = before_tab +"\t" +  after_tab; // add tab char
            console.log("adding tab");
        }*/
        element.value = before_tab + "\t" + after_tab; // add tab char
        console.log("adding tab");
        // move cursor
        element.selectionStart = cursor_pos;
        element.selectionEnd = cursor_pos;
        update(element.value); // Update text to include indent
    }
}

function executeCode(index, e) {
    console.log(index);
    $.ajax({
        url: "./compiler.php",
        method: "POST",
        data: {
            code: document.getElementById("highlighting-content").innerText,
            id: document.getElementById("nom_exo").innerText.split(' ')[0],
            index: index
        },

        success: function(response) {
            $(".output").text(response)
            var nom = document.getElementById("nom_exo").innerText.substring(12).split(' ').join('');
            console.log(nom);
            var image = document.querySelectorAll(".visuel")[0];
            var t = document.getElementById("test-"+index);
            if(nom != "Pirate")
            {
            if (response == "Le test est bon\n") {
                image.style.backgroundImage = "url(images/" + nom + "Success.png)";
                if(t != null)
                {    
                    t.classList.remove("x");
                    t.classList.add("tick");
                }

            } 
            else if(response != "Exercice fini :)\n"){
                image.style.backgroundImage = "url(images/" + nom + "Fail.png)";
                if(t != null)
                {   
                    t.classList.remove("tick");
                    t.classList.add("x");
                }
                
            }
            else if(response == "Exercice fini :)\n")
            {
                image.style.backgroundImage = "url(images/" +nom+ ".png)";
            }
        }
    }
    })
}
