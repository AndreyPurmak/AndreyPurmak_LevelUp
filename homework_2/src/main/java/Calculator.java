import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.startCalculator();
}

    public void startCalculator() {
        boolean nextStep = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter first number");
            double arg1 = scanner.nextDouble();

            System.out.println("Select needed operation:\n" + "0- Addition\n" +
                    "1- Subtraction\n" +
                    "2- Multiplication\n" +
                    "3- Involution\n" + "4- Factorial\n" +
                    "5- Fibonacci\n");

            System.out.println();
            int operation = scanner.nextInt();
            System.out.println("Enter second number");
            double arg2 = scanner.nextDouble();

            System.out.println("Result:\t");
            CalculatorOperations calculatorOperations = new CalculatorOperations();
            System.out.println(calculatorOperations.startCalculator(arg1, arg2, operation));
            System.out.println("Do you want to continue?");
            System.out.print("1- Continue\n");
            System.out.println("2- Exit");
            int whatDo = scanner.nextInt();
            if (whatDo == 2) {nextStep = false;}
        } while (nextStep) ;
    }
}

