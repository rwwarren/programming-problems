import java.util.*;

/**
 * Created by ryanwarren on 11/5/14.
 */
public class numberToRomanNumeral {
    //Take a number and convert it to a roman numeral

    private static Map<Integer, String> numeralMap;
    public static void main(String[] args){
        System.out.println("this is the beginning of the program");
        int[] arr = {1,2,3,4,5,6,7,8,9,10, 44,50, 100, 101, 500};
        numeralMap = new TreeMap<Integer, String>();
        numeralMap.put(1, "I");
        numeralMap.put(4, "IV");
        numeralMap.put(5, "V");
        numeralMap.put(9, "IX");
        numeralMap.put(10, "X");
        numeralMap.put(40, "XL");
        numeralMap.put(50, "L");
        numeralMap.put(90, "XC");
        numeralMap.put(100, "C");
        numeralMap.put(400, "CD");
        numeralMap.put(500, "D");
        numeralMap.put(900, "DM");
        numeralMap.put(1000, "M");
        printNumerals(arr);

    }

    public static void printNumerals(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " turns into: " + convertNumeral(arr[i]));
        }
    }

    public static String convertNumeral(int number){
        String result = "";
        int current = number;

        Object[] keys = numeralMap.keySet().toArray();

        for(int i = keys.length - 1; i >= 0; i--){
            Integer currentKey = (Integer) keys[i];
            if(current - currentKey >= 0){
                Integer times = current / currentKey;
                for(int j = 0; j < times; j++){
                    result += numeralMap.get(currentKey);
                    current -= currentKey;

                }
            }
        }
        return result;
    }

}
