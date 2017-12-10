package ua.golovchenko.artem.streamapi.counting;

import ua.golovchenko.artem.model.Audience;
import ua.golovchenko.artem.model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Artem on 10.12.2017.
 *
 * @author Artem Golovchenko
 */
public class Counting {

    private static List<Student> musicAudience;
    private static List<Student> mathAudience;
    private static List<Student> chemistryAudience;

    public static void main(String[] args) {

        Student garry = new Student("Garry", 17);
        Student megan = new Student("Megan", 20);
        Student janet = new Student("Janet", 19);

        chemistryAudience = asList(garry, janet);
        mathAudience = asList(garry, megan, janet);
        musicAudience = asList(garry, megan);

        List<List> audiences = asList(chemistryAudience, mathAudience, musicAudience);

        // Goal: How many subjects does the student study

        System.out.println("garry: " + countOfAudience(audiences.stream(), garry));
        System.out.println("megan: " + countOfAudience(audiences.stream(), megan));

        Audience music = new Audience("Oleg Skripka", musicAudience);
        Audience math = new Audience("Albert Einstein", mathAudience);
        Audience chemistry = new Audience("Albert Einstein", chemistryAudience);

        // Goal: how many subjects the lecturer teaches
        System.out.println(countOfAudiencesByLecturer(asList(music, math, chemistry).stream()));

/*      Example from book

        // Old style
        Map<Artist, List<Album>> albumsByArtist
                = albums.collect(groupingBy(album -> album.getMainMusician()));
        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for(Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }

        //Functional style
        public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
            return albums.collect(groupingBy(album -> album.getMainMusician(),
                    counting()));
        }
        */
    }

    private static Long countOfAudience(Stream<List> audiences, Student student){
        return audiences.filter( audience -> audience.contains(student)).count();
        }

    private static Map<String, Long> countOfAudiencesByLecturer(Stream<Audience> audiences){
        return audiences.collect(groupingBy(Audience::getLecture, counting()));
    }
}
