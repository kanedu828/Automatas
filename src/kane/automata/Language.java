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
     * Checks if a particular input is contained in the language.
     * @param input Input that is being checked
     * @return True if {@code input} is contained in the language, false otherwise.
     */
    public boolean contains(String input){
        for(String s: lang){
            if(s.equals(input)){
                return true;
            }
        }
        return false;
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
