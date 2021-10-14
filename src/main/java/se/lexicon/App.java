package se.lexicon;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        String[] data = {"Erik Svensson", "Basel Askar", "Erik Alfredsson", "Anders Svensson"};

        NameRepository.setNames(data);

        String[] eriks = NameRepository.findByFirstName("Erik");
        System.out.println(Arrays.toString(eriks));
        String[] svenssons = NameRepository.findByLastname("Svensson");
        System.out.println(Arrays.toString(svenssons));

        System.out.println(NameRepository.update("Anders Svensson", "Ola Svensson"));
        System.out.println(Arrays.toString(NameRepository.findAll()));

    }
}
