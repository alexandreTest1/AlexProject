package A3;

public class Main {

    // Method that calculates the sum of even numbers in an array
    public static int calculateSum(int[] values) {
        int sum = 0;  		// Variable definition
        for (int v : values) {	// Iterate through all elements of the array.
            if (v % 2 == 0) {	// Checks whether a number is even.
                sum += v;	// If even adds sum
            }
        }
        return sum;		// Returns the value of the sum variable.
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6};

        // Prints the final result.
        System.out.println(calculateSum(data));
    }

}

/*Question:
        ✓ What will be printed?
Answer: 12, because 2 + 4 + 6 = 12

Question:
        ✓ Which numbers are included and why?
Answer:
The even numbers from the array are included: 2, 4, 6
This numbers are included because, the condition is v % 2 == 0, which checks even numbers */

