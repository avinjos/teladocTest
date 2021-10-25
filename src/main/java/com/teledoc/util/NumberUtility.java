package com.teledoc.util;

public class NumberUtility {

    public String addNumbers(String str1, String str2) {
        // If one of the passed in strings is null , empty or "0" just return the other string
        if(str1 == null || str1.equalsIgnoreCase("") || str1.equals("0")){
            return str2;
        }else if( str2 == null ||  str2.equalsIgnoreCase("") || str2.equals("0")){
            return str1;
        }

        // Ensuring length of str2 is larger
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        // Take an empty String for storing result
        String result = "";

        // Calculate length of both String
        int n1 = str1.length(), n2 = str2.length();
        int diff = n2 - n1;

        // Initially take carry zero
        int carry = 0;

        // Traverse from end of both Strings
        for (int i = n1 - 1; i >= 0; i--) {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((str1.charAt(i) - '0') +
                    (str2.charAt(i + diff) - '0') + carry);
            result += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining digits of str2[]
        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = ((str2.charAt(i) - '0') + carry);
            result += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            result += (char) (carry + '0');

        // reverse resultant String
        return new StringBuilder(result).reverse().toString();
    }
}
