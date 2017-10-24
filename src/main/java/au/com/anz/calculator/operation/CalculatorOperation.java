package au.com.anz.calculator.operation;

/**
 * Created by mr Varun on 24/10/2017.
 */
public abstract class CalculatorOperation
{
    private double operand1;

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    private double operand2;

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public abstract double calculate();


}
