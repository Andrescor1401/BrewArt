package brew_art.dao;
import brew_art.utilities.DataBaseConnection;
import brew_art.model.bean.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaleDAO {

    private Connection getConnection(){
        return DataBaseConnection.getConnection();
    }

    public boolean registerSale(Sale sale){
        PreparedStatement ps = null;
        Connection connect = getConnection();
        String sql = "INSERT INTO sale (ID_CLIENT, ID_BEER, SALE_DATE, TOTAL_AMOUNT,EARNED_POINTS) VALUES(?, ?, ?, ?,?)";
        try {
            ps = connect.prepareStatement(sql);
            ps.setLong(1, sale.getIdClient() );
            ps.setInt(2, sale.getIdBeer());
            ps.setDate(3, java.sql.Date.valueOf(sale.getSaleDate()));
            ps.setDouble(4, sale.getTotalAmount());
            ps.setInt(5, sale.getEarnedPoints());
            ps.execute();
            
            return true;

        } catch (SQLException e) {
            System.out.println("Sale failed: " + e.getMessage());
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

    

    
}
