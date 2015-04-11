/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package databaseCredentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kuldeep
 
public class database {

    /**
     * Provides a Connection to the Xampp "c0648442" DataBase Created connection
     * in getConnection Method Created product Table in dataBase
     *
     * @return - the connection object or null if a connection failed
     * @throws java.sql.SQLException
     
   
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.print("Driver not found" + ex.getMessage());
        }
        String hostname = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        String jdbc = "jdbc:mysql://" + hostname + ":" + port + "/librarymgmtsys";
        return DriverManager.getConnection(jdbc, username, password);

    }

}
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseCredentials;

import java.sql.*;

/**
 *
 * @author Kuldeep
 */
public class database {

    /**
     * Provides a Connection to the Xampp "c0648442" DataBase
     * Created connection in getConnection Method
     * Created product Table in dataBase
     * @return - the connection object or null if a connection failed
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbc = "jdbc:mysql://localhost/librarymanagementsystem";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(jdbc, user, pass);
            String query = "SELECT * FROM login";

        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("No class found Exception" + ex.getMessage());
        }
        return conn;
    }
}
