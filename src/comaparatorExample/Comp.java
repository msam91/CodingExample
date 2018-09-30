package comaparatorExample;

import java.util.Comparator;

public class Comp implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        if (s1.name.compareTo(s2.name) > 0) {
            return 1;
        }
        else
            return -1;
    }

}
