package org.Solver;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem5 {

    public static void validate(Scanner input, PrintWriter output) {
        String[] states = {"q0", "q1", "q2", "q3"};
        char[] alphabet = {'0', '1'};
        String[][] transition = {
                {"q0", "q1"},
                {"q2", "q1"},
                {"q0", "q3"},
                {"q3", "q3"}
        };
        String startState = "q0";
        String[] acceptingStates = {"q0"};
        output.println("Problem 5 - binary strings that divisible by 4 :");
        while (input.hasNextLine()) {
            String data = input.nextLine();
            if (data.equals("5")) continue; // Skip the problem number
            if (data.equals("end")) break; // Terminate the loop if "end" is encountered
            if (!data.isEmpty()) { // Skip empty lines
                boolean accepted = isDivisibleBy4(data, states, alphabet, transition, startState, acceptingStates);
                output.println((accepted ? "True" : "False"));
            }
        }
        output.println("End of problem 5");
        output.println("--------------------");
    }

    public static boolean isDivisibleBy4(String input, String[] states, char[] alphabet, String[][] transition, String startState, String[] acceptingStates) {
        String currentState = startState;
        for (char c : input.toCharArray()) {
            int symbolIndex = indexOf(alphabet, c);
            if (symbolIndex == -1) return false; // Invalid input symbol
            currentState = transition[indexOf(states, currentState)][symbolIndex];
        }
        // Check if the final state is accepting
        return indexOf(acceptingStates, currentState) != -1;
    }

    public static int indexOf(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1; // Not found
    }

    public static int indexOf(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
}
