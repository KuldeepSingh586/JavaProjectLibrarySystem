package LibrarySystem;

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
import static databaseCredentials.database.getConnection;
import java.sql.*;

public class UserDAO {

    public static UserBean login(UserBean bean) {

        ResultSet rs ;
        Statement stmt;
        Connection currentCon = getConnection();
        //preparing some objects for connection 
        String username = bean.getUsername();
        String password = bean.getPassword();
        String searchQuery
                = "select * from login where username='"
                + username
                + "' AND password='"
                + password
                + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + username);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        try {
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                bean.setValid(false);
            } //if user exists set the isValid variable to true
            else if (more) {

                bean.setValid(true);
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } 
        return bean;
    }
}
