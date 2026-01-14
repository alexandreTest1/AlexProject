package A1;

import java.util.Arrays;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 12, 8, 20, 3);  // Create a list of integers


        // Using Stream:
        int total = numbers.stream()

                .filter(n -> n > 10)        // Filters numbers greater than 10
                .mapToInt(Integer::intValue)  // Converts to int type
                .sum();                 // Calculates the sum of the received numbers

        System.out.println(total);  // prints final result
    }
}
