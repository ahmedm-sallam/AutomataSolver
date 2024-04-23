package org.Solver;
import java.io.*;
import java.util.*;

public class Problem3 {
    private static final int[][] transitionTable = {
            {1, 0}, // State q0 transitions (on 'x' -> q1, on 'y' -> q0)
            {2, 1}, // State q1 transitions (on 'x' -> q2, on 'y' -> q1)
            {1,2}, // State q2 transitions (on 'x' -> q1, on 'y' -> q2)

    };
    private static final int[] acceptingStates = {1};


    // Method to check if a string is accepted by the DFA
    private static boolean isAccepted(String input) {
        int currentState = 0;

        for (char ch : input.toCharArray()) {
            int inputType = (ch == 'x') ? 0 : 1;
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
        output.println("Problem 3 - String Validation (odd number of x's ): ");
        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("3")) continue;
            if (str.equals("end")) break;
            boolean accepted = isAccepted(str);
            output.println((accepted ? "True" : "False"));
        }

        output.println("End of problem 3");
        output.println("--------------------");
    }
}
