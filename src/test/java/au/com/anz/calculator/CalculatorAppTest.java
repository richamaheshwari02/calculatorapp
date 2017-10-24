package au.com.anz.calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Calculator App.
 */
public class CalculatorAppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private String args[];

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testInvalidInput_nullValue(){
        args = new String[]{"10000", "*"};
        CalculatorApp.main(args);
        assertEquals("Please enter 3 inputs - Operand Operation Operand", outContent.toString());
    }

    @Test
    public void testInvalidInput_invalidOperation(){
        args = new String[]{"10000", "abc", "12345"};
        CalculatorApp.main(args);
        assertEquals("Invalid Operation", outContent.toString());
    }

    @Test
    public void testInvalidInput_invalidOperand1(){
        args = new String[]{"abc", "*", "12345"};
        CalculatorApp.main(args);
        assertEquals("Please enter valid operands", outContent.toString());
    }

    @Test
    public void testInvalidInput_invalidOperand2(){
        args = new String[]{"1345", "*", "abc"};
        CalculatorApp.main(args);
        assertEquals("Please enter valid operands", outContent.toString());
    }

    @Test
    public void testInvalidInput_blankOperand(){
        args = new String[]{"", "*", "abc"};
        CalculatorApp.main(args);
        assertEquals("Please enter valid operands", outContent.toString());
    }

    @Test
    public void testInvalidInput_nullOperand(){
        args = new String[]{null, "*", "abc"};
        CalculatorApp.main(args);
        assertEquals("Input operand is null", outContent.toString());
    }

    @Test
    public void testAddition(){
        args = new String[]{"10000.36", "+", "12345.89"};
        CalculatorApp.main(args);
        assertEquals("22346.25", outContent.toString());
    }

    @Test
    public void testSubtraction(){
        args = new String[]{"10000.36", "-", "12345.89"};
        CalculatorApp.main(args);
        assertEquals("-2345.529999999999", outContent.toString());
    }

    @Test
    public void testMultiplication(){
        args = new String[]{"10000.36", "*", "12345.89"};
        CalculatorApp.main(args);
        assertEquals("1.234633445204E8", outContent.toString());
    }

    @Test
    public void testDivision(){
        args = new String[]{"10000.36", "/", "12345.89"};
        CalculatorApp.main(args);
        assertEquals("0.8100153168382354", outContent.toString());
    }


}
