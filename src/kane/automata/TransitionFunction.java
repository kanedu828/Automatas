package kane.automata;

/**
 * This functional interface represents a transition function for a state. The function {@code accepts(String input)}
 * must return a state. Only DFAs are supported as of now. Every state must have a {@code TransitionFunction}
 *
 */
public interface TransitionFunction {
    /**
     * This method should take in an accepting input and return the state that is being transitioned to.
     * @param input Accepting input
     * @return Transitioned state.
     */
    State accepts(String input);
}
