package oo;

public class Person {
    private final Integer id;
    private final String name;
    private final Integer age;

    public Person(final int id, final String name, final int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return this.id.equals(person.id);
    }
}
