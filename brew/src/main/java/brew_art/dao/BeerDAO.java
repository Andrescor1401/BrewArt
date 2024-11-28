package brew_art.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import brew_art.model.bean.Beer;
import brew_art.utilities.DataBaseConnection;

public class BeerDAO {
    
    private Connection getConnection(){
        return DataBaseConnection.getConnection();
    }


    public boolean registerBeer(Beer beer){
        PreparedStatement ps = null;
        Connection connect = getConnection();
        String sql = "INSERT INTO beer (ID_BEER, NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, beer.getIdBeer() );
            ps.setString(2, beer.getName());
            ps.setDouble(3, beer.getPrice());
            ps.setInt(4,beer.getQuantity());
            ps.execute();
            
            return true;

        } catch (SQLException e) {
            System.out.println("Register beer failed: " + e.getMessage());
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

    public boolean updateQuantity(Beer beer){
        PreparedStatement ps = null;
        Connection connect = getConnection();
        String sql = "UPDATE beer SET QUANTITY=? WHERE ID_BEER=?";
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, beer.getQuantity());
            ps.setLong(2, beer.getIdBeer());
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

    public boolean getBeer(Beer beer){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connect = getConnection();
        String sql = "SELECT * FROM beer WHERE ID_BEER=? ";  
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, beer.getIdBeer());
            rs = ps.executeQuery();
    
            if (rs.next()) {
                beer.setIdBeer(Integer.parseInt(rs.getString("ID_BEER")));
                beer.setName(rs.getString("NAME"));
                beer.setPrice(rs.getInt("PRICE"));
                beer.setQuantity(rs.getInt("QUANTITY"));
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
