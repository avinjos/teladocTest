package com.teladoc.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.teledoc.util.NumberUtility;
import org.junit.jupiter.api.Test;

public class StringNumbersTest {

    private final NumberUtility numberUtility = new NumberUtility();

    @Test
    void addNumbersTest() {
        assertEquals("123", numberUtility.addNumbers("0", "123"));
    }

    @Test
    void addNumbersTestWithOneNullParameter() {
        assertEquals("1233467899", numberUtility.addNumbers("1233467899", null));
    }

    @Test
    void addNumbersTestWithNullParameters() {
        assertEquals(null, numberUtility.addNumbers(null, null));
    }

    @Test
    void addNumbersTestWithOneEmptyStringParameter() {
        assertEquals("1233467899", numberUtility.addNumbers("1233467899", ""));
    }

    @Test
    void addNumbersTestWithEmptyStringParameters() {
        assertEquals("", numberUtility.addNumbers("", ""));
    }

}
