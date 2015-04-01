package de.ninam.recruitingtasks.task4;

import de.ninam.recruitingtasks.TasksConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TasksConfig.class)
public class StringCompressorTest {

    @Autowired
    private StringCompressor stringCompressor;

    @Test
    public void testCompressSimple() {

        String uncompressed = "aaa";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals("a3", compressed);
    }

    @Test
    public void testCompressMoreComplex() {

        String uncompressed = "aaabbbbcaaddddddd";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals("a3b4ca2d7", compressed);
    }

    @Test
    public void testCompressWithNonOptimizedResult() {

        String uncompressed = "hello";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals(uncompressed, compressed);
    }
}