package ua.golovchenko.artem.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Artem on 10.12.2017.
 *
 * @author Artem Golovchenko
 */
public class Audience {

    private String lecture;
    private List<Student> students;

    public Audience(String lecture) {
        this(lecture, Collections.EMPTY_LIST);
    }

    public Audience(String lecture, List<Student> students) {
        this.lecture = lecture;
        this.students = students;
    }

    public String getLecture() {
        return lecture;
    }
}
