package ua.golovchenko.artem.streamapi.partitioningBy;

import ua.golovchenko.artem.model.Product;
import ua.golovchenko.artem.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Artem on 10.12.2017.
 *
 * @author Artem Golovchenko
 */
public class partitioningBy {
    private static List<Student> students = Arrays.asList(
            new Student("Ram", 18),
            new Student("Shyam",22),
            new Student("Mohan",19));

    private  static List<Product> products = Arrays.asList(
            new Product("P1", 49),
            new Product("P2", 120),
            new Product("P3", 150, "Owner1"),
            new Product("P3", 150, "Owner2"),
            new Product("P3", 150, "Owner2"));

    public static void main(String[] args) {

        //partition of Student on the basis of age
        Map<Boolean, List<Student>> stdByClass = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() > 20));

        stdByClass.forEach((k,v)-> System.out.println("Key:"+k+"  "+
                v.stream().map(Student::getName).collect(Collectors.joining(","))));

        // partition of Product by Price
        System.out.println(expensiveAndCheap(products.stream()));

        // Grouping products by owner
        System.out.println(groupByOwner(products.stream()));

        // Grouping products by owner (with replace blank owner field). Map
        System.out.println(groupByOwnerWithMap(products.stream()));

                // Grouping products by owner (with replace blank owner field). Peek
        System.out.println(groupByOwnerWithPeek(products.stream()));

    }

    // Private methods
    private static Map<Boolean, List<Product>> expensiveAndCheap(Stream<Product> products){
        return products.collect(Collectors.partitioningBy(Product::isCheap));
    }

    private static Map<String, List<Product>> groupByOwner(Stream<Product> products){
        return products.collect(Collectors.groupingBy(Product::getOwner));
    }

    private static Map<String, List<Product>> groupByOwnerWithMap(Stream<Product> products){
        return products.map(p -> {
            if (p.getOwner().isEmpty()) {
                p.setOwner("No owner");
            }
            return p;
        }).collect((Collectors.groupingBy(Product::getOwner)));
    }

    private static Map<String, List<Product>> groupByOwnerWithPeek(Stream<Product> products){
        return products.peek(p -> {
            if (p.getOwner().isEmpty()) {
                p.setOwner("No owner");
            }
        }).collect((Collectors.groupingBy(Product::getOwner)));
    }

}
