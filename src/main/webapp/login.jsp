<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Library Management System</title>



        <!--<script src="http://code.jquery.com/jquery.min.js"></script>-->
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>

        <aside>
            <img src="admin-logo.gif" alt="img"/>
        </aside>

    <center>
        <img src="Library management.png" alt="img">
    </center>
    <section>
        <!-- form name="main" method="post" action="rs/user/add" -->
        <div id="loginForm">
            <form action="LoginServlet">
                <label for="username">User Name</label>
                <input type="text" id="username" name="username"/><br><br>

                <label for="password">Password &nbsp;&nbsp;</label>
                <input type="text" name="password" id="password"/><br><br>

                <input type="submit" value="Login" id="loginButton"/>
                <input type="hidden" name="sessionid" value="12345">
            </form>
        </div>
        <!-- /form -->



    </div>
</section>
<%
    out.println("Your IP address is " + request.getRemoteAddr());
%>
<footer>&copy;Kuldeep Singh</footer>

</body>
</html>