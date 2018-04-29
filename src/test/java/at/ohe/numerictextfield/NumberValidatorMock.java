package at.ohe.numerictextfield;

/**
 * numerictextfield
 * at.ohe.numerictextfield
 * NumberValidatorMock
 * 29/04/2018 Oliver
 * <p>
 * Enter Description here
 */
public class NumberValidatorMock extends NumberValidator {

    private IValidatorMock mock;

    NumberValidatorMock(double typeMaxValue, double typeMinValue, IValidatorMock mock) {
        super(typeMaxValue, typeMinValue);
        this.mock = mock;
    }

    @Override
    public Number getNumber(String s) throws NumberFormatException {
        return mock.getNumber(s);
    }

    interface IValidatorMock {
        Number getNumber(String s);
    }
}
