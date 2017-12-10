package ua.golovchenko.artem.streamapi.joining;

import ua.golovchenko.artem.model.Student;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by Artem on 10.12.2017.
 *
 * @author Artem Golovchenko
 */
public class Joining {
    private static final String DELIM = ",";
    private static final String PREFIX = "[";
    private static final String POSTFIX = "]";

    private static List<Student> audience = asList(new Student("Garry", 17), new Student("Megan", 20));

    public static void main(String[] args) {
        // Simple joining
        String result = audience.stream().map(Student::getName).collect(Collectors.joining());
        System.out.println(result);

        // Joining with delimiter
        String result2 = audience.stream().map(Student::getName).collect(Collectors.joining(DELIM, PREFIX, POSTFIX));
        System.out.println(result2);

    }
}
