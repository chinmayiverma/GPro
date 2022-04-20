package com.company;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private static Connection conn;
        public static Connection getConnection() throws SQLException {
            try{
                String myDriver="com.mysql.cj.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/tsm";
                Class.forName(myDriver);
                 conn = DriverManager.getConnection(myUrl,"root","root");

            }catch(Exception e){
                System.out.println(e);
            }
            return conn;
        }
    }

