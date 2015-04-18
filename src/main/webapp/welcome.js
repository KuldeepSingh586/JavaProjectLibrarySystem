/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
var num=0;
   
   $openit= $("#sessionData").dialog({
                    autoOpen: false,
                    height: 500,
                   
                    width: 700,
                    modal: true,
                    draggable: false,
                    show: "slide",
                    runEffect:"pulsate"
                });
    
   $("#loginButton").click(function() {
      
  
        $openit.dialog("open");
        alert("dgxgvzv");
  
                $.ajax({
                    type: "GET",
                    url: 'http://localhost:8080/librarymanagementsystem/ShowSession',
                    success: function (data) {
                      $("#sessionData").html(data);
                    }

              });
});  

});  


<html><head>"
                    + "<script src=\"https://code.jquery.com/jquery-1.10.2.js\"></script>\n"
                    + "        <script src=\"https://code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\n"
                    + "        <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">"
                    + " <script>$(function() {\n"
                    + "        $(\"#dialog-message\").effect(\"shake\", {times: 4}, 1000);\n"
                    + "        $(\"#dialog-message\").dialog({\n"
                    + "            modal: true,\n"
                    + "            width: 500,\n"
                    + "            buttons: {\n"
                    + "                Back: function() {\n"
                    + "                    window.location.replace('login.jsp');\n"
                    + "                }\n"
                    + "\n"
                    + "            }\n"
                    + "        });\n"
                    + "    });</script>"
                    + "</head>"
                    + "<body>"
                    + "<div id=\"dialog-message\" title=\"Status\">\n"
                    + "    \n"
                    + "    <p>You are successfully logged out!<p>\n"
                    + "    </div></body></html>");
