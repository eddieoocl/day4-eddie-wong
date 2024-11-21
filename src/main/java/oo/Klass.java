package oo;

import java.util.Objects;
import java.util.Optional;

public class Klass {
    private Integer number;
    private Optional<Klass> klass = Optional.empty();
    private Optional<Student> leader = Optional.empty();

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
    }

    public boolean isLeader(Student student) {
        return leader.filter(student::equals).isPresent();
    }
}
