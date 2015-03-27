/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author du
 */
public class MyConnection {
    public static Connection getConnection(){
        Connection connec=null;
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connec= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TheCake","sa","123");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connec;
    }
    
}
