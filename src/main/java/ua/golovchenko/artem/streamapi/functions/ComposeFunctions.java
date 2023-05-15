package ua.golovchenko.artem.streamapi.functions;

import java.util.function.Function;
import java.util.stream.Stream;

public class ComposeFunctions {

    public static void main(String[] args) {

        // result 3
        System.out.println(composeIntergers(2,
                x -> x * 2,
                x -> x + 5,
                x -> x / 3));

    }

    private static int composeIntergers(int value, Function<Integer, Integer>... functions) {
        Function<Integer, Integer> calls = Stream.of(functions).reduce(Function.identity(), Function::andThen);
        return calls.apply(value);
    }
}
