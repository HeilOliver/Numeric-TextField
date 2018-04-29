package at.ohe.numerictextfield;

/**
 * at.ohe.numerictextfield
 * ShortValidator
 * 29/04/2018 Oliver
 * <p>
 * An implementation of the abstract class {@link NumberValidator}
 * for the type {@link short}
 */
class ShortValidator extends NumberValidator {

    /**
     * Create an {@link ShortValidator} with the MaxValue and MinValue of an {@link short}
     */
    ShortValidator() {
        super(Short.MAX_VALUE, Short.MIN_VALUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number getNumber(String s) throws NumberFormatException {
        return Short.parseShort(s);
    }
}
