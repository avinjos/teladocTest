package com.teladoc.util;

public class NumberUtility {

    private final static String EMPTY_STRING = "";
    private final static String ZERO_STRING = "0";
    // smallest possible unicode digit '0', '0' == short 48
    private final static short ZERO_CHAR = 48;

    /**
     *
     * @param str1 String representation of positive a number
     * @param str2 String representation of positive a number
     * @return String representation of resulting number from addition of str1 & str2
     */
    public String addNumbers(String str1, String str2) {
        // If one of the passed in strings is null , empty or "0" just return the other string
        if (isBlankString(str1) || str1.equals(ZERO_STRING)) {
            return isBlankString(str2) ? EMPTY_STRING : str2;
        } else if (isBlankString(str2) || str2.equals(ZERO_STRING)) {
            return isBlankString(str1) ? EMPTY_STRING : str1;
        }

        // Ensuring length of str2 is larger
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        // String builder for storing the result
        StringBuilder result = new StringBuilder();

        // Calculate length of both String
        int n1 = str1.length(), n2 = str2.length();
        int diff = n2 - n1;

        // Initially take carry zero
        int carry = 0;

        // Traverse from end of both Strings and computer sum of digits and carry in each step
        for (int i = n1 - 1; i >= 0; i--) {
            // compute sum of current digits and carry
            int sum = ((str1.charAt(i) - ZERO_CHAR) + (str2.charAt(i + diff) - ZERO_CHAR) + carry);
            result.append((char) (sum % 10 + ZERO_CHAR));
            carry = sum / 10;
        }

        // Add remaining digits of str2[]
        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = ((str2.charAt(i) - '0') + carry);
            result.append((char) (sum % 10 + '0'));
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            result.append((char) (carry + '0'));

        // reverse resultant String
        return result.reverse().toString();
    }

    boolean isBlankString(String string) {
        return string == null || string.isBlank();
    }

    //Driver code
    public static void main(String [] args){
        NumberUtility numberUtility = new NumberUtility();
        System.out.println("Result = " +  numberUtility.addNumbers("1234567890123456789016372468321648513759702436782367523475467325786423767853467832186781628768721687168347595294058524390509",
                "4578623756123784678312764987478137643273467632147461278643675819365607316507843673816056874364374678347283476547325679561975346"));
        System.out.println("Result = " +  numberUtility.addNumbers("123456789012345678901","12345678"));
        System.out.println("Result = " +  numberUtility.addNumbers("11","123"));
        System.out.println("Result = " +  numberUtility.addNumbers("0","123"));
        System.out.println("Result = " +  numberUtility.addNumbers(null,null));
        System.out.println("Result = " +  numberUtility.addNumbers("999",null));
        System.out.println("Result = " +  numberUtility.addNumbers("817",""));
    }
}
