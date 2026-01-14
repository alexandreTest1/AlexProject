package A1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 8, 20, 3);
        int total = 0;            // Defining an int variable

        for (int n : numbers) {
            if (n > 10) {            // The condition inside the loop
                total += n;            // This program is used to add numbers:            }
            }
        }
            System.out.println(total);        // Prints the final result.
        }
    }

   /* Questions:
            ✓ What will be printed?
    Answer:
    Printed value: 32, because condition is (n > 10) and 12+20 = 32

    Question:
            ✓ Which elements affect the result and why?
    Answer:
    Contributing elements: 12 and 20, Because the condition is (n > 10)

    Question:
            ✓ What happens if the condition is changed to n >= 10?
    Answer:
    Changing to n >= 10: No change in output for this list, but would include 10 if present*/

