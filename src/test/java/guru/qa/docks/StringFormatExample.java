package guru.qa.docks;

import static java.lang.String.format;

public class StringFormatExample {
    public static void main(String[] args){
        String name="username",
         subject ="you";

        System.out.println("Hello, " + name + "! How are" + subject + "?");
        System.out.println(format("Hello, %s! How are %s?", name,subject));
    }
}
