package de.ninam.recruitingtasks.task3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ArraySorterTest.ArraySorterTestConfig.class)
public class ArraySorterTest {

    @Autowired
    ArraySorter arraySorter;

    @Test(expected = NullPointerException.class)
    public void testNull() {

        arraySorter.sort(null);
    }

    @Test
    public void testEmpty() {

        int[] sorted = arraySorter.sort(new int[0]);
        assertEquals(0, sorted.length);
    }

    @Test
    public void testSortArray() {

        int[] numbers = {5, 2, 3, 4, 1};

        int[] sorted = arraySorter.sort(numbers);
        int[] expected = {1, 2, 3, 4, 5};

        assertArrayEquals(sorted, expected);
    }

    @Test
    public void testOriginalArrayNotChanged() {

        int[] numbers = {5, 2, 3, 4, 1};

        arraySorter.sort(numbers);

        int[] expected = {5, 2, 3, 4, 1};

        assertArrayEquals(numbers, expected);
    }

    @Test
    public void testDuplicatedValues() {

        int[] numbers = {3, 2, 3, 2, 1, 1,};

        int[] sorted = arraySorter.sort(numbers);
        int[] expected = {1, 1, 2, 2, 3, 3};

        assertArrayEquals(sorted, expected);
    }

    @Test
    public void testNegativeValues() {

        int[] numbers = {-3, 2, 3, -2, -1, 1,};

        int[] sorted = arraySorter.sort(numbers);
        int[] expected = {-3, -2, -1, 1, 2, 3};

        assertArrayEquals(sorted, expected);
    }

    @Configuration
    @ComponentScan
    public static class ArraySorterTestConfig {
    }

}