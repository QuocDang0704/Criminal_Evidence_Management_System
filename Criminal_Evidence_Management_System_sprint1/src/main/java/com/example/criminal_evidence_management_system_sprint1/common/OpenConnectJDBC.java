package com.example.criminal_evidence_management_system_sprint1.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnectJDBC {
    private final static String URL = "jdbc:mysql://localhost:3306/jdbc_demo";
    private final static String USER_NAME = "root1";
    private final static String PASSWORD = "QuocFPT@$#2022";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException ex){
            ex.getMessage();
            return null;
        }
    }
}
