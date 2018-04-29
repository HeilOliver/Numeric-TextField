package at.ohe.numerictextfield;

import static java.lang.Byte.parseByte;

/**
 * at.ohe.numerictextfield
 * ByteValidator
 * 29/04/2018 Oliver
 * <p>
 * An implementation of the abstract class {@link NumberValidator}
 * for the type {@link byte}
 */
class ByteValidator extends at.ohe.numerictextfield.NumberValidator {

    /**
     * Create an ByteValidator with the MaxValue and MinValue of an byte
     */
    ByteValidator() {
        super(Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number getNumber(String s) throws NumberFormatException {
        return parseByte(s);
    }
}
