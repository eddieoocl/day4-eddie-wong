package oo;

import java.util.Optional;

public class Student extends Person {
    private static final String ROLE = "student";
    private Optional<Klass> klass = Optional.empty();

    public Student(final int id, final String name, final int age) {
        super(id, name, age, ROLE);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce();
        if (this.klass.isEmpty()) {
            return introduction;
        }
        if (this.klass.get().isLeader(this)) {
            return String.format("%s I am the leader of class %d.", introduction, klass.get().getNumber());
        }
        return String.format("%s I am in class %d.", introduction, klass.get().getNumber());
    }

    public void join(final Klass klass) {
        this.klass = Optional.of(klass);
    }

    public boolean isIn(final Klass klass) {
        return this.klass.map(value -> value.equals(klass)).orElse(false);
    }
}
