package org.Solver;

import java.io.*;
import java.util.*;

public class Problem1 {
    // DFA transition table and constants
    private static final int[][] transitionTable = {
            {0, 1}, // State q0 transitions (on 'a' -> q0, on 'b' -> q1)
            {2, 1}  // State q1 transitions (on 'a' -> q2, on 'b' -> q1)
    };
    private static final int[] acceptingStates = {0, 1};
    private static final int rejectState = 2;

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
    public static void validate(Scanner input, PrintWriter output) throws FileNotFoundException {
        output.println("Problem 1 - String Validation (No 'ba' substring): ");
        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("1")&& !Objects.equals(input.nextLine(), "010111")) continue;
            if (str.equals("end")) break;
            boolean accepted = isAccepted(str);
            output.println((accepted ? "True" : "False"));
        }

        output.println("End of problem 1");
        output.println("--------------------");
    }
}
