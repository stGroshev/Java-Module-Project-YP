import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int numberOfPerson;
        System.out.println("На скольких человек необходимо разделить счёт...");

        try {
            numberOfPerson = scanner.nextInt();
            checkingUserInput(numberOfPerson);
        } catch (InputMismatchException e) {
            System.out.println("Введите корректное значение используя цифры, а не буквы...");
        }


    }
    static void checkingUserInput (int number){
        while (true) {
            if (number == 1) {
                System.out.println("Введите значение больше 1-ого...");
                number = scanner.nextInt();
            } else if (number > 1) {
                System.out.println("Значение корректно...");
                break;
            } else {
                System.out.println("Введите корректное значение, целое число больше 1-ого...");
                number = scanner.nextInt();
            }
        }
    }
}