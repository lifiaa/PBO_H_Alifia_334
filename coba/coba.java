package coba;
import java.util.Scanner;

public class coba {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = input.nextLine();
            System.out.println("Hello, " + name + "!");
        }
    }
}
