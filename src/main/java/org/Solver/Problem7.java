package org.Solver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Problem7 {
    public static void NFA_validate(Scanner input, PrintWriter output) throws IOException {
        NFASimulator problem7 = new NFASimulator();

        problem7.states = new HashSet<>(Arrays.asList(0, 1,2,3,4,5,6));
        problem7.alphabet = new HashSet<>(Arrays.asList('0', '1'));
        problem7.addTransition(0, '1', 1);
        problem7.addTransition(1, '0', 2);
        problem7.addTransition(1, '1', 1);
        problem7.addTransition(2, '1', 1);
        problem7.addTransition(2, '0', 2);
        problem7.addTransition(2, '1', 5);
        problem7.addTransition(5, '1', 5);


        problem7.addTransition(0, '0', 3);
        problem7.addTransition(3, '0', 3);
        problem7.addTransition(3, '1', 4);
        problem7.addTransition(4, '0', 3);
        problem7.addTransition(4, '1', 4);
        problem7.addTransition(4, '0', 6);
        problem7.addTransition(6, '0', 6);

        problem7.startStates = new HashSet<>(List.of(0));
        problem7.acceptingStates = new HashSet<>(Arrays.asList(5, 6));


        output.println("Problem 7 :");

        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("7")) continue;
            if (str.equals("end")) break;

            problem7.validate(str, output);


        }
        output.println("End of problem 7");
        output.println("--------------------");

    }
}
