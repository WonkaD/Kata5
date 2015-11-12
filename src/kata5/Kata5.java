package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system","orcl");

            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:kata5");

            
            Statement stmt = c.createStatement();
            
            String fileName = "emails.txt";
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            
            String mail;
            while ((mail=reader.readLine())!=null){
                String query = "INSERT INTO MAILS  (MAIL) VALUES('"+ mail+ "')";
                stmt.executeUpdate(query);
            }
//            
//            ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE");
//            while (rs.next()) {
//                System.out.println("ID= " + rs.getInt("ID"));
//                System.out.println("NAME= " + rs.getString("NAME"));
//            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Successfully!!");
    }

}
