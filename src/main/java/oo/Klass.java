package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Klass {
    private Integer number;
    private Optional<Student> leader = Optional.empty();
    private final List<Person> attachedPeople = new ArrayList<>();

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
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
        attachedPeople.forEach(person -> {
            person.getRole().ifPresent(role -> System.out.printf("I am %s, %s of Class %d. I know %s become Leader.", person.getName(), role, this.getNumber(), student.getName()));
        });
    }

    public boolean isLeader(Student student) {
        return leader.filter(student::equals).isPresent();
    }

    public void attach(Person person) {
        if (this.attachedPeople.contains(person)) {
            return;
        }
        this.attachedPeople.add(person);
    }
}
