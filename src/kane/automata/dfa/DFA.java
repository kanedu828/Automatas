package kane.automata.dfa;

import kane.automata.Language;
import kane.automata.State;

/**
 * This class represents a DFA automaton. Therefore, empty strings are not supported, and each state must have as many
 * outputs as the amount of characters in the alphabet. Before initializing the DFA, all states should be declared
 * and initialized.
 */
public class DFA {
    private State startingState;
    private State[] states;

    /**
     * Intializes the DFA with the starting state, states in the DFA, and the language.
     * @param lang Language for this DFA.
     * @param states States in this DFA. The starting state must be the first state in {@code states}.
     */
    public DFA(Language lang, State ... states){
        this.startingState = states[0];
        this.states = new State[states.length];
        int index = 0;
        for(State s: states){
            this.states[index]=s;
            s.setLang(lang);
            index++;
        }
    }

    /**
     * Takes the input of a string.
     *
     * @param string String being inputted
     * @return True if it is an accepted string, false otherwise.
     */
    public boolean takeString(String string) {
        String[] input = string.split(" ");
        State currentState = startingState;
        for(int i = 0; i<input.length; i++){
            currentState.takeInput(input[i]);
            currentState = currentState.getNextState();
        }
        if(currentState.isAccepting()){
            return true;
        }else{
            return false;
        }
    }
}
