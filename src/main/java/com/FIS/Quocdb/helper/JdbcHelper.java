package com.FIS.Quocdb.helper;

import com.FIS.Quocdb.util.EnvUtil;

import java.sql.*;

public class JdbcHelper {
    static String user = EnvUtil.get("DB_USER");
    static String pass = EnvUtil.get("DB_PASSWORD");
    static String url = "jdbc:mysql://" + EnvUtil.get("DB_HOST") + ":" + EnvUtil.get("DB_PORT") + "/" + EnvUtil.get("DB_NAME") + "?serverTimezone=UTC";
    static String driver = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws Exception {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement stmt;
            if (sql.trim().startsWith("{")) {
                stmt = con.prepareCall(sql);
            } else {
                stmt = con.prepareStatement(sql);
            }

            for (int i = 0; i < args.length; i++) {
                stmt.setObject(i + 1, args[i]);
            }
            con.close();
            return stmt;
        }
    }

    static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                try {
                    con = DriverManager.getConnection(url, user, pass);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (con == null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet query(String sql, Object... args) throws Exception {
        PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
        return stmt.executeQuery();
    }

//    public static Object value(String sql, Object... args) {
//        try {
//            ResultSet rs = JdbcHelper.query(sql, args);
//            if (rs.next()) {
//                return rs.getObject(0);
//            }
//            rs.getStatement().getConnection().close();
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }

    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(DriverManager.getConnection(url, user, pass));
    }
}
