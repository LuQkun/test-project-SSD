import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        // ❌ Hardcoded credentials
        String dbUser = "admin";
        String dbPass = "123456";
        System.out.println("Database login user: " + dbUser + " pass: " + dbPass);

        // ❌ SQL Injection vulnerability
        String userInput = "1 OR 1=1"; // simulate user input
        String query = "SELECT * FROM users WHERE id = " + userInput;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", dbUser, dbPass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                System.out.println("User: " + rs.getString("username"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        // ❌ Insecure random usage
        double insecureRandom = Math.random();
        System.out.println("Insecure random: " + insecureRandom);
    }
}