package org.Solver;
import java.io.*;
import java.util.*;

public class Problem2 {
    private static final int[][] transitionTable = {
            {1, 2}, // State q0 transitions (on '0' -> q1, on '1' -> q2)
            {0, 3}, // State q1 transitions (on '0' -> q0, on '1' -> q3)
            {3, 3}, // State q2 transitions (on '0' -> q3, on '1' -> q3)
            {3, 3}  // State q3 transitions (on '0' -> q3, on '1' -> q3)
    };
    private static final int[] acceptingStates = {2};


    // Method to check if a string is accepted by the DFA
    private static boolean isAccepted(String input) {
        int currentState = 0;

        for (char ch : input.toCharArray()) {
            int inputType = (ch == '0') ? 0 : 1;
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
        output.println("Problem 2 - String Validation (even number of 0's f ollowed by single 1 ): ");
        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("2")) continue;
            if (str.equals("end")) break;
            boolean accepted = isAccepted(str);
            output.println((accepted ? "True" : "False"));
        }

        output.println("End of problem 2");
        output.println("--------------------");
    }
}
