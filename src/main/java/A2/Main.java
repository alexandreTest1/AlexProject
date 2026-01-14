package A2;

public class Main {

    public static void main(String[] args) {
        String text = null;   // We have a variable text, but it doesn't have any String objects assigned to it.
        int length;	          // Introducing a variable, without a value

        if (text != null) {   // Check: if the variable text is not null
            length = text.length(); // Sets length to the number of characters in the text string.
        } else { 		// If text is null, length will be set to 5.
            length = 5;
        }

        System.out.println(length);   // Prints the final result.
    }
}

/*Question:
        ✓ What will be printed?

Answers:
Printed value: 5 because String text = null and ‘else’ condition will be run

Question:
        ✓ Why does the program not crash?
Answer:
Program does not crash because no method is over called on the null references.
        Text.length() is never executed because the ‘if’ condition prevents it
Program skips that line and executes the else condition instead

Question:
        ✓ What would cause a NullPointerException here?
Answer:
Any attempts to access text without checking for null would cause it.
Removing the null check it will cause NullPointerException
        length = text.length();
Wrong condition:
        if (text == null) {
length = text.length();*/

