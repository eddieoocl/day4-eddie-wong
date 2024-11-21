package oo;

public class Student extends Person {
    private static final String ROLE = "student";

    public Student(final int id, final String name, final int age) {
        super(id, name, age, ROLE);
    }
}
