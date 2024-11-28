package brew_art.dao;
import brew_art.utilities.DataBaseConnection;
import brew_art.model.bean.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClientDAO {
    private Connection getConnection(){
        return DataBaseConnection.getConnection();
    }


    public boolean registerClient(Client client){
        PreparedStatement ps = null;
        Connection connect = getConnection();
        String sql = "INSERT INTO Client (idClient, name, mail, age,totalPoints) VALUES(?, ?, ?, ?,?)";
        try {
            ps = connect.prepareStatement(sql);
            ps.setLong(1, client.getIdClient() );
            ps.setString(2, client.getName());
            ps.setString(3, client.getMail());
            ps.setInt(4, client.getAge());
            ps.setInt(5, client.getTotalPoints());
            ps.execute();
            
            return true;

        } catch (SQLException e) {
            System.out.println("Register user failed: " + e.getMessage());
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

    public boolean updatePoints(Client client){
        PreparedStatement ps = null;
        Connection connect = getConnection();
        String sql = "UPDATE Client SET totalPoints=? WHERE idClient=?";
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, client.getTotalPoints());
            ps.setLong(2, client.getIdClient());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated >0;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                connect.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean getClient(Client client){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connect = getConnection();
        String sql = "SELECT * FROM client WHERE idClient=? ";  
        try {
            ps = connect.prepareStatement(sql);
            ps.setLong(1, client.getIdClient());
            rs = ps.executeQuery();
    
            if (rs.next()) {
                client.setIdClient((Long.parseLong(rs.getString("idClient"))));
                client.setName(rs.getString("name"));
                client.setMail(rs.getString("mail"));
                client.setAge(rs.getInt("age"));
                client.setTotalPoints(rs.getInt("totalPoints"));
                return true;
                }
                return false;
        } catch (SQLException e) {
                System.err.println(e);
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

    

