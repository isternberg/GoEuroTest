package com.goeuro.validation;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class InputValidatorTest {

    InputValidator inputValidator;

    @Before
    public void setUp() throws Exception {
        inputValidator = new InputValidator();
    }

    @Test
    public void shouldReturnFalseForMultipleArguments(){
        assertFalse(inputValidator.inputOK("foo", "bar"));
    }

    @Test
    public void shouldReturnFalseForEmptyString(){
        assertFalse(inputValidator.inputOK(""));
        assertFalse(inputValidator.inputOK("    "));
    }

    @Test
    public void shouldReturnFalseForNull(){
        String foo = null;
        assertFalse(inputValidator.inputOK(foo));
    }

    @Test
    public void shouldReturnTrueForStringContainingWhiteSpace(){
        assertTrue(inputValidator.inputOK(" tel aviv "));
    }

    @Test
    public void shouldReturnTrueForCapitalizedString(){
        assertTrue(inputValidator.inputOK("BERlin"));
    }
}