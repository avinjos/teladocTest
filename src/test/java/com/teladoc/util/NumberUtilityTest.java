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

