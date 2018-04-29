package at.ohe.numerictextfield;

import static java.lang.Double.parseDouble;

/**
 * at.ohe.numerictextfield
 * DoubleValidator
 * 29/04/2018 Oliver
 * <p>
 * An implementation of the abstract class {@link NumberValidator}
 * for the type {@link double}
 */
class DoubleValidator extends NumberValidator {

    /**
     * Create an DoubleValidator with the MaxValue and MinValue of an double
     */
    DoubleValidator() {
        super(Double.MAX_VALUE, Double.MIN_VALUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number getNumber(String s) throws NumberFormatException {
        return parseDouble(s);
    }
}
