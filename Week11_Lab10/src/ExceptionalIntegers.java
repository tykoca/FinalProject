import java.util.ArrayList;

public class ExceptionalIntegers {
    public static void main(String[] args) {

        int index;



        //new array of integer objects
        ArrayList<Integer> intList = new ArrayList<>();

        //loops through args checking if each arg can be converted to int and prints whether it can be converted
        for (String arg : args) {
            try {
                Integer intObj = convertStringToInt(arg);
                System.out.println("Converter method says integer OK - " + intObj);
                intList.add(intObj);
            } catch (NumberFormatException e) {
                System.out.println("Catch block says the argument \"" + arg + "\" is ignored because " + arg);
            }
        }

        //printing the integer objects
        System.out.println("\nArrayList contents are:");
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("Item " + i + " is " + intList.get(i));
        }
    }

    //converting to integer objects
    public static Integer convertStringToInt(String str) throws NumberFormatException {
        int intValue = Integer.parseInt(str);
        return Integer.valueOf(intValue);
    }

}
