package Modul2;

import java.util.Scanner;

public class Modul2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your Name: ");
        String name = in.nextLine();

        System.out.println("Input your home town/city: ");
        String city = in.nextLine();

        System.out.println("Input your hobby: ");
        String hobby = in.nextLine();

        System.out.println("Input your age: ");
        int age = in.nextInt();

        System.out.println("\nOption #1:");
        System.out.printf("Name: %s\nCity: %s\nAge: %d\nHobby: %s \n", name, city, age, hobby);

        System.out.println("\nOptin #2:");
        System.out.printf("Person with name %s lives in city %s.\n " +
                "This person is %d years old and he/she likes %s\n", name, city, age, hobby);

        System.out.println("\nOption #3:");
        System.out.printf("%s - name\n%s - city\n %d - age\n%s - hobby",
                name, city, age, hobby);
    }
}
