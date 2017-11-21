package ua.golovchenko.artem.streamapi.ordered;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by Artem on 22.11.2017.
 *
 * @author Artem Golovchenko
 */
public class Ordered {

    public static void main(String[] args) {

        //numbers and sameOrder can have different ordering
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));
        List<Integer> sameOrder = numbers.stream().collect(toList());


        //numbers ordered from 1 to 4
        List<Integer> realSameOrder = numbers.stream()
                                         .sorted()
                                         .collect(toList());



        // If the input is not ordered, then the output is also not ordered
        List<Integer> numbers2 = asList(1, 2, 3, 4);
        List<Integer> stillOrdered = numbers2.stream()
                .map(x -> x + 1)
                .collect(toList());

        //assertEquals(asList(2, 3, 4, 5), stillOrdered);
        
        Set<Integer> unordered = new HashSet<>(numbers2);
        List<Integer> stillUnordered = unordered.stream()
                .map(x -> x + 1)
                .collect(toList());

        //        assertThat(stillUnordered, hasItem(2));
        //        assertThat(stillUnordered, hasItem(3));
        //        assertThat(stillUnordered, hasItem(4));
        //        assertThat(stillUnordered, hasItem(5));



    }
}
