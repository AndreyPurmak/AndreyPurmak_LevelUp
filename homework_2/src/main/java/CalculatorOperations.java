public class CalculatorOperations implements OperationsWithDouble, OperationsWithInt {
    public double startCalculator(double arg1, double arg2, int operation) {
        double result = 0;
        switch (operation) {
            case 0:
                result = add(arg1, arg2);
                break;
            case 1:
                result = subtract(arg1, arg2);
                break;
            case 2:
                result = multiply(arg1, arg2);
                break;
            case 3:
                result = involution((int) arg1, (int) arg2);
                break;
            case 4:
                result = factorial((int) arg1);
                break;
            case 5:
                result = fibonacci ((int) arg1);
                break;
        }
        return result;
    }

    public double subtract(double val1, double val2) {
        return val1 - val2;
    }

    public double multiply(double val1, double val2) {
        return val1 * val2;
    }

    public double add(double val1, double val2) {
        return val1 + val2;
    }

    public double factorial(int val1) {
        int fact = 1;
        for (int i = 1; i <= val1; i++) {
            fact *= i;
        }
        return fact;
    }

    public double involution(int val1, int val2) {
        double invol = 1;
        for (int i = 1; i <= val2; i++){
            invol *= val1;
        }
        return invol;
    }
    public double fibonacci(int val1){
        if (val1 == 1 || val1 == 2){
            return 1;
        }
        else {
            return fibonacci(val1 - 1) + fibonacci(val1 - 2);
        }
    }
}

