package at.ohe.numerictextfield;

/**
 * at.ohe.numerictextfield
 * INumberValidator
 * 29/04/2018 Oliver
 * <p>
 * Enter Description here
 */
public interface INumberValidator {

    boolean isValid(String s, double maxValue, double minValue);

    Number getNumber(String s) throws NumberFormatException;
}
