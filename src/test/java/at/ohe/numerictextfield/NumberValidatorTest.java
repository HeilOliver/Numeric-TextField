package at.ohe.numerictextfield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberValidatorTest {

    @Test
    void isValid_Ok() {
        NumberValidatorMock validator = new NumberValidatorMock(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer::parseInt);

        Assertions.assertTrue(validator.isValid("10", 10, -10));
        Assertions.assertTrue(validator.isValid("-10", 10, -10));
        Assertions.assertTrue(validator.isValid("0", 10, -10));

        Assertions.assertFalse(validator.isValid("-11", 10, -10));
        Assertions.assertFalse(validator.isValid("11", 10, -10));
    }

    @Test
    void isValid_NoNumber() {
        NumberValidatorMock validator = new NumberValidatorMock(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer::parseInt);

        Assertions.assertFalse(validator.isValid("-", 10, -10));
        Assertions.assertFalse(validator.isValid("a", 10, -10));
        Assertions.assertFalse(validator.isValid("6g", 10, -10));
    }

    @Test
    void isValid_ValueOverride() {
        NumberValidatorMock validator = new NumberValidatorMock(5, -5, Integer::parseInt);

        Assertions.assertFalse(validator.isValid("10", 10, -10));
        Assertions.assertTrue(validator.isValid("5", 10, -10));

        Assertions.assertFalse(validator.isValid("-10", 10, -10));
        Assertions.assertTrue(validator.isValid("-5", 10, -10));
    }

    @Test
    void getNumber() {
        NumberValidatorMock validator = new NumberValidatorMock(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer::parseInt);

        assertNotNull(validator.getNumber("10"));
        assertThrows(NumberFormatException.class, () -> validator.getNumber("a"));
    }
}