/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author IBM
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("login.jsp").include(request, response);
            HttpSession session = request.getSession();
            session.invalidate();
            out.print("<html><head>"
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

        }
    }
}
