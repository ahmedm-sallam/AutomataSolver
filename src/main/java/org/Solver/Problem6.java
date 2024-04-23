//package org.Solver;
//import java.io.;
//import java.util.;
//
//public class Problem6 {
//
//private static final int[][] transitionTable = {
//            {2, 1}, // State q0 transitions (on '0' -> q1, on '1' -> q2)
//            {2, 3}, // State q1 transitions (on '0' -> q2, on '1' -> q3)
//            {2, 2}, // State q2 transitions (on '0' -> q2, on '1' -> q2)
//            {2, 4},  // State q3 transitions (on '0' -> q2, on '1' -> q4)
//            {2, 2} // State q4 transitions (on '0' -> q2, on '1' -> q2)
//    };
//    private static final int[] acceptingStates = {1, 2};
//
//// Method to check if a string is accepted by the DFA
//    private static boolean isAccepted(String input) {
//        int currentState = 0;
//
//        for (char ch : input.toCharArray()) {
//            int inputType = (ch == '0') ? 0 : 1;
//           // System.out.print(currentState+" ");
//            currentState = transitionTable[currentState][inputType];
//           // System.out.print(currentState+" ");
//            System.out.println();
//        }
//
//        for (int state : acceptingStates) {
//            if (currentState == state) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    // Method to validate input strings using the DFA and write results to output
//    public static void validate(Scanner input, PrintWriter output){
//        output.println("Problem 6: ");
//        while (input.hasNextLine()) {
//            String str = input.nextLine();
//            if (str.equals("6")) continue;
//            if (str.equals("end")) break;
//            boolean accepted = isAccepted(str);
//            System.out.println(accepted);
//            output.println((accepted ? "True" : "False"));
//        }
//
//        output.println("End of problem 6");
//        output.println("--------------------");
//    }
//
//}
