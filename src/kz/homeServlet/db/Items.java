package kz.homeServlet.db;


public class Items {

    private Long id;
    private String name;
    private double price;
    private int amount;
    private Countries country;

    public Items(){

    }

    public Items(Long id, String name, double price, int amount, Countries country) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.country = country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Countries getCountry() {
        return country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}



