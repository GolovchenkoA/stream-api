package ua.golovchenko.artem.model;

/**
 * Created by Artem on 21.11.2017.
 *
 * @author Artem Golovchenko
 */
public class Product {

    private String name;
    private int price;

    public Product(String name, int price){
        this.name=name;
        this.price=price;
    }

    public Product(String name){
        this.name=name;
        this.price = 0;
    }



    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "name: " + name
                + " price: " + price;
    }
}
