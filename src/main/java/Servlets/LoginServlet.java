package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author IBM
 */
import JSPBean.UserBean;
import LibrarySystem.UserDAO;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
// Create a session object if it is already not  created.
        HttpSession session = request.getSession(true);
      
  

        try {

            UserBean user = new UserBean();
            user.setUserName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            user = UserDAO.login(user);
            if (user.isValid()) {
                PrintWriter out = response.getWriter(); 
            out.println("<html><body onload=\"alert('Hello World')\"></body></html>");
            
                session.setAttribute("currentUser", user);
                response.sendRedirect("welcome.html"); //logged-in page
                

            } else {
                response.sendRedirect("invalidLogin.jsp"); //error page 
            }
           
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
