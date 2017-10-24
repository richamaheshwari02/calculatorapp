package au.com.anz.calculator.operation;

/**
 * Created by mr Varun on 24/10/2017.
 */
public class Addition extends CalculatorOperation{

    public double calculate() {
        return getOperand1() + getOperand2();
    }
}
