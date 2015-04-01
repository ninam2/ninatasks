package de.ninam.recruitingtasks.task5;

import de.ninam.recruitingtasks.task3.ArraySorter;
import de.ninam.recruitingtasks.task4.StringCompressor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CharGrouper{


    @Autowired
    private ArraySorter arraySorter;

    @Autowired
    private StringCompressor stringCompressor;



    public String group(String ungrouped) {
        // sort
        int[] unsortedIntArray = new int[ungrouped.length()];
        for(int i = 0; i < ungrouped.length(); i++){
            unsortedIntArray[i] = ungrouped.charAt(i);
        }
        int[] sorted = arraySorter.sort(unsortedIntArray);
        String sortedString = "";
        for(int i : sorted) {
            //sortedString = sortedString + i;
            String sortedString2 = Character.toString((char) i);
            sortedString=sortedString+sortedString2;
        }
        //compress
        return stringCompressor.compress(sortedString);
    }
}
