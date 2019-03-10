package kane.automata.dfa;

import kane.automata.Language;
import kane.automata.dfa.DFA;
import kane.automata.dfa.State;

/**
 * Test class for DFA.
 */
public class DFATest {
    /**
     * This method tests for a DFA of the following 5 tuple:
     * Q={q0,q1,q2}
     * S={a, b}
     * d(QxS)=Q
     * d(q0,a)=q1
     * d(q0,b)=q0
     * d(q1,a)=q2
     * d(q1,b)=q0
     * d(q2,a)=q2
     * d(q2,b)=q0
     * q0=q0
     * F={q2}
     *
     * This string accepts strings that end in two or more a's
     * @param userInput String being tested. Each character should be separated by a space.
     */
    public static void test1(String userInput){
        Language lang = new Language("a", "b");
        State q0 = new State("q0", lang, false);
        State q1 = new State("q1", lang, false);
        State q2 = new State("q2", lang, true);
        q0.setTF(input->{
            if(input.equals("a")){
                return q1;
            }else{
                return q0;
            }
        });
        q1.setTF(input->{
            if(input.equals("a")) {
                return q2;
            }else{
                return q0;
            }
        });
        q2.setTF(input->{
            if(input.equals("a")){
                return q2;
            }else{
                return q0;
            }
        });
        DFA dfa = new DFA(q0);
        System.out.println(dfa.takeString(userInput));
    }
}
