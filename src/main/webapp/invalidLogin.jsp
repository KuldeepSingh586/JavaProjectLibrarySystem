<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
    "http://www.w3.org/TR/html4/loose.dtd">

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Invalid User</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
          
            $(function () {
                $("#dialog-message").effect("shake", {times: 4}, 1000);
                $("#dialog-message").dialog({
                    modal: true,
                    width: 500,
                    buttons: {
                        Back: function () {
                            location.href = 'login.jsp';
                        }

                    }
                });
            });
            $(document).on('click', '.ui-dialog-titlebar-close', function () {
                location.href = 'login.jsp';
            });
        </script>
    </head>
    <body>

        <div id="dialog-message" title="Invalid User" >
            <p>
                <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
                Sorry, you are not a registered user!
            </p>
            <p>

            </p>
        </div>
</body>
</html>