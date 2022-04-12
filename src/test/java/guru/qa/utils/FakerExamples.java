package guru.qa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class FakerExamples {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println(faker.address().fullAddress());
        System.out.println(faker.backToTheFuture().quote());
        System.out.println(faker.animal().name());
        System.out.println(faker.lebowski().actor());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.internet().macAddress());
        System.out.println(faker.color().hex());

        Faker fakerDe = new Faker(new Locale("de"));
        System.out.println(fakerDe.address().fullAddress());
        Faker fakerRu = new Faker(new Locale("ru"));
        System.out.println(fakerRu.address().fullAddress());



    }
}
