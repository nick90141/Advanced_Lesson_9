package task_4;

interface Calculator {
    float calculate(float a, float b);
}

public class Main {
    public static void main(String[] args) {

        Calculator add = (a,b) -> a + b;
        Calculator minus = (a,b) -> a - b;
        Calculator multiply = (a,b) -> a * b;
        Calculator divide = (a,b) -> {
            if (b != 0) {
                return a / b;
            } else {
                throw new ArithmeticException("Делить на ноль нельзя!");
            }
        };
        try {
        float result_add = add.calculate(5,6);
        float result_minus = minus.calculate(5,6);
        float result_multiply = multiply.calculate(5,6);
        float result_divide = divide.calculate(5,6);

        System.out.println("Результат сложения: " + result_add);
        System.out.println("Результат вычисления: " + result_minus);
        System.out.println("Результат умножения: " + result_multiply);
        System.out.println("Результат деления: " + result_divide);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
