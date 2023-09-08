package sample;

public class NumberConverter {
    final String[] SINGLE_DIGIT_WORDS = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    final String[] TEEN_WORDS = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] TENS_WORDS = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};

    private void appendWord(StringBuilder sb, String... words) {
        for (String word : words) {
            sb.append(word);
        }
    }

    private char[] reverseArray(char[] arr) {
        int length = arr.length;
        char[] reversed = new char[length];

        for (int i = 0; i < length; i++) {
            reversed[i] = arr[length - 1 - i];
        }
        return reversed;
    }

    private String handleTeens(String numberStr) {
        int number = Integer.parseInt(numberStr);
        return TEEN_WORDS[number - 10];
    }

    public String convertNumberToWords(String number) {
        if (number.length() > 1 && number.charAt(number.toCharArray().length - 2) == '1') {
            String firstHalf = number.substring(0, number.toCharArray().length - 2);
            String secondHalf = number.substring(number.toCharArray().length - 2);
            int count = number.length() - firstHalf.length();
            if (number.length() == 2) {
                return handleTeens(number);
            } else {
                return convertNumberToWords(firstHalf + "0".repeat(count)) + " " + handleTeens(secondHalf);
            }
        }

        StringBuilder returnNumber = new StringBuilder();
        String[] units = {"", "ty ", " Hundred ", " Thousand "};
        char[] numbersArray = reverseArray(number.toCharArray());

        for (int i = numbersArray.length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(numbersArray[i]);
            switch (digit) {
                case 1:
                    appendWord(returnNumber, SINGLE_DIGIT_WORDS[1], units[i]);
                    break;
                case 2:
                    if (i == 1) appendWord(returnNumber, TENS_WORDS[2]);
                    else appendWord(returnNumber, SINGLE_DIGIT_WORDS[2], units[i]);
                    break;
                case 3:
                    if (i == 1) appendWord(returnNumber, TENS_WORDS[3]);
                    else appendWord(returnNumber, SINGLE_DIGIT_WORDS[3], units[i]);
                    break;
                case 4:
                    if (i == 1) appendWord(returnNumber, TENS_WORDS[4]);
                    else appendWord(returnNumber, SINGLE_DIGIT_WORDS[4], units[i]);
                    break;
                case 5:
                    if (i == 1) appendWord(returnNumber, TENS_WORDS[5]);
                    else appendWord(returnNumber, SINGLE_DIGIT_WORDS[5], units[i]);
                    break;
                case 6:
                    appendWord(returnNumber, SINGLE_DIGIT_WORDS[6], units[i]);
                    break;
                case 7:
                    appendWord(returnNumber, SINGLE_DIGIT_WORDS[7], units[i]);
                    break;
                case 8:
                    if (i == 1) appendWord(returnNumber, TENS_WORDS[8]);
                    else appendWord(returnNumber, SINGLE_DIGIT_WORDS[8], units[i]);
                    break;
                case 9:
                    appendWord(returnNumber, SINGLE_DIGIT_WORDS[9], units[i]);
                    break;
                default:
                    break;
            }
        }

        return returnNumber.toString().trim();
    }
}
