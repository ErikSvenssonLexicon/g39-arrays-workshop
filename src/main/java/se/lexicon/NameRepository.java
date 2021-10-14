package se.lexicon;

import java.util.Arrays;

public class NameRepository {

    private static String[] names = new String[0];

    public static int getSize(){
        return names.length;
    }

    public static void setNames(String[] names){
        NameRepository.names = names;
    }

    public static void clear(){
        names = new String[0];
    }

    public static String[] findAll(){
        return Arrays.copyOf(names, names.length);
    }

}
