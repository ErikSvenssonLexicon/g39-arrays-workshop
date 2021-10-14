package se.lexicon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameRepositoryTest {

    private String[] data;

    @Before
    public void setUp() {
        NameRepository.clear();
        String[] starterData = {"Basel Askar", "Fabrice Badia", "Erik Alfredsson", "Tony Granath"};
        data = starterData;
        NameRepository.setNames(starterData);
    }

    @Test
    public void getSize() {
        int expectedSize = 4;
        int actual = NameRepository.getSize();

        assertEquals(actual, expectedSize);
    }

    @Test
    public void setNames() {
        NameRepository.clear();
        String[] data = {"Erik Svensson", "Sofia Örnberg"};
        int expectedSize = 2;

        NameRepository.setNames(data);

        assertEquals(NameRepository.getSize(), expectedSize);
    }

    @Test
    public void clear() {
        int expectedSize = 0;

        NameRepository.clear();

        assertEquals(NameRepository.getSize(), expectedSize);
    }

    @Test
    public void findAll() {
        String[] expected = data;

        NameRepository.setNames(expected);

        String[] result = NameRepository.findAll();

        assertArrayEquals(result, expected);
    }

    @Test
    public void find() {
        String fullName = "fabrice badia";
        String expected = "Fabrice Badia";

        String result = NameRepository.find(fullName);

        assertEquals(result, expected);
    }

    @Test
    public void add() {
        String fullName = "Sauda Ahmed";
        assertTrue(NameRepository.add(fullName));
        assertEquals(5, NameRepository.getSize());
    }

    @Test
    public void add_false(){
        String fullName = "basel askar";
        assertFalse(NameRepository.add(fullName));
        assertEquals(4, NameRepository.getSize());
    }
}