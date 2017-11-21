package ua.golovchenko.artem.streamapi.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Artem on 21.11.2017.
 *
 * @author Artem Golovchenko
 */
public class Reduce1 {
    public static void main(String[] args) {

        /*
           Form 1: Optional<T> reduce(BinaryOperator<T> accumulator)
        */
        // reduce with int
        Stream<Integer> numbersStream = Stream.of(1,2,3,4,5,6);
        Optional<Integer> result = numbersStream.reduce((x, y)->x*y);
        System.out.println(result.get()); // 720


        //reduce with strings
        Stream<String> wordsStream = Stream.of("this", "is", "java","stream");
        Optional<String> sentence = wordsStream.reduce((x,y)->x + " " + y);
        System.out.println(sentence.get()); // this is java stream

        //reduce with list of strings
        List<String> wordsList = Arrays.asList("this", "is", "java", "stream");
        Optional<String> sentenceResult = wordsList.stream().reduce((x, y) -> x + " " + y);
        System.out.println(sentenceResult.get()); // this is java stream

        /*
           Form 2:  T reduce(T identity, BinaryOperator<T> accumulator)
        */

        //reduce with list of strings
        List<String> wordsList2 = Arrays.asList("this", "is", "java", "stream");
        String result2 = wordsList.stream().reduce("Result: ",(x, y) -> x + " " + y);
        System.out.println(result2); // Result: this is java stream
    }
}
