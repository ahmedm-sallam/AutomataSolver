package org.Solver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem9 {
    public static void NFA_validate(Scanner input, PrintWriter output) throws IOException {
        NFASimulator problem9 = new NFASimulator();

        problem9.states = new HashSet<>(Arrays.asList(0, 1));
        problem9.alphabet = new HashSet<>(Arrays.asList('0', '1'));
        problem9.addTransition(0, '1', 1);
        problem9.addTransition(1, '0', 0);
        problem9.startStates = new HashSet<>(Arrays.asList(0, 1));
        problem9.acceptingStates = new HashSet<>(Arrays.asList(0, 1));


        output.println("Problem 9 :");

        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("9")) continue;
            if (str.equals("end")) break;

            problem9.validate(str, output);


        }
        output.println("End of problem 9");
        output.println("--------------------");

    }
}
