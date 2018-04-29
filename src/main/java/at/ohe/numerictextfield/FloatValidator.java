package at.ohe.numerictextfield;

/**
 * at.ohe.numerictextfield
 * FloatValidator
 * 29/04/2018 Oliver
 * <p>
 * An implementation of the abstract class {@link NumberValidator}
 * for the type {@link float}
 */
class FloatValidator extends NumberValidator {

    /**
     * Create an FloatValidator with the MaxValue and MinValue of an float
     */
    FloatValidator() {
        super(Float.MAX_VALUE, Float.MIN_VALUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number getNumber(String s) throws NumberFormatException {
        return Float.parseFloat(s);
    }
}
