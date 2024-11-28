package brew_art.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import brew_art.model.bean.Admin;
import brew_art.model.bean.Client;
import brew_art.utilities.DataBaseConnection;

public class AdminDAO {

    private Connection getConnection(){
        return DataBaseConnection.getConnection();
    }

     public boolean registerAdmin(Admin admin){
        PreparedStatement ps = null;
        Connection connect = getConnection();
        String sql = "INSERT INTO admin (ID_ADMIN, NAME, AGE, PASSWORD) VALUES(?, ?, ?, ?)";
        try {
            ps = connect.prepareStatement(sql);
            ps.setLong(1, admin.getIdAdmin() );
            ps.setString(2, admin.getName());
            ps.setInt(3, admin.getAge());
            ps.setInt(4, admin.getPassword());
            ps.execute();
            
            return true;

        } catch (SQLException e) {
            System.out.println("Register admin failed: " + e.getMessage());
            return false;
        }finally{
            try {
                if(connect != null){
                    connect.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " +e.getMessage() );
            }
        }


    }


    public boolean getAdmin(Admin admin){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connect = getConnection();
        String sql = "SELECT * FROM admin WHERE ID_ADMIN=? AND PASSWORD=? ";  
        try {
            ps = connect.prepareStatement(sql);
            ps.setLong(1, admin.getIdAdmin());
            ps.setInt(2, admin.getPassword());
            rs = ps.executeQuery();
    
            if (rs.next()) {
                admin.setIdAdmin(Long.parseLong(rs.getString("ID_ADMIN")));
                admin.setName(rs.getString("NAME"));
                admin.setAge(rs.getInt("AGE"));
                admin.setPassword(rs.getInt("PASSWORD"));
                return true;
                }
                return false;
        } catch (SQLException e) {
                System.err.println("Something failed with: " +e);
                return false;
            } finally {
                try {
                    connect.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
    }


}
