package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private static final String ROLE = "teacher";
    private final List<Klass> klasses = new ArrayList<>();

    public Teacher(final int id, final String name, final int age) {
        super(id, name, age, ROLE);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce();
        if (this.klasses.isEmpty()) {
            return introduction;
        }
        String joinedKlasses = klasses.stream()
                .sorted((klass1, klass2) -> klass1.getNumber() - klass2.getNumber())
                .map(klass -> klass.getNumber().toString())
                .collect(Collectors.joining(", "));
        return String.format("%s I teach Class %s.", introduction, joinedKlasses);
    }

    public void assignTo(final Klass klass) {
        if (klasses.contains(klass)) {
            return;
        }
        this.klasses.add(klass);
    }

    public boolean belongsTo(final Klass klass) {
        return this.klasses.contains(klass);
    }

    public boolean isTeaching(final Student student) {
        return this.klasses.stream().anyMatch(student::isIn);
    }
}
