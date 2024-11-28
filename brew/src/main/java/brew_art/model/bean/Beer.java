package brew_art.model.bean;

public class Beer {
    private int idBeer;
    private String name;
    private double price;
    private int quantity;

    public Beer(int idBeer, String name, double price,int quantity){
        this.idBeer = idBeer;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Beer(){}

    public int getIdBeer() {
        return idBeer;
    }

    public void setIdBeer(int idBeer) {
        this.idBeer = idBeer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Beer [idBeer=" + idBeer + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
    }
    
    
}
