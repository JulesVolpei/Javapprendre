<!DOCTYPE html>
<html>

<head>
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

    <script>
   $(function() {
    $( "#dialog-4" ).dialog({
       autoOpen: false, 
       modal: true,
       buttons: {
          OK: function() {$(this).dialog("close");}
       },
    });
    $( "#opener-4" ).click(function() {
       $( "#dialog-4" ).dialog( "open" );
    });
  });
  </script> 
<style>

ui-widget-header,.ui-state-default, ui-button {
    background:#b9cd6d;
    border: 1px solid #b9cd6d;
    color: #FFFFFF;
    font-weight: bold;
 }
</style>
</head>
<body>

<div id = "dialog-4" title = "DialogTitle">Jquery UI dialog</div>
<button id = "opener-4">Open dialog</button>
</body>
    </html>