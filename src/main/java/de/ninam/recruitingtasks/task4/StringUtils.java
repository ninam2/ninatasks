package de.ninam.recruitingtasks.task4;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Helps with operations on Strings
 */
@Component
public class StringUtils {

    /**
     * Finds all Characters in a given String and returns them unique (order preserved)
     *
     * @param someString String that Characters should be searched in
     * @return all Characters in a given String and returns them unique (order preserved)
     */
    public List<Character> Characters(String someString) {

        // character list
        List<Character> CharList = new ArrayList<Character>();

        // add characters
        for (Character c : someString.toCharArray()) {

            // only add character if not yet included (avoid duplicates)
            if (!CharList.contains(c)) {
                CharList.add(c);
            }
        }
        return CharList;
    }

    /**
     * Checks how often the first letter of a String is repeated
     *
     * Examples:
     * "abcad" - will return 1
     * "aabcad" - will return 2
     *
     * @param analyzeMe String that the letter should be searched in
     * @return count of Character in String
     */
    public int countFirstLetter(String analyzeMe) {

        // character count
        int count = 0;
        char current = analyzeMe.charAt(0);

        // iterate over all characters in string
        for (char c : analyzeMe.toCharArray()) {

            // increase count if character matches

            if (c == current) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
