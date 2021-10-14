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

    public static String find(final String fullName){
        for(String s : names){
            if(s.equalsIgnoreCase(fullName)){
                return s;
            }
        }
        return null;
    }

    public static boolean add(final String fullName){
        if(find(fullName) != null){
            return false;
        }
        String[] temp = Arrays.copyOf(names, names.length + 1);
        temp[temp.length-1] = fullName;
        names = temp;
        return true;
    }















}
