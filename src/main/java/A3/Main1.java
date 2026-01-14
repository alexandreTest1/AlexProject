package A3;

public class Main1 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6};   // Array of integers
        System.out.println(calculateEvenNumbersAverage(data));   // prints final result

    }

    // The method takes an array of integers and returns the average of the even numbers.
    public static double calculateEvenNumbersAverage(int[] values) {
        int sum = 0;        //Introducing a variable to calculate the sum of even numbers
        int average = 0;    //Introducing a variable to count the number of even numbers

        // Checks if a number is even or not
        for (int v : values) {
            if (v % 2 == 0) {
                sum += v;           // Adding an even number to a total
                average++;          // Increasing the number of even numbers
            }
        }


        // Return the average of even numbers
        return (double) sum / average;
    }

}
