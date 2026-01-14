package A2;

import java.util.Optional;
public class Main1 {
    public static void main(String[] args) {
        String text = null;             //Define a text variable that is null

        int length = Optional.ofNullable(text)// Creates an Optional object that safely handles null values.
                .map(String::length)           // If text is not null, it calls String's length() method.
                .orElse(5);             // If text is null, returns the value (5)

        System.out.println(length);            // prints final result

    }
}

