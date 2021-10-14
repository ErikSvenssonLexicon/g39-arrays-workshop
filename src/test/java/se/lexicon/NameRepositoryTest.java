package se.lexicon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameRepositoryTest {

    @Before
    public void setUp() throws Exception {
        NameRepository.clear();
    }

    @Test
    public void getSize() {
        int expectedSize = 0;
        int actual = NameRepository.getSize();

        assertEquals(actual, expectedSize);
    }

    @Test
    public void setNames() {
        String[] data = {"Erik Svensson", "Sofia Örnberg"};
        int expectedSize = 2;

        NameRepository.setNames(data);

        assertEquals(NameRepository.getSize(), expectedSize);
    }

    @Test
    public void clear() {
        String[] data = {"Erik Svensson", "Sofia Örnberg"};
        NameRepository.setNames(data);
        int expectedSize = 0;

        NameRepository.clear();

        assertEquals(NameRepository.getSize(), expectedSize);
    }

    @Test
    public void findAll() {
        String[] expected = {"Erik Svensson", "Sofia Örnberg"};

        NameRepository.setNames(expected);

        String[] result = NameRepository.findAll();

        assertArrayEquals(result, expected);
    }
}