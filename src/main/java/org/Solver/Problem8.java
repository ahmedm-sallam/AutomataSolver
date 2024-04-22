package org.Solver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Problem8 {
    public static void NFA_validate(Scanner input, PrintWriter output) throws IOException {
        NFASimulator problem9 = new NFASimulator();

        problem9.states = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        problem9.alphabet = new HashSet<>(Arrays.asList('0', '1'));
        problem9.addTransition(0, '1', 0);
        problem9.addTransition(0, '0', 0);

        problem9.addTransition(0, '1', 1);
        problem9.addTransition(1, '0', 2);
        problem9.addTransition(2, '1', 5);

        problem9.addTransition(0, '0', 3);
        problem9.addTransition(3, '1', 4);
        problem9.addTransition(4, '0', 5);

        problem9.addTransition(5, '1', 5);
        problem9.addTransition(5, '0', 5);

        problem9.startStates = new HashSet<>(List.of(0));
        problem9.acceptingStates = new HashSet<>(List.of(5));


        output.println("Problem 8 :");

        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("8")) continue;
            if (str.equals("end")) break;

            problem9.validate(str, output);


        }
        output.println("End of problem 8");
        output.println("--------------------");

    }
}
