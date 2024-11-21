package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Klass {
    private Integer number;
    private Optional<Student> leader = Optional.empty();
    private final List<Person> observers = new ArrayList<>();

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public Optional<Student> getLeader() {
        return leader;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Klass klass = (Klass) obj;
        return this.number.equals(klass.number);
    }

    public void assignLeader(Student student) {
        if (!student.isIn(this)) {
            System.out.println("It is not one of us.");
        }
        leader = Optional.of(student);
        notifyObservers();
    }

    public void notifyObservers() {
        observers.forEach(person -> {
            person.update(this);
        });
    }

    public boolean isLeader(Student student) {
        return leader.filter(student::equals).isPresent();
    }

    public void attach(Person person) {
        if (this.observers.contains(person)) {
            return;
        }
        this.observers.add(person);
    }
}
