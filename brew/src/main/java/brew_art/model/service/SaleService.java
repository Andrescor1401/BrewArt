package brew_art.model.service;
import brew_art.model.bean.Sale;

import brew_art.dao.SaleDAO;

public class SaleService {
    private SaleDAO saleDAO;
    public SaleService(SaleDAO saleDAO){
        this.saleDAO = saleDAO;
    }

    public Sale createSale(int idClient,int idBeer, int price, int quantity){
        double totalAmount = totalAmount(price, quantity);
        int earnedPoints = earnedPoints(totalAmount);
        Sale newSale = new Sale(0,idClient, idBeer, totalAmount, earnedPoints);
        if(saleDAO.registerSale(newSale)){
            return newSale;
        }
        return null;
    }

    public int earnedPoints(double totalAmount){
        return (int)(totalAmount/10000);
    }
    public double totalAmount(int price,int quantity){
        return price * quantity;
    }
    
    /*Falta configurar el metodo para actualizar los puntos del cliente cada que realice una compra, 
    lo estas imaginando de tal forma que al momento de realizar la compra con el id del cliente se cree un 
    objeto cliente temporal y buscar el cliente en la base de datos para cuando lo encuentre hacerle un set 
    a los puntos obtenidos. check
    Y te falta crear un metodo para traerte la informacion de la cerveza al momento de realizar una compra, 
    especificamente el precio y validar que la cantidad a escoger no supere al stock del inventario. 

    Mira si quieres hacer test con junit y ve pensando en ese front que estas como perdido con eso. 
    */

    /*public static void main(String[] args) {
        SaleService sale = new SaleService(null);
        int salepoints = sale.earnedPoints(210000);
        double amount = sale.totalAmount(15000, 4);
        System.out.println("los puntos obtenidos son: " +amount);
    }*/
}


