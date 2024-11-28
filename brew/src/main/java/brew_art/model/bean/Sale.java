package brew_art.model.bean;

import java.time.LocalDate;

public class Sale {

    private int idSale;
    private long idClient;
    private int idBeer;
    private LocalDate saleDate;
    private double totalAmount;
    private int earnedPoints;

    public Sale(int idSale, long idClient, int idBeer, double totalAmount, int earnedPoints){
        this.idSale = idSale;
        this.idClient = idClient;
        this.idBeer = idBeer;
        this.saleDate = LocalDate.now();
        this.totalAmount = totalAmount;
        this.earnedPoints = earnedPoints;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public int getIdBeer() {
        return idBeer;
    }

    public void setIdBeer(int idBeer) {
        this.idBeer = idBeer;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public int getEarnedPoints(){
        return earnedPoints;
    }
    public void setEarnedPoints(int earnedPoints){
        this.earnedPoints = earnedPoints;
    }

    @Override
    public String toString() {
        return "Sale [idSale=" + idSale + ", idClient=" + idClient + ", idBeer=" + idBeer + ", saleDate=" + saleDate
                + ", totalAmount=" + totalAmount + ", earnedPoints=" + earnedPoints + "]";
    }
    


    
}
