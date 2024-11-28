package brew_art.model.service;

import brew_art.dao.BeerDAO;
import brew_art.model.bean.Beer;

public class BeerService {

    private BeerDAO beerDAO;

    public BeerService(BeerDAO beerDao){
        this.beerDAO = beerDao;
    }

    public Beer createBeer(int idBeer,String name,double price,int quantity){
        Beer newBeer = new Beer(idBeer,name, price, quantity);
        if(beerDAO.registerBeer(newBeer)){
            return newBeer;
        }
        return null;
    }

    public Beer getBeerById(int idBeer){
        Beer beerToSearch = new Beer();
        beerToSearch.setIdBeer(idBeer);
        if(beerDAO.getBeer(beerToSearch)){
            return beerToSearch;
        }
        return null;
    }

    public double getPrice(int idBeer ){
        BeerService beerService = new BeerService(beerDAO);
        Beer beer = beerService.getBeerById(idBeer);
        if(beer != null){
           return beer.getPrice(); 
        }
        return -1;
    }

    public boolean beerPrice(double priceBeer){
        if(priceBeer!= -1){
            return true;
        }
        return false;
    }

    public boolean purchaseBeer(int idBeer, int quantity){
        BeerService beerService = new BeerService(beerDAO);
        Beer beer = beerService.getBeerById(idBeer);
        if(beer!= null && beer.getQuantity() >= quantity){
            beer.setQuantity(beer.getQuantity()-quantity);
            return beerDAO.updateQuantity(beer);
        }
        throw new IllegalArgumentException("Not enough stock available ");
        
    }

    
}
