package au.com.anz.calculator.au.com.anz.calculator.factory;

import au.com.anz.calculator.exception.InvalidInputException;
import au.com.anz.calculator.operation.*;

/**
 * This file creates the CalculatorOperation object depending on the operation input by the user
 */
public class CalculatorOperationFactory {

    public static CalculatorOperation getCalculatorOperation(String[] input) throws InvalidInputException, ArrayIndexOutOfBoundsException {

        CalculatorOperation calculatorOperation = null;
        try {
            String operand1 = input[0];
            String operand2 = input[2];
            String operation = input[1];

            validateInput(operand1, operand2, operation);

            char operator = operation.trim().charAt(0);

            switch (operator) {
                case '+':
                    calculatorOperation = new Addition();
                    break;
                case '-':
                    calculatorOperation = new Subtraction();
                    break;
                case '*':
                    calculatorOperation = new Multiplication();
                    break;
                case '/':
                    calculatorOperation = new Division();
                    break;
                default:
                    throw new InvalidInputException("Invalid operation. Please enter +, -, *, /");
            }
            calculatorOperation.setOperand1(Double.parseDouble(operand1.trim()));
            calculatorOperation.setOperand2(Double.parseDouble(operand2.trim()));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw  new InvalidInputException("Please enter 3 inputs - Operand Operation Operand");
        }
        return calculatorOperation;
    }

    private static void validateInput(String operand1, String operand2, String operation) throws InvalidInputException{

       validateOperand(operand1);
       validateOperand(operand2);
       validateOperation(operation);
    }

    private static void validateOperand(String operand) throws InvalidInputException {
        try {
            Double.parseDouble(operand.trim());
        } catch (NullPointerException e) {
            throw new InvalidInputException("Input operand is null");
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter valid operands");
        }
    }

   private static void validateOperation(String operation) throws InvalidInputException {
        if(operation.trim().length() != 1) {
            throw new InvalidInputException("Invalid Operation");
        }
   }
}
