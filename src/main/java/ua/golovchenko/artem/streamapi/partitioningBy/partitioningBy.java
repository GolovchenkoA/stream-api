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
            new Product("P3", 150));

    public static void main(String[] args) {

        //partition of Student on the basis of age
        Map<Boolean, List<Student>> stdByClass = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() > 20));

        stdByClass.forEach((k,v)-> System.out.println("Key:"+k+"  "+
                v.stream().map(Student::getName).collect(Collectors.joining(","))));

        // partition of Product by Price
        System.out.println(expensiveAndCheap(products.stream()));
    }


    private static Map<Boolean, List<Product>> expensiveAndCheap(Stream<Product> products){
        return products.collect(Collectors.partitioningBy(Product::isCheap));
    }
}
