package brew_art.utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {

    public static Connection getConnection(){
        Connection connect = null;
        String bd = "cervezaartesanal";
        String url = "jdbc:mysql://localhost:3306/" + bd;
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful"); 
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed: " + e);
        }
        return connect;
    }

    


    
}
