package oo;

import java.util.Optional;

public class Person {
    private final Integer id;
    private final String name;
    private final Integer age;
    private final Optional<String> role;

    public Person(final int id, final String name, final int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = Optional.empty();
    }

    public Person(final int id, final String name, final int age, final String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = Optional.of(role);
    }

    public String introduce() {
        String introduction =  String.format("My name is %s. I am %d years old.", name, age);
        if (role.isPresent()) {
            introduction = introduction + String.format(" I am a %s.", role.get());
        }
        return introduction;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return this.id.equals(person.id);
    }
}
