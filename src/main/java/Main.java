import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPerson = 0;
        int count = 0;
        double sum = 0.0;

        System.out.println("Вас приветствует программа \"Побратски попилить счет\".\nНа скольких человек необходимо попилить ваш счёт...");


        try {
            numberOfPerson = scanner.nextInt();
            checkingUserInput(numberOfPerson);

        } catch (InputMismatchException e) {
            System.out.println("Введите корректное значение используя цифры, а не буквы...");
        }

        while (true) {
            System.out.println("Вы хотите добавить товар? \n(Введите: \"да\" - если хотите добавить товар; \"завершить\" - если не хотите добавлять товар)...");
            String userInput = scanner.next().toLowerCase(Locale.ROOT);
            switch (userInput) {
                case "да": {
                    System.out.println("Введите название товара...");
                    String nameProduct = scanner.next();
                    System.out.println("Введите стоимость товара...");
                    double costProduct = scanner.nextDouble();
                    Product product = new Product(nameProduct, costProduct);
                    sum = sum + product.costProduct;
                    break;
                }
                case "завершить": {
                    count++;
                    System.out.println("Ввод продуктов завершен.");
                    break;
                }
                default:
                    System.out.println("Вы ввели некорректное значение, повторите попытку...");
            }if (count == 1){
                break;
            }
        }

        Calculate calculate = new Calculate(sum,numberOfPerson);
        double division = calculate.division(sum, numberOfPerson);
        if (sum == 0){
            System.out.println("Товары отсутвуют, делить нет смысла. Завершение программы...");
        }else System.out.println("Каждый человек должен скинуть - " + division);

    }
    static void checkingUserInput (int number){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (number == 1) {
                System.out.println("Введите значение больше 1-ого...");
                number = scanner.nextInt();
            } else if (number > 1) {
                System.out.println("Введено корректное значение.");
                break;
            } else {
                System.out.println("Введите корректное значение, целое число больше 1-ого...");
                number = scanner.nextInt();
            }
        }
    }
}