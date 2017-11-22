package ua.golovchenko.artem.streamapi.collectors;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.util.stream.Collectors.toCollection;

/**
 * Created by Artem on 22.11.2017.
 *
 * @author Artem Golovchenko
 */
public class ChangeCollectionClass {

    public static void main(String[] args) {

        // change implementation
        Set<String> hashSet = new HashSet<>();

        System.out.println("hashSet instanceof HashSet: " + (hashSet instanceof HashSet));
        Set<String> treeSet = hashSet.stream().collect(toCollection(TreeSet::new));

        System.out.println("treeSet instanceof HashSet: " + (treeSet instanceof HashSet));
        System.out.println("treeSet instanceof TreeSet: " + (treeSet instanceof TreeSet));
    }
}

