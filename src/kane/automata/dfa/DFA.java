package kane.automata.dfa;

/**
 * This class represents a DFA automaton. Therefore, empty strings are not supported, and each state must have as many
 * outputs as the amount of characters in the alphabet. Before initializing the DFA, all states should be declared
 * and initialized.
 */
public class DFA {
    State startingState;

    /**
     * Intializes the DFA with the starting state.
     *
     * @param startingState The starting state.
     */
    public DFA(State startingState){
        this.startingState = startingState;
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
