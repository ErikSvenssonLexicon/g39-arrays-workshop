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
        names = addToArray(names, fullName);
        return true;
    }

    public static String[] findByFirstName(final String firstName){
        //Create empty array
        String[] result = {};

        //Iterate though names
        for(String fullName : names){
            //Extracting each first name
            String fName = fullName.substring(0, fullName.indexOf(" "));
            //Check if firstname equals ignoring case fName
            if(fName.equalsIgnoreCase(firstName)){
                //Call private method that handle adding fullName to array
                result = addToArray(result, fullName);
            }
        }
        return result;
    }

    public static String[] findByLastname(final String lastName){
        //Create empty array
        String[] result = {};

        //Iterate though names
        for(String fullName : names){
            //Extracting each last name
            String lName = fullName.substring(fullName.indexOf(" ") + 1);
            //Check if lastname equals ignoring case lName
            if(lName.equalsIgnoreCase(lastName)){
                //Call private method that handle adding fullName to array
                result = addToArray(result, fullName);
            }
        }
        return result;
    }

    private static int indexOf(String[] array, String string){
        int invalidIndex = -1;
        for(int i=0; i<array.length; i++){
            String content = array[i];
            if(content.equalsIgnoreCase(string)){
                return i;
            }
        }
        return invalidIndex;
    }

    public static boolean update(final String original, final String updatedName){
        int originalIndex = indexOf(names, original);
        if(originalIndex == -1){
            return false;
        }
        int updatedIndex = indexOf(names, updatedName);
        if(updatedIndex != -1){
            return false;
        }
        names[originalIndex] = updatedName;
        return true;
    }

    private static String[] addToArray(String[] source, String string) {
        String[] temp = Arrays.copyOf(source, source.length + 1);
        temp[temp.length-1] = string;
        return temp;
    }


}
