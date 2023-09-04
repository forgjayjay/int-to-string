package sample;
/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */

public class NumberConverter {
    /**
     * This class should be implemented to provide number conversion utilities.
     *
     * Objective:
     *  Implement a method that converts a number in String format to its corresponding 
     *  English word representation.
     *
     * Example:
     *  Input: "25"
     *  Output: "Twenty Five"
     *
     *  Input: "982"
     *  Output: "Nine Hundred Eighty Two"
     *
     * Note: Consider numbers between 1 and 9999 for this exercise.
     *
     * @return the English word representation of the input number.
     */

    final String ONE = "One";
    final String TWO = "Two";
    final String THREE = "Three";
    final String FOUR = "Four";
    final String FIVE = "Five";
    final String SIX = "Six";
    final String SEVEN = "Seven";
    final String EIGHT = "Eight";
    final String NINE = "Nine";
    final String TEN = "Ten";
    final String ELEVEN = "Eleven";
    final String TWELVE = "Twelve";
    final String THIRTEEN = "Thirteen";
    final String TWENTY = "Twen";
    final String THIRTY = "Thir";
    final String FORTY = "For";
    final String FIFTY = "Fif";
    final String EIGHTY = "Eigh";

    private void appendToString(StringBuilder sb, String text){
            sb.append(text);
    }
    
    private char[] flipArray(char[] arr) {
        int length = arr.length;
        char[] flipped = new char[length];

        for (int i = 0; i < length; i++) {
            flipped[i] = arr[length - 1 - i];
        }
        return flipped;
    }
    
    private String handleTeens(String numberStr) {
        int number = Integer.parseInt(numberStr);
        String[] words = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        return words[number - 10];
    }

    public String convertNumberToWords(String number) {
        //If statement to handle the "-teens"
        if(number.length() > 1 && number.charAt(number.toCharArray().length-2) == '1'){
            String firstHalf = number.substring(0, number.toCharArray().length-2);
            String secondHalf = number.substring(number.toCharArray().length-2);
            int count = number.length()-firstHalf.length();
            if (number.length() == 2) {
                return handleTeens(number);
            } else {
                return convertNumberToWords(firstHalf+"0".repeat(count)) + " " + handleTeens(secondHalf);
            }
        }

        StringBuilder returnNumber = new StringBuilder();

        String[] endStrings = {" ", "ty ", " Hundred ", " Thousand "};

        char[] numbersArray = flipArray(number.toCharArray());
        
        for (int i = numbersArray.length-1; i >= 0; i--) {
            int x = Character.getNumericValue(numbersArray[i]);
            switch (x) {
                case 1:
                        appendToString(returnNumber, ONE);
                        break;
                case 2:
                        if(i==1) appendToString(returnNumber, TWENTY);
                        else appendToString(returnNumber, TWO);
                        break;
                case 3:
                        if(i==1) appendToString(returnNumber, THIRTY);
                        else appendToString(returnNumber, THREE);
                        break;
                case 4:
                        if(i==1) appendToString(returnNumber, FORTY);
                        else appendToString(returnNumber, FOUR);
                        break;
                case 5:
                        if(i==1) appendToString(returnNumber, FIFTY);
                        else appendToString(returnNumber, FIVE);
                        break;
                case 6:
                        appendToString(returnNumber, SIX);
                        break;
                case 7:
                        appendToString(returnNumber, SEVEN);
                        break;
                case 8:
                        if(i==1) appendToString(returnNumber, EIGHTY);
                        else appendToString(returnNumber, EIGHT);
                        break;
                case 9:
                        appendToString(returnNumber, NINE);
                            break;
                default:
                    break;
            }

            if(x!=0) appendToString(returnNumber, endStrings[i]);

        }

        return returnNumber.toString().trim();
    }
}