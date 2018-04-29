package at.ohe.numerictextfield;


/**
 * at.ohe.numerictextfield
 * NumberValidator
 * 29/04/2018 Oliver
 * <p>
 * A implementation of the {@link INumberValidator} interface.
 */
abstract class NumberValidator implements INumberValidator {
    private double typeMaxValue;
    private double typeMinValue;

    /**
     * Create an Validator with the given type constrains. This constrains
     * are used to check the parameter in the {@code isValid} method.
     *
     * @param typeMaxValue - The maximal value that this type can have
     * @param typeMinValue - The minimal value that this type can have
     */
    NumberValidator(double typeMaxValue, double typeMinValue) {
        this.typeMaxValue = typeMaxValue;
        this.typeMinValue = typeMinValue;
    }

    /**
     * Checks if the given {@link String} is valid.
     * The max and min Value will be check against the type max and min Value.
     * If a given value is out of range of this type, the type value will be used.
     *
     * @param s        - The String that is been checked
     * @param maxValue - the maximal value that the parsed number allowed to be
     * @param minValue - the minimal value that the parsed number allowed to be
     * @return - true if the given String passes all constrain checks and the number is in the given range
     */
    public boolean isValid(String s, double maxValue, double minValue) {
        maxValue = maxValue > typeMaxValue ? typeMaxValue : maxValue;
        minValue = minValue < typeMinValue ? typeMinValue : minValue;

        try {
            Number number = getNumber(s);
            if (number.doubleValue() < minValue || number.doubleValue() > maxValue)
                return false;
        } catch (NumberFormatException ignore) {
            return false;
        }
        return true;
    }

    /**
     * Parses an String to an {@link Number}.
     *
     * @param s - The given String that should be parsed
     * @return - an {@link Number} that represents the given String value
     * @throws NumberFormatException - Thrown if the given string couldn't be parsed
     */
    public abstract Number getNumber(String s) throws NumberFormatException;
}
