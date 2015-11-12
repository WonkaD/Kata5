package kata5;

import java.sql.*;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:kata5");

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE");
            while (rs.next()) {
                System.out.println("ID= " + rs.getInt("ID"));
                System.out.println("NAME= " + rs.getString("NAME"));
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Successfully!!");
    }

}
