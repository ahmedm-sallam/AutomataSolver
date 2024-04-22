package org.Solver;

import java.io.*;
import java.util.*;

public class NFASimulator {
    Set<Integer> states;
    Set<Character> alphabet;
    Map<Integer, Map<Character, Set<Integer>>> transition;
    Set<Integer> startStates;
    Set<Integer> acceptingStates;

    public NFASimulator() {
        states = new HashSet<>();
        alphabet = new HashSet<>();
        transition = new HashMap<>();
        startStates = new HashSet<>();
        acceptingStates = new HashSet<>();
    }

    public void addTransition(int state, char symbol, int nextState)
    {
        transition.putIfAbsent(state, new HashMap<>());
        transition.get(state).putIfAbsent(symbol, new HashSet<>());
        transition.get(state).get(symbol).add(nextState);
    }

    public void validate(String str, PrintWriter output) throws IOException
    {



            Set<Integer> currentStates = new HashSet<>(startStates);


            for (char symbol : str.toCharArray())
            {
                Set<Integer> nextStates = new HashSet<>();

                for (int state : currentStates)
                {
                    if ( transition.containsKey(state) && transition.get(state).containsKey(symbol))
                    {
                        nextStates.addAll(transition.get(state).get(symbol));
                    }
                }
                currentStates = nextStates;
            }

            boolean isAccepted = currentStates.stream().anyMatch(acceptingStates::contains);

            output.println("Output: " + (isAccepted? "True" : "False"));

        }


    }


