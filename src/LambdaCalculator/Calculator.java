package LambdaCalculator;

public class Calculator {
    // Лямбда-вираз для додавання
    private ArithmeticOperation addition = (a, b) -> a + b;

    // Лямбда-вираз для віднімання
    private ArithmeticOperation subtraction = (a, b) -> a - b;

    // Лямбда-вираз для множення
    private ArithmeticOperation multiplication = (a, b) -> a * b;

    // Лямбда-вираз для ділення
    private ArithmeticOperation division = (a, b) -> {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero is not allowed!");
        }
    };

    // Функціональний інтерфейс для арифметичних операцій
    interface ArithmeticOperation {
        int calculate(int a, int b);
    }

    // Метод для виконання арифметичної операції за допомогою лямбда-виразу
    public int performOperation(ArithmeticOperation operation, int a, int b) {
        return operation.calculate(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int num1 = 10;
        int num2 = 5;

        // Додавання
        int resultAddition = calculator.performOperation(calculator.addition, num1, num2);
        System.out.println(num1 + " + " + num2 + " = " + resultAddition);

        // Віднімання
        int resultSubtraction = calculator.performOperation(calculator.subtraction, num1, num2);
        System.out.println(num1 + " - " + num2 + " = " + resultSubtraction);

        // Множення
        int resultMultiplication = calculator.performOperation(calculator.multiplication, num1, num2);
        System.out.println(num1 + " * " + num2 + " = " + resultMultiplication);

        // Ділення
        try {
            int resultDivision = calculator.performOperation(calculator.division, num1, num2);
            System.out.println(num1 + " / " + num2 + " = " + resultDivision);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

