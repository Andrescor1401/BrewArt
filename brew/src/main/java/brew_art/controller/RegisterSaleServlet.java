package brew_art.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brew_art.dao.BeerDAO;
import brew_art.dao.ClientDAO;
import brew_art.dao.SaleDAO;
import brew_art.model.bean.Sale;
import brew_art.model.service.BeerService;
import brew_art.model.service.ClientService;
import brew_art.model.service.SaleService;

public class RegisterSaleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String idClientParam = request.getParameter("idClient"); 
        String idBeerParam = request.getParameter("idBeer"); 
        String priceParam = request.getParameter("price");
        String quantityParam = request.getParameter("quantity");
        if (idClientParam == null || idBeerParam == null || priceParam == null || quantityParam == null ) { 
            response.getWriter().println("Datos faltantes"); 
            return;
        }
        try {
        int idClient = Integer.parseInt(idClientParam);
        int idBeer = Integer.parseInt(idBeerParam);
        int price = Integer.parseInt(priceParam);
        int quantity = Integer.parseInt(quantityParam);
        int totalAmount = price * quantity;
        int pointsEarned = (int)totalAmount/10000; 
        BeerDAO beerDAO = new BeerDAO();
        BeerService beerService = new BeerService(beerDAO);
        SaleDAO saleDAO = new SaleDAO();
        ClientDAO clientDAO = new ClientDAO();
        ClientService clientService = new ClientService(clientDAO);
        SaleService saleService = new SaleService(saleDAO);
        Sale newSale = saleService.createSale(idClient,idBeer,price,quantity);
        boolean updatePoints = clientService.updatePointsClient(idClient, pointsEarned);
        boolean bearDeleted = beerService.purchaseBeer(idBeer, quantity);
        if(newSale!= null && updatePoints && bearDeleted){
            response.getWriter().println("Sale registered");
        }else{
            response.getWriter().println("Error en la compra o en la actualización de puntos");
        }
            
        } catch (NumberFormatException e) {
            // TODO: handle exception
         response.getWriter().println("Formato de datos inválido"); 
        }

    } 
}
