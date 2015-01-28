package com.ws.ami.common.overwrite;

/**
 * Created by hp on 2015/1/28.
 */
public class OverwriteTest {

    public void say(Animal animal) {
        System.out.println("animal");
        animal.say();

    }


    public void say(Mammal mammal) {
        System.out.println("Mammal");
        mammal.say();

    }


    public void say(Person person) {
        System.out.println("Mammal");
        person.say();

    }

    public static void main(String[] args) {

        OverwriteTest overwriteTest = new OverwriteTest();
        Animal p = new Person();
        overwriteTest.say(p);

    }
}
