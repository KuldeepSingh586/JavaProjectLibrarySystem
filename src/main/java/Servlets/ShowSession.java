package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import JSPBean.UserBean;
import static databaseCredentials.database.getConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IBM
 */
public class ShowSession extends HttpServlet {

    /**
     * Servlet that uses session tracking to keep per-client access counts. Also
     * shows other info about the session.
     */
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String heading;
        Integer accessCount
                = (Integer) session.getAttribute("accessCount");
        if (accessCount == null) {
            accessCount = new Integer(0);
            //
            ResultSet rs = null;
            Statement stmt = null;
            String executedQuery = "";
            Connection currentCon = getConnection();
            //preparing some objects for connection 

            String searchQuery
                    = "select username from login";

            try {
                stmt = currentCon.createStatement();
                rs = stmt.executeQuery(searchQuery);
                rs.next();
                executedQuery = rs.getString(1).substring(0, 1).toUpperCase();
                executedQuery = executedQuery + rs.getString(1).substring(1).toLowerCase();
                System.out.println(executedQuery);

            } catch (SQLException ex) {
                Logger.getLogger(ShowSession.class.getName()).log(Level.SEVERE, null, ex);
            }

            //
            heading = "Welcome, " + executedQuery + "";
        } else {
            heading = "Welcome Back";
            accessCount = new Integer(accessCount.intValue() + 1);
        }
        // Integer is an immutable data structure. So, you
        // cannot modify the old one in-place. Instead, you
        // have to allocate a new one and redo setAttribute.
        session.setAttribute("accessCount", accessCount);
        PrintWriter out = response.getWriter();
        String title = "Session Tracking Example";
        String docType
                = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                + "Transitional//EN\">\n";
        String str = (docType
                + "<HTML>\n"
                + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<CENTER>\n"
                + "<H1>" + heading + "</H1>\n"
                + "<H2>Information on Your Session:</H2>\n"
                + "<TABLE BORDER=1>\n"
                + "<TR BGCOLOR=\"#FFAD00\">\n"
                + " <TH>Info Type<TH>Value\n"
                + "<TR>\n"
                + " <TD>ID\n"
                + " <TD>" + session.getId() + "\n"
                + "<TR>\n"
                + " <TD>Creation Time\n"
                + " <TD>"
                + new Date(session.getCreationTime()) + "\n"
                + "<TR>\n"
                + " <TD>Time of Last Access\n"
                + " <TD>"
                + new Date(session.getLastAccessedTime()) + "\n"
                + "<TR>\n"
                + " <TD>Number of Previous Accesses\n"
                + " <TD>" + accessCount + "\n"
                + "</TABLE>\n"
                + "</CENTER></BODY></HTML>");
        out.print(str);
    }
}
