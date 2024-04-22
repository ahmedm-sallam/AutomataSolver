package org.Solver;
import java.io.*;
import java.util.*;
public class Problem2 {
    // DFA transition table and constants
    private static final int[][] transitionTable = {
            {0, 0},
            {0, 1},
            {1, 2},
            {2, 1},
            {2, 3},
    };
    private static final int[] acceptingStates = {0,3};
    private static final int[] rejectState = {1,2};

    // Method to check if a string is accepted by the DFA
    private static boolean isAccepted(String input) {
        int currentState = 0;
        int countZero = 0;

        for (char ch : input.toCharArray()) {
            int inputType = (ch == '0') ? 0 : ((ch == '1') ? 1 : -1);
            if (inputType == 0) {
                countZero++;
            }
            currentState = transitionTable[currentState][inputType];
            int finalCurrentState = currentState;
            if (Arrays.stream(rejectState).anyMatch(state -> finalCurrentState == state)) {
                return false;
            }

        }

        // Check if the final state is an accepting state
        for (int state : acceptingStates) {
            if (currentState == state && countZero % 2 == 0) {
                return true;
            }
        }

        return false;
    }

    // Method to validate input strings using the DFA and write results to output
    public static void validate(Scanner input, PrintWriter output) throws FileNotFoundException {
        output.println("Problem 2 - String Validation (Even number of '0's followed by '1'): ");
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
