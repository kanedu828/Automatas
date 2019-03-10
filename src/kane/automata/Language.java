package kane.automata;

import java.util.ArrayList;

/**
 * This class represents the language for an automaton.
 */
public class Language {
    String[] lang;

    /**
     * Characters for the alphabet.
     * @param l Characters in the alphabet.
     */
    public Language(String ... l){
        lang = new String[l.length];
        int index = 0;
        for(String s: l){
            lang[index] = s;
            index++;
        }
    }

    /**
     * Returns the language.
     * @return {@code lang}
     */
    public String[] getLang(){
        return lang;
    }

    /**
     * Represents the language as a string seperated by commas.
     * @return String that represents each character in the language.
     */
    public String langToString(){
        String returnString = "";
        for(String s: lang){
            returnString = returnString + ", " + s;
        }
        returnString = returnString.substring(0, returnString.length()-2);
        return returnString;
    }
}
