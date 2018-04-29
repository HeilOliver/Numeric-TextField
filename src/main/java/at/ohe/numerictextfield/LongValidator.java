package at.ohe.numerictextfield;

/**
 * at.ohe.numerictextfield
 * LongValidator
 * 29/04/2018 Oliver
 * <p>
 * An implementation of the abstract class {@link NumberValidator}
 * for the type {@link long}
 */
class LongValidator extends NumberValidator {

    /**
     * Create an LongValidator with the MaxValue and MinValue of an long
     */
    LongValidator() {
        super(Long.MAX_VALUE, Long.MIN_VALUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number getNumber(String s) throws NumberFormatException {
        return Long.parseLong(s);
    }
}
