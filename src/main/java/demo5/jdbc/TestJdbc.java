package demo5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by maxa on 12/23/2017.
 */
public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        try {
            System.out.println("Connecting to db");
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection succesfull");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
