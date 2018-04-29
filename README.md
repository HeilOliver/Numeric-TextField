# Numeric-TextField
## What is it?

The text field is a common JavaFx text field which only allows numbers. 
It also has a object property for the datatype `Number`. 
This property reflects the input. This means that if, for example, ten is typed, the `Number` property is 
changed to 10 immediately afterwards. If the entry is incorrect, the text field is automatically reset to its last state. 

## How can I use it?

There are two different ways to use it.
``` FXML 
<GridPane fx:controller="sample.Controller"
          xmlns:fx="http://javafx.com/fxml" alignment="center">
          
    <!-- This NumericTextField converts the input
         into an integer and limits the values from -10 to 10. -->
    <NumericTextField type="INTEGER" maxValue="10" minValue="-10"/>
    
</GridPane>
```
``` Code Behind 
void foo() {

// This NumericTextField converts the input
// into an integer and limits the values from -10 to 10.
  NumericTextField textField = 
    new NumericTextField(-10,10,NumericTextField.NumericType.INTEGER);

}
```

## You want to validate yourself?
First we need our own validator. Therefore we implement the `INumberValidator` interface.
```
new INumberValidator() {
    @Override
    public boolean isValid(String s, double maxValue, double minValue) {
       // some Magic here to validate the given string "s"
        return true;
    }

    @Override
    public Number getNumber(String s) throws NumberFormatException {
       // here also some magic to parse the string s to an number
       return null;
    }
}
```

There are two different ways to use your own validator.
``` 
NumericTextField textField;

void foo_UseTheConstructor() {
   textField = new NumericTextField(-10,10,yourMagicValidator);
}

void foo_UseTheSetMethod() {
   textField.setCurrValidator(yourMagicValidator);
}
```

## Bring me to the fancy stuff!!
Sorry, at the moment there is nothing fancy or special in there :(
But you get a little example:
``` 
- FXML -
<?import at.ohe.numerictextfield.NumericTextField?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.VBox?>
<VBox fx:controller="sample.Controller"
      xmlns:fx="http://javafx.com/fxml" alignment="center" >
    <NumericTextField fx:id="inpNumber" type="DOUBLE" maxValue="10" minValue="-10"/>
    <Label fx:id="lblNumber"/>
</VBox>

- Controller - 
import at.ohe.numerictextfield.NumericTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private NumericTextField inpNumber;
    @FXML
    private Label lblNumber;

    public void initialize() {
        inpNumber.numberProperty().addListener(((observable, oldValue, newValue) -> {
            lblNumber.setText(newValue.toString());
        }));
    }
}
``` 
What's going to happen? 
If something is entered in the input field, 
the label displays the corresponding value. 
If something is entered that cannot be processed, 
the label retains its value.



