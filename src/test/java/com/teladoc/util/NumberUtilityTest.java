package com.teladoc.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilityTest {

    private final NumberUtility numberUtility = new NumberUtility();
    private final static String EMPTY_STRING = "";

    @Test
    void addNumbersTest() {
        assertEquals("123", numberUtility.addNumbers("0", "123"));
    }


    @Test
    void addNumbersTest_WithLargeNumbers() {
        assertEquals("4579858324013908135101781359946459291787227334584243646167151286691393740275697141648243655993143400034451824142619738086365855", numberUtility.addNumbers("1234567890123456789016372468321648513759702436782367523475467325786423767853467832186781628768721687168347595294058524390509",
                "4578623756123784678312764987478137643273467632147461278643675819365607316507843673816056874364374678347283476547325679561975346"));
    }

    @Test
    void addNumbersTest_WithOneNullParameter() {
        assertEquals("1233467899", numberUtility.addNumbers("1233467899", null));
    }

    @Test
    void addNumbersTest_WithNullParameters() {
        assertEquals(EMPTY_STRING, numberUtility.addNumbers(null, null));
    }

    @Test
    void addNumbersTest_WithOneEmptyStringParameter() {
        assertEquals("1233467899", numberUtility.addNumbers("1233467899", EMPTY_STRING));
    }

    @Test
    void addNumbersTest_WithEmptyStringParameters() {
        assertEquals("", numberUtility.addNumbers(EMPTY_STRING, EMPTY_STRING));
    }

    @Test
    void addNumbersTest_LargeNumbers() {
        assertEquals("123456789012358024579", numberUtility.addNumbers("123456789012345678901", "12345678"));
    }

    @Test
    void addNumbersTest_LargeNumbers2() {
        assertEquals("", numberUtility.addNumbers("    ", "   "));
    }

    @Test
    void isBlankStringTest_WithEmptySpaces() {
        assertTrue(numberUtility.isBlankString("   "));
    }

    @Test
    void isBlankStringTest_WithEmptyString() {
        assertTrue(numberUtility.isBlankString(EMPTY_STRING));
    }

    @Test
    void isBlankStringTest_WithNull() {
        assertTrue(numberUtility.isBlankString(null));
    }

    @Test
    void isBlankStringTest_WithString() {
        assertFalse(numberUtility.isBlankString("ABC"));
    }
}

