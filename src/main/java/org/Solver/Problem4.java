package org.Solver;
import java.io.*;
import java.util.*;

public class Problem4 {
    private static final int[][] transitionTable = {
            {1, 3}, // State q0 transitions (on 'a' -> q1, on 'b' -> q3)
            {1, 2}, // State q1 transitions (on 'a' -> q1, on 'b' -> q2)
            {2, 2}, // State q2 transitions (on 'a' -> q2, on 'b' -> q2)
            {3, 3}  // State q3 transitions (on 'a' -> q3, on 'b' -> q3)
    };
    private static final int[] acceptingStates = {1, 3};
    private static final int rejectState = 4;

    // Method to check if a string is accepted by the DFA
    private static boolean isAccepted(String input) {
        int currentState = 0;

        for (char ch : input.toCharArray()) {
            int inputType = (ch == 'a') ? 0 : 1;
            currentState = transitionTable[currentState][inputType];
        }

        for (int state : acceptingStates) {
            if (currentState == state) {
                return true;
            }
        }

        return false;
    }

    // Method to validate input strings using the DFA and write results to output
    public static void validate(Scanner input, PrintWriter output) {
        output.println("Problem 4 - String Validation (Starting and ending with the same characters): ");
        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("4")) continue;
            if (str.equals("end")) break;
            boolean accepted = isAccepted(str);
            output.println((accepted ? "True" : "False"));
        }

        output.println("End of problem 4");
        output.println("--------------------");
    }
}
