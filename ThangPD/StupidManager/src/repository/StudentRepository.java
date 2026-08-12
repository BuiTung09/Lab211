package repository;

import model.Student;
import java.util.ArrayList;

public class StudentRepository {

    private ArrayList<Student> ls = new ArrayList<>();

    public ArrayList<Student> getAll() {
        return ls;
    }

    public int getSize() {
        return ls.size();
    }

    public boolean isEmpty() {
        return ls.isEmpty();
    }

    public void addStudent(Student student) {
        ls.add(student);
    }

    public void deleteStudent(Student student) {
        ls.remove(student);
    }
}
