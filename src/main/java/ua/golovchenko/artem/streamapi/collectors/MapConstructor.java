package ua.golovchenko.artem.streamapi.collectors;

import ua.golovchenko.artem.model.Product;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by Artem on 22.11.2017.
 *
 * @author Artem Golovchenko
 */
public class MapConstructor {

    public static void main(String[] args) {

        // create new products with map
        Map<String, Integer> products = new HashMap<>();
        products.put("Product 1", 150);
        products.put("Product 2", 250);
        products.put("Product 3", 350);

       // List<Product> productList = products.entrySet().stream().map((i) -> new Product(i.getKey(), i.getValue())).collect(Collectors.toCollection(asList()))
        List<Product> productList = products.entrySet().stream().map((i) -> new Product(i.getKey(), i.getValue())).collect(Collectors.toList());
        System.out.println(productList);

        // create new products with map Classname::new
        Set<String> namesSet = new HashSet<>(asList("Product 1", "Product 2"));
        List<Product> productsSet = namesSet.stream().map(Product::new).collect(Collectors.toList());
        System.out.println(productsSet);
    }
}
