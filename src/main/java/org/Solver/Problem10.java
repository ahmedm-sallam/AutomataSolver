package org.Solver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Problem10 {
    public static void NFA_validate(Scanner input, PrintWriter output) throws IOException {
        NFASimulator problem9 = new NFASimulator();

        problem9.states = new HashSet<>(Arrays.asList(0, 1, 2));
        problem9.alphabet = new HashSet<>(Arrays.asList('0', '1'));
        problem9.addTransition(0, '1', 0);
        problem9.addTransition(0, '0', 1);
        problem9.addTransition(1, '1', 2);
        problem9.addTransition(2, '0', 1);
        problem9.addTransition(2, '1', 2);

        problem9.startStates = new HashSet<>(List.of(0));
        problem9.acceptingStates = new HashSet<>(Arrays.asList(0, 2));


        output.println("Problem 10 :");

        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("10")) continue;
            if (str.equals("End")) break;

            problem9.validate(str, output);


        }
        output.println("End of problem 10");
//        output.println("--------------------");

    }
}
