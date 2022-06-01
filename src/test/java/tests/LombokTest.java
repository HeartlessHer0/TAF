package tests;

import lombok.Cleanup;
import lombok.extern.java.Log;
import lombok.val;
import lombok.var;
import models.*;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
@Log
public class LombokTest {
    @Test
    public void valTest() {
        val list = new ArrayList<String>(); //Transfer to final variable
        list.add("Test value");
        System.out.println(list.get(0));
    }

    @Test
    public void varTest() {
        var list = new ArrayList<String>(); //Transfer to not final variable
        list.add("Test value");
        System.out.println(list.get(0));
    }

    @Test
    public void сleanUpTest() throws IOException {
        @Cleanup InputStream in = new FileInputStream("src/test/resources/text.txt");
        @Cleanup OutputStream out = new FileOutputStream("src/test/resources/text1.txt");
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }

    @Test
    public void getterAndSetterTest() {
        Person person = new Person();
        person.setAge(23);
        System.out.println(person.getAge());
    }

    @Test
    public void getterAndSetterTest1() {
        Person1 person = new Person1();
        person.setAge(23);
        person.setName("S");
        System.out.println(person.getAge() + " " + person.getName());
        System.out.println(person.toString());
    }

    @Test
    public void equalsTest() {
        Person1 person = new Person1();
        Person1 person1 = new Person1();
        person.setAge(23);
        person.setName("S");
        person1.setAge(23);
        person1.setName("S");
        System.out.println(person.equals(person1));

    }

    @Test
    public void constructorTest() {
        Person1 person = new Person1(23, "S");
        Person1 person1 = new Person1();
        person1.setAge(23);
        person1.setName("S");
        System.out.println(person.equals(person1));

    }

    @Test
    public void constructorTest2() {
        Person2 person = new Person2();
        person.setAge(23);
        person.setName("s");
        Person2 person1 = new Person2(23, "S", "A");
        Person2 person2 = new Person2("A");
        System.out.println(person.toString());
        System.out.println(person1.toString());
        System.out.println(person2.toString());

    }

    @Test
    public void dataTest() {
        Person3 person = new Person3();
        person.setAge(23);
        person.setName("s");
        Person3 person1 = new Person3(23, "S", "A");
        Person3 person2 = new Person3("A");
        System.out.println(person.toString());
        System.out.println(person1.toString());
        System.out.println(person2.toString());
    }

    @Test
    public void builderTest() {
        PersonBuilder person = PersonBuilder
                .builder()
                .name("S")
                .age(27)
                .surname("A")
                .build();
        System.out.println(person.toString());
    }
    @Test
    public void builderExcludeTest1() {
        PersonBuilder person = PersonBuilder.builder().name("S").age(27).surname("A").UUID(1).build();
        PersonBuilder person1 = PersonBuilder.builder().name("S").age(27).surname("A").UUID(2).build();
        log.severe(person.toString());
        log.severe(person1.toString());

    }
}


