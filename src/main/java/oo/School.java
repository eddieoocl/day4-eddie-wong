package oo;

import java.util.ArrayList;
import java.util.List;

public class School {
    private final List<Person> people = new ArrayList<Person>();

    public void startSchool() {
        people.forEach(person -> {
            System.out.println(person.introduce());
        });
    }

    public void addPerson(Person person) {
        if (!people.contains(person)) {
            people.add(person);
        }
    }
}
