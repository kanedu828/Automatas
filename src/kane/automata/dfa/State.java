package kane.automata.dfa;
import kane.automata.Language;
import kane.automata.TransitionFunction;

/**
 * This class represents a single state in a automaton. Also, only binary languages are accepted.
 *
 */
public class State {
    String name;
    Language lang;
    TransitionFunction tf;
    State nextState;
    boolean accepting;

    /**
     * This constructor creates a state with the specified name, language, and whether it is
     * an accepting state.
     * @param name Name of the state
     * @param lang {@code Language} being used.
     * @param accepting Whether or not this state is an accepting state.
     */
    public State(String name, Language lang, boolean accepting){
        this.name = name;
        this.lang = lang;
        this.accepting = accepting;
        this.tf = tf;
    }

    /**
     * Returns the next state from the input string given by the user. {@code nextState} is
     * constantly changing due to {@code takeInput(String input}/
     *
     * @return The next state after this state.
     */
    public State getNextState(){
        return nextState;
    }

    /**
     * Returns whether or not this state is an accepting state.
     * @return True if this state is an accepting state, false otherwise.
     */
    public boolean isAccepting(){
        return accepting;
    }

    /**
     * Sets the transition function for this state. The user defines the function.
     * @param tf Functional interface for the transition function.
     */
    public void setTF(TransitionFunction tf){
        this.tf=tf;
    }

    /**
     * Take's in an input, and depending on the defined transition function, it will set the {@code nextState}.
     * @param input The input being taken.
     */
    public void takeInput(String input){
        if(!lang.getLang()[0].equals(input)&&!lang.getLang()[1].equals(input)){
            throw new IllegalArgumentException(input + " is not in the language.");
        }
        nextState = tf.accepts(input);
    }

}
