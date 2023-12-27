import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPerson;
        int count = 0;

        System.out.println("Вас приветствует программа \"Побратски попилить счет\".\n" +
                "На скольких человек необходимо попилить ваш счёт, введите числовое значение >1 ...");

        numberOfPerson = checkingUserInputString();
        checkingUserInputOfTaskCondition(numberOfPerson);
        Calculate calculate = new Calculate();

        while (true) {
            System.out.println("Вы хотите добавить позицию из счета? \n" +
                    "(Введите: \"да\" - если хотите ее добавить; \"завершить\" - если не хотите добавлять)...");
            String userInput = scanner.next().toLowerCase(Locale.ROOT);
            switch (userInput) {
                case "да": {
                    System.out.println("Введите наименование позиции из счета...");
                    String nameProduct = scanner.next();
                    System.out.println("Введите стоимость позиции из счета...");
                    double costProduct = checkingUserInputDouble();
                    checkingValueProduct(costProduct);
                    Product product = new Product(nameProduct, costProduct);
                    calculate.addingProductsToCalculate(product);
                    calculate.sum(costProduct);
                    break;
                }
                case "завершить": {
                    count++;
                    System.out.println("Ввод позиций по счету успешно завершен.\nДобавленные позиции:");
                    calculate.addingProductsToConsole();
                    break;
                }
                default:
                    System.out.println("Вы ввели некорректное значение, повторите попытку...");
            }if (count == 1){
                break;
            }
        }

        double division = calculate.division(calculate.sum, numberOfPerson);
        if (calculate.sum == 0){
             System.out.println("Товары отсутвуют, пилить счет нет смысла. Завершение программы...");
        }else System.out.println("\n" +
                "Общая стоимость всех позиций счета = " + calculate.sum + "\n" +
                "Количество человек, на которых необходимо попилить счет = " + numberOfPerson + "\n" +
                "Каждый человек должен скинуться по - " + division);

    }
    static int checkingUserInputString (){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Введите корректное значение, целое число больше 1-ого ...");
            scanner.nextLine();
        }return scanner.nextInt();
    }

    static int checkingUserInputOfTaskCondition(int number){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (number == 1) {
                System.out.println("Введите значение >1...");
                number = checkingUserInputString();
            } else if (number > 1) {
                System.out.println("Введено корректное значение количества человек!");
                break;
            } else if (number <= 0) {
                System.out.println("Введено значение ноль или меньше нуля, повторите попытку...");
                number = checkingUserInputString();
            }
        }return number;
    }

    static double checkingUserInputDouble(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextDouble()) {
            System.out.println("Необходимо ввести ЧИСЛОВОЕ значение стоимости позиции из счета, повторите попытку...");
            scanner.nextLine();
        }return scanner.nextDouble();

    }

    static double checkingValueProduct(double costProduct){
        while (true) {
            if (costProduct <= 0) {
                System.out.println("Введено значение ноль или меньше нуля, повторите попытку...");
                costProduct = checkingUserInputDouble();
            }else if (costProduct > 0){
                System.out.println( "Введено корректное значение стоимости позиции из счета!");
                break;
            }
        }return costProduct;
    }
}