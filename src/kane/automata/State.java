package kane.automata;

/**
 * This class represents a single state in a automaton. Also, only binary languages are accepted.
 *
 */
public class State{
    private String name;
    private TransitionFunction tf;
    private State nextState;
    private boolean accepting;
    private Language lang;

    /**
     * This constructor creates a state with the specified name.
     * @param name Name of the state
     *
     */
    public State(String name){
        this.name = name;
    }
    /**
     * This constructor creates a state with the specified name, language, and whether it is
     * an accepting state.
     * @param name Name of the state
     * @param accepting Whether or not this state is an accepting state.
     */
    public State(String name, boolean accepting){
        this.name = name;
        this.accepting = accepting;
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
     * Returns the name of the State.
     * @return name of the state.
     */
    public String getName(){
        return name;
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
     * Sets the language that is acceoted for this state.
     * @param lang Accepted language for the state.
     */
    public void setLang(Language lang){
        this.lang = lang;
    }

    /**
     * Take's in an input, and depending on the defined transition function, it will set the {@code nextState}.
     * @param input The input being taken.
     */
    public void takeInput(String input){
        if(!lang.contains(input)){
            throw new IllegalArgumentException(input + " is not in the language.");
        }
        nextState = tf.accepts(input);
    }

}
