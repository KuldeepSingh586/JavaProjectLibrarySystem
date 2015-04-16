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



