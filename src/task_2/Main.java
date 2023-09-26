package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(1000));
        }

        int sumOfSquares = numbers.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);

        System.out.println("Список чисел: " + numbers);
        System.out.println("Сумма квадратов чисел: " + sumOfSquares);
    }
}
