package de.ninam.recruitingtasks.task5;

import de.ninam.recruitingtasks.task3.ArraySorter;
import de.ninam.recruitingtasks.task4.StringCompressor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoCharGrouperTest {

    @InjectMocks
    CharGrouper charGrouper;

    @Mock
    ArraySorter arraySorterMock;

    @Spy
    StringCompressor stringCompressorMock = new StringCompressor();

    @Test
    public void testSortCompress() {
        //charGrouper = new CharGrouper();
        //arraySorterMock = mock(ArraySorter.class);
        //stringCompressorMock = mock(StringCompressor.class);
//        stringCompressorMock = spy(new StringCompressor());
        //charGrouper.arraySorter=arraySorterMock;
        //charGrouper.stringCompressor=stringCompressorMock;

        arraySorterMock.sort(new int[0]);
        when(arraySorterMock.sort(Matchers.<int[]>anyObject())).thenReturn(new int[]{97, 98, 99, 100});

        doReturn("").when(stringCompressorMock).compress(anyString());
        when(stringCompressorMock.compress("abcd")).thenReturn("SUCCESS");

        String group = charGrouper.group("abcd");

        // verify(arraySorterMock).sort(eq(new int[]{97, 98, 97}));

        //verify(stringCompressorMock).compress("aba");

        assertEquals("SUCCESS", group);
    }

    @Test
    public void testSortCompressAnyKey() {
        //charGrouper = new CharGrouper();
        //arraySorterMock = mock(ArraySorter.class);
        //stringCompressorMock = mock(StringCompressor.class);
//        stringCompressorMock = spy(new StringCompressor());
        //charGrouper.arraySorter=arraySorterMock;
        //charGrouper.stringCompressor=stringCompressorMock;

        arraySorterMock.sort(new int[0]);
        when(arraySorterMock.sort(Matchers.<int[]>anyObject())).thenReturn(new int[]{});

        doReturn("").when(stringCompressorMock).compress(anyString());
        when(stringCompressorMock.compress("abcd")).thenReturn("SUCCESS");

        String group = charGrouper.group("");

        // verify(arraySorterMock).sort(eq(new int[]{97, 98, 97}));

        //verify(stringCompressorMock).compress("aba");

        assertEquals("", group);
    }
}