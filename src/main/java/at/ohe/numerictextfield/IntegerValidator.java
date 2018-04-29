package at.ohe.numerictextfield;


/**
 * at.ohe.numerictextfield
 * DoubleValidator
 * 29/04/2018 Oliver
 * <p>
 * An implementation of the abstract class {@link NumberValidator}
 * for the type {@link int}
 */
class IntegerValidator extends NumberValidator {

    /**
     * Create an IntegerValidator with the MaxValue and MinValue of an int
     */
    IntegerValidator() {
        super(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number getNumber(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }
}
