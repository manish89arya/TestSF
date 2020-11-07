package util;

import java.sql.*;

public class DbConnection implements SFConstants {

    public static void  SQLConnector() throws  ClassNotFoundException, SQLException {
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = SFConstants.DB_URL;

        //Database Username
        String username = SFConstants.DB_USERNAME;

        //Database Password
        String password = SFConstants.DB_PASSWORD;

        //Query to Execute
        String query = SFConstants.DB_QUERY;

        //Load mysql jdbc driver
        Class.forName(SFConstants.JDBC_DRIVER);

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String myName = rs.getString(1);
            String myAge = rs.getString(2);
            System. out.println(myName+"  "+myAge);
        }
        // closing DB Connection
        con.close();
    }
}