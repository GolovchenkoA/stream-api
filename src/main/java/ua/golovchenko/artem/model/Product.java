package ua.golovchenko.artem.model;

/**
 * Created by Artem on 21.11.2017.
 *
 * @author Artem Golovchenko
 */
public class Product {

    private static final int CHEAP = 50;

    private String name;
    private int price;
    private String owner;

    public Product(String name){
        this(name,0);
    }

    public Product(String name, int price){
        this(name,price, "");
    }

    public Product(String name, int price, String owner) {
        this.name = name;
        this.price = price;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isCheap(){
        return getPrice() < CHEAP;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "name: " + name
                + " price: " + price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
