package de.ninam.recruitingtasks.task3;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArraySorter {

    /**
     * @param unsorted unsorted array of integers
     */
    public int[] sort(int[] unsorted) {

        int[] copy = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(copy);
        return copy;
    }
}
