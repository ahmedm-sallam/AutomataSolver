package org.Solver;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("input.txt"));
            PrintWriter output = new PrintWriter(new FileWriter("output.txt"));
            while (input.hasNextLine())
            {
                String data = input.nextLine();
                switch (data)
                {
                    case "1" -> Problem1.validate(input, output);
                    case "2" -> Problem2.validate(input, output);


                }
            }
            input.close();
            output.close();

            System.out.println("Validation completed. Check output.txt for results.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}