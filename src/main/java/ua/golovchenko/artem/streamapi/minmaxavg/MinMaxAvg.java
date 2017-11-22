package ua.golovchenko.artem.streamapi.minmaxavg;

import ua.golovchenko.artem.model.Product;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Created by Artem on 22.11.2017.
 *
 * @author Artem Golovchenko
 */
public class MinMaxAvg {

    private  static List<Product> products = Arrays.asList(new Product("P1", 100), new Product("P2", 120), new Product("P3", 150));

    public static void main(String[] args) {
        //Get max price
        System.out.println("Product with max price: " + getMaxPrice(products.stream()));

        //Get min price
        System.out.println("Product with min price: " + getMinPrice(products.stream()));

        //Get avg price
        System.out.println("Products avg price: " + getAvgPrice(products));

    }

    private static Optional<Product> getMaxPrice(Stream<Product> products) {
        Function<Product,Integer> productPrice = product -> product.getPrice();
        return products.collect(maxBy(comparing(productPrice)));
    }

    private static Optional<Product> getMinPrice(Stream<Product> products) {
        Function<Product, Integer> productPrice = product -> product.getPrice();
        return products.collect(minBy(comparing(productPrice)));
    }

    private static OptionalDouble getAvgPrice(List<Product> products) {
        return products.stream().mapToInt(p -> p.getPrice()).average();
    }

}
