package oo;

public class Teacher extends Person {
    private static final String ROLE = "teacher";

    public Teacher(final int id, final String name, final int age) {
        super(id, name, age, ROLE);
    }
}
