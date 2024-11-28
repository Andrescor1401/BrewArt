package brew_art.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import brew_art.dao.BeerDAO;
import brew_art.model.service.BeerService;
import brew_art.model.bean.Beer;

public class BeerServlet extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String idBeerParam = request.getParameter("idBeer"); 
        String nameBeerParam = request.getParameter("nameBeer"); 
        String priceBeerParam = request.getParameter("price");
        String quantityParam = request.getParameter("quantity");
        if (idBeerParam == null || nameBeerParam == null || priceBeerParam == null || quantityParam==null) { 
            response.getWriter().println("Datos faltantes"); 
            return;
        }
        try {
        int idBeer = Integer.parseInt(idBeerParam);
        double priceBeer = Double.parseDouble(priceBeerParam);
        int quantity = Integer.parseInt(quantityParam);
        BeerDAO beerDAO = new BeerDAO();
        BeerService beerService = new BeerService(beerDAO);
        Beer newBeer = beerService.createBeer(idBeer,nameBeerParam,priceBeer,quantity);
        if(newBeer!= null){
            response.getWriter().println("Beer added");
        }else{
            response.getWriter().println("Datos invalidos");
        }
            
        } catch (NumberFormatException e) {
            // TODO: handle exception
         response.getWriter().println("Formato de datos inválido"); 
        }

    }    
}
