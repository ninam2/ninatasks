package de.ninam.recruitingtasks.task4;

import de.ninam.recruitingtasks.TasksConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TasksConfig.class)
public class StringUtilsTest {

    @Autowired
    private StringUtils stringUtils;

    @Test
    public void testUniqueCharactersDuplicateLetters() {

        String someString = "abbbc";

        List<Character> unique = stringUtils.Characters(someString);

        List<Character> characters = Arrays.asList('a', 'b', 'c');

        assertEquals(characters, unique);
    }


    @Test
    public void testUniqueCharactersCharactersMixed() {

        String someString = "abcbabdf";

        List<Character> unique = stringUtils.Characters(someString);

        List<Character> characters = Arrays.asList('a', 'b', 'c', 'd', 'f');

        assertEquals(characters, unique);
    }

    @Test(expected = NullPointerException.class)
    public void testUniqueCharactersNullString() {

        stringUtils.Characters(null);
    }

    @Test
    public void testUniqueCharactersEmptyString() {

        List<Character> characters = stringUtils.Characters("");
        assertEquals(0, characters.size());
    }

    @Test
    public void testCountLetterSingleEntry() {

        String someString = "abbbc";

        int counter = stringUtils.countFirstLetter(someString);

        assertEquals(1, counter);
    }


    @Test
    public void testCountLetterNoEntry() {

        String someString = "bbbc";

        int counter = stringUtils.countFirstLetter(someString);

        assertEquals(0, counter);
    }


    @Test
    public void testCountLetterMultipleEntryOrdered() {

        String someString = "abbbcddd";

        int counter = stringUtils.countFirstLetter(someString);

        assertEquals(3, counter);
    }


    @Test
    public void testCountLetterMultipleEntryMixed() {

        String someString = "a,c,b,a,c,e,b,a,d,b,a,e,x,b";

        int counter = stringUtils.countFirstLetter(someString);

        assertEquals(4, counter);
    }

    @Test(expected = NullPointerException.class)
    public void testCountLetterNullString() {

        stringUtils.countFirstLetter(null);
    }

    @Test
    public void testCountLetterEmptyString() {

        int count = stringUtils.countFirstLetter("");
        assertEquals(0, count);
    }
}