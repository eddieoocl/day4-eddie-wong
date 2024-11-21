package oo.step7;

import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_message_when_startSchool_with_teacher() {
        School school = new School();
        Klass klass = new Klass(2);
        Teacher jerry = new Teacher(1, "Jerry", 21);

        jerry.assignTo(klass);
        klass.attach(jerry);
        school.addPerson(jerry);

        school.startSchool();

        assertThat(systemOut()).contains(String.format("My name is Jerry. I am 21 years old. I am a teacher. I teach Class 2.%n"));
    }

    @Test
    public void should_print_message_when_startSchool_with_student() {
        School school = new School();
        Klass klass = new Klass(2);
        Student tom = new Student(1, "Tom", 18);

        tom.join(klass);
        klass.attach(tom);
        school.addPerson(tom);

        school.startSchool();

        assertThat(systemOut()).contains(String.format("My name is Tom. I am 18 years old. I am a student. I am in class 2.%n"));
    }

    @Test
    public void should_print_message_when_startSchool_with_student_and_teacher() {
        School school = new School();
        Klass klass = new Klass(2);
        Student tom = new Student(1, "Tom", 18);
        Teacher jerry = new Teacher(1, "Jerry", 21);

        jerry.assignTo(klass);
        klass.attach(jerry);
        school.addPerson(jerry);

        tom.join(klass);
        klass.attach(tom);
        school.addPerson(tom);

        school.startSchool();

        assertThat(systemOut()).contains(String.format("My name is Jerry. I am 21 years old. I am a teacher. I teach Class 2.%nMy name is Tom. I am 18 years old. I am a student. I am in class 2.%n"));
    }

    private String systemOut() {
        return outContent.toString();
    }
}
