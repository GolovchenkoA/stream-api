package ua.golovchenko.artem.java8new;

import java.util.Optional;

/**
 * Created by Artem on 21.11.2017.
 *
 * @author Artem Golovchenko
 */
public class OptionalType {

    public static void main(String[] args) {

        //isPresent True
        Optional<String> a = Optional.of("a");
        System.out.println("a isPresent: " + a.isPresent());

        //isPresent False
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);
        System.out.println("emptyOptional isPresent: " + emptyOptional.isPresent());
        System.out.println("alsoEmpty isPresent: " + alsoEmpty.isPresent());

        //orElse
        System.out.println("emptyOptional isPresent: " + emptyOptional.orElse("b"));
        System.out.println("alsoEmpty isPresent: " + alsoEmpty.orElseGet(() -> "c")); //better performance



    }
}
