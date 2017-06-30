/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varianta.one.action;

import java.util.Scanner;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Action {
    
    String pattern = "(\\s)+|($)";

    /**
     *
     * @return String[] masNum numbers' array
     */
    public String[] Numbers() {
        boolean result;
        float number;
        String[] masNum = null;
        try (Scanner scan = new Scanner(System.in)) {
            result = false;
            String str = scan.nextLine();
            for (String retval : str.split(pattern)) {
                try {
                    if (!retval.isEmpty()) {
                        number = Float.valueOf(retval);
                        result = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат чисел!");
                    result = false;
                    break;
                }
            }
            scan.close();
            if (result) {
                masNum = str.split(pattern);
            }
        }
        return masNum;
    }
    
    /**
     *
     * @param mas
     */
    public void CompareNumbers(String[] mas) {
        String maxLengthNumber=mas[0];
        String minLengthNumber=mas[0];
        int lengthMaxNumber=mas[0].length();
        int lengthMinNumber=mas[0].length();
        for (String str:mas) {
            if (lengthMaxNumber<str.length()){
               lengthMaxNumber=str.length();
               maxLengthNumber=str;
            }
            if  (lengthMinNumber>str.length()){
               lengthMinNumber=str.length();
               minLengthNumber=str;
            }
        }
        System.out.println("Cамое короткое число - "+minLengthNumber+", длина числа - "+lengthMinNumber);
        System.out.println("Cамое длинное число - "+maxLengthNumber+", длина числа - "+lengthMaxNumber);
    }
}
