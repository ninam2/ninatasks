package de.ninam.recruitingtasks.task4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isNotBlank;


/**
 * Utility that helps compressing Strings
 */
@Service
public class StringCompressor {

    @Autowired
    private StringUtils stringUtils;

    /**
     * Compresses a given String
     *
     * @param uncompressed uncompressed String
     * @return Compressed String or uncompressed String if compressed String would have same length as uncompressed
     */
    public String compress(final String uncompressed) {

        final String compressed = executeCompress(uncompressed);
        if(compressed.length() >= uncompressed.length()) {
            return uncompressed;
        }
        return compressed;
    }

    private String executeCompress(final String toCompress) {

        final int letterCount = stringUtils.countFirstLetter(toCompress);
        char current = toCompress.charAt(0);

        // add character and count (if >1) and character to compressed string
        String compressed = letterCount > 1 ? String.valueOf(current) + letterCount : String.valueOf(current);

        String substring = getSubString(toCompress, letterCount);
        if (substring.isEmpty()) {
            // we are finished
            return (compressed.length() < toCompress.length()) ? compressed : toCompress;
        }
        return compressed + executeCompress(getSubString(toCompress, letterCount));
    }

    public String getSubString(String original, int index) {
        if (isNotBlank(original) && index <= original.length()) {
           return original.substring(index);
        }
        return "";
    }
}