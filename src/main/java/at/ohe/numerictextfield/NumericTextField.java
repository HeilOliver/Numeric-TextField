package at.ohe.numerictextfield;

import javafx.beans.property.*;
import javafx.scene.control.TextField;

import java.util.function.Supplier;


/**
 * at.ohe.numerictextfield
 * NumericTextField
 * 29/04/2018 Oliver
 * <p>
 * A simple text field which only allows numbers.
 * With the maximum value and the minimum value, restriction of the value range can be created.
 * All input values are checked using an {@link NumberValidator}.
 * As default the {@link NumericType} - {@code Integer} is used.
 */
public class NumericTextField extends TextField {
    private final DoubleProperty maxValue = new SimpleDoubleProperty();
    private final DoubleProperty minValue = new SimpleDoubleProperty();
    private final ObjectProperty<Number> number = new SimpleObjectProperty<>();
    private final ObjectProperty<NumericType> type = new SimpleObjectProperty<>();
    private INumberValidator currValidator;

    /**
     * Creates an NumericTextField with the restriction of min and max value and an specific
     * {@link NumericType} type
     *
     * @param minValue - the minimal Value that an input can be set
     * @param maxValue - the maximal Value that an input can be set
     * @param type     - an specified type that should be used to validate input text
     */
    public NumericTextField(double minValue, double maxValue, NumericType type) {
        this(minValue, maxValue, type.getValidator());
        this.type.setValue(type);
    }

    /**
     * Creates an NumericTextField with the restriction of min and max value and an specific
     * {@link INumberValidator} validator
     *
     * @param minValue  - the minimal Value that an input can be set
     * @param maxValue  - the maximal Value that an input can be set
     * @param validator - an specified validator that should be used to validate input text
     */
    public NumericTextField(double minValue, double maxValue, INumberValidator validator) {
        super();
        type.addListener((observable, oldValue, newValue) -> currValidator = newValue.getValidator());

        textProperty().addListener((observable, oldValue, newValue) -> {
            if (!isValid(createCheckString(newValue))) {
                setText(oldValue);
            } else {
                number.setValue(getNumber(createCheckString(newValue)));
            }
        });

        this.minValue.set(minValue);
        this.maxValue.set(maxValue);
        this.currValidator = validator;
    }

    /**
     * Creates an NumericTextField with the default Type {@code Integer} and the
     * restriction of the maximal and minimal size of an integer
     */
    public NumericTextField() {
        this(Integer.MAX_VALUE, Integer.MIN_VALUE, NumericType.INTEGER);
    }

    private boolean isValid(String s) {
        if (currValidator == null) throw new IllegalStateException("No Type is defined");
        return currValidator.isValid(s, maxValue.get(), minValue.get());
    }

    private Number getNumber(String s) {
        if (currValidator == null) throw new IllegalStateException("No Type is defined");
        return currValidator.getNumber(s);
    }

    private String createCheckString(String s) {
        if (s == null || s.isEmpty()) return "0";
        if (s.length() == 1 && s.startsWith("-")) return "0";
        return s;
    }

    // region Getter/Setter
    public void setCurrValidator(INumberValidator currValidator) {
        this.currValidator = currValidator;
    }

    public double getMaxValue() {
        return maxValue.get();
    }

    public void setMaxValue(double maxValue) {
        this.maxValue.set(maxValue);
    }

    public DoubleProperty maxValueProperty() {
        return maxValue;
    }

    public double getMinValue() {
        return minValue.get();
    }

    public void setMinValue(double minValue) {
        this.minValue.set(minValue);
    }

    public DoubleProperty minValueProperty() {
        return minValue;
    }

    public Number getNumber() {
        return number.get();
    }

    public ReadOnlyObjectProperty<Number> numberProperty() {
        return number;
    }

    public NumericType getType() {
        return type.get();
    }

    public void setType(NumericType type) {
        this.type.set(type);
    }

    public ObjectProperty<NumericType> typeProperty() {
        return type;
    }
    // endregion

    /**
     * Types that be used for Validation
     */
    public enum NumericType {
        INTEGER(IntegerValidator::new),
        DOUBLE(DoubleValidator::new),
        FLOAT(FloatValidator::new),
        BYTE(ByteValidator::new),
        LONG(LongValidator::new),
        SHORT(ShortValidator::new);

        private final Supplier<INumberValidator> validatorSupplier;

        NumericType(Supplier<INumberValidator> validatorSupplier) {
            this.validatorSupplier = validatorSupplier;
        }

        INumberValidator getValidator() {
            return validatorSupplier.get();
        }
    }
}
