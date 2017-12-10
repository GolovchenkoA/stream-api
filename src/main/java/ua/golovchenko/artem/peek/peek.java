package ua.golovchenko.artem.peek;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Artem on 10.12.2017.
 *
 * @author Artem Golovchenko
 */
public class peek {
    public static void main(String[] args) {

        List<String> strings = Stream.of("Badgers", "finals", "four")
                .filter(s -> s.length() >= 6).peek(s -> System.out.println(s))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());

        System.out.println(strings);

    }
}
