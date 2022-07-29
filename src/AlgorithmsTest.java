import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Algorithms.java
 */
public class AlgorithmsTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  private Algorithms testAlg;

  /**
   * Setup the input and output streams for the tests.
   * 
   * @throws Exception Some exception which was thrown during setup.
   */
  @Before
  public void setUp() throws Exception {
    testAlg = new Algorithms();
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  /**
   * Clean up phase for restoring the streams "hijacked" during the setup.
   */
  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  /**
   * Test the user inputs with different lengths.
   * 
   * @throws Exception An exception thrown during testing the power function.
   */
  @Test
  public void testPowerBadLength() throws Exception {
    final String[] testInput1 = { ":pow", "2" }; // short command
    final String[] testInput2 = { ":pow" }; // short command
    final String[] testInput3 = { ":pow", "3", "4", "5" }; // long command
    final String[] testInput4 = { ":pow", "2", "3" }; // correct command length

    testAlg.power(testInput1);
    assertEquals(errContent.toString().trim(), ErrorStrings.BAD_ARGUMENT_COUNT_POWER);
    errContent.reset();

    testAlg.power(testInput2);
    assertEquals(errContent.toString().trim(), ErrorStrings.BAD_ARGUMENT_COUNT_POWER);
    errContent.reset();

    testAlg.power(testInput3);
    assertEquals(errContent.toString().trim(), ErrorStrings.BAD_ARGUMENT_COUNT_POWER);
    errContent.reset();

    testAlg.power(testInput4);
    assertEquals(outContent.toString().trim(), "8.0");
    outContent.reset();
  }

  /**
   * Test the user inputs with bad first argument or base.
   * 
   * @throws Exception An exception thrown during testing the power function.
   */
  @Test
  public void testPowerFirstArgBad() throws Exception {
    final String[] testInput1 = { ":pow", "2", "3" }; // correct command
    final String[] testInput2 = { ":pow", "a", "3" }; // bad first argument
    final String[] testInput3 = { ":pow", "a long string", "5" }; // bad first argument
    final String[] testInput4 = { ":pow", "f", "4" }; // bad first argument

    testAlg.power(testInput1);
    assertEquals(outContent.toString().trim(), "8.0");
    outContent.reset();

    testAlg.power(testInput2);
    assertEquals(errContent.toString().trim(), ErrorStrings.FIRST_ARGUMENT_NOT_NUM_POWER);
    errContent.reset();

    testAlg.power(testInput3);
    assertEquals(errContent.toString().trim(), ErrorStrings.FIRST_ARGUMENT_NOT_NUM_POWER);
    errContent.reset();

    testAlg.power(testInput4);
    assertEquals(errContent.toString().trim(), ErrorStrings.FIRST_ARGUMENT_NOT_NUM_POWER);
    errContent.reset();
  }

  /**
   * Test the user inputs with bad second argument or power.
   * 
   * @throws Exception An exception thrown during testing the power function.
   */
  @Test
  public void testPowerSecondArgBad() throws Exception {
    final String[] testInput1 = { ":pow", "2", "3" }; // correct command
    final String[] testInput2 = { ":pow", "4", "a" }; // bad second argument
    final String[] testInput3 = { ":pow", "6", "p" }; // bad second argument
    final String[] testInput4 = { ":pow", "40", "wt" }; // bad second argument

    testAlg.power(testInput1);
    assertEquals(outContent.toString().trim(), "8.0");
    outContent.reset();

    testAlg.power(testInput2);
    assertEquals(errContent.toString().trim(), ErrorStrings.SECOND_ARGUMENT_NOT_NUM_POWER);
    errContent.reset();

    testAlg.power(testInput3);
    assertEquals(errContent.toString().trim(), ErrorStrings.SECOND_ARGUMENT_NOT_NUM_POWER);
    errContent.reset();

    testAlg.power(testInput4);
    assertEquals(errContent.toString().trim(), ErrorStrings.SECOND_ARGUMENT_NOT_NUM_POWER);
    errContent.reset();
  }

  /**
   * Test the user inputs where power is not integer.
   * 
   * @throws Exception An exception thrown during testing the power function.
   */
  @Test
  public void testPowerSecondArgNotInt() throws Exception {
    final String[] testInput1 = { ":pow", "2", "3" }; // correct command
    final String[] testInput2 = { ":pow", "4", "3.1" }; // bad second argument

    testAlg.power(testInput1);
    assertEquals(outContent.toString().trim(), "8.0");
    outContent.reset();

    testAlg.power(testInput2);
    assertEquals(errContent.toString().trim(), ErrorStrings.SECOND_ARGUMENT_NOT_NUM_POWER);
    errContent.reset();
  }

  /**
   * Test the user inputs where base is 0 and power is negative.
   * 
   * @throws Exception An exception thrown during testing the power function.
   */
  @Test
  public void testPowerZeroBaseNegPow() throws Exception {
    final String[] testInput1 = { ":pow", "2", "3" }; // correct command
    final String[] testInput2 = { ":pow", "0", "2" }; // correct argument
    final String[] testInput3 = { ":pow", "0", "-1" }; // bad second argument
    final String[] testInput4 = { ":pow", "0", "-2" }; // bad second argument

    testAlg.power(testInput1);
    assertEquals(outContent.toString().trim(), "8.0");
    outContent.reset();

    testAlg.power(testInput2);
    assertEquals(outContent.toString().trim(), "0.0");
    outContent.reset();

    testAlg.power(testInput3);
    assertEquals(errContent.toString().trim(), ErrorStrings.ZERO_BASE_NEGATIVE_POWER);
    errContent.reset();

    testAlg.power(testInput4);
    assertEquals(errContent.toString().trim(), ErrorStrings.ZERO_BASE_NEGATIVE_POWER);
    errContent.reset();
  }

  /**
   * Test the user inputs where power is negative.
   * 
   * @throws Exception An exception thrown during testing the power function.
   */
  @Test
  public void testPowerNegPower() throws Exception {
    final String[] testInput1 = { ":pow", "2", "-1" };
    final String[] testInput2 = { ":pow", "0", "-1" };
    final String[] testInput3 = { ":pow", "5", "-1" };

    testAlg.power(testInput1);
    assertEquals(outContent.toString().trim(), "0.5");
    outContent.reset();

    testAlg.power(testInput2);
    assertEquals(errContent.toString().trim(), ErrorStrings.ZERO_BASE_NEGATIVE_POWER);
    errContent.reset();

    testAlg.power(testInput3);
    assertEquals(outContent.toString().trim(), "0.2");
    outContent.reset();
  }

  /**
   * Test the user inputs where power is positive.
   * 
   * @throws Exception An exception thrown during testing the power function.
   */
  @Test
  public void testPowerPositivePower() throws Exception {
    final String[] testInput1 = { ":pow", "2", "2" };
    final String[] testInput2 = { ":pow", "0", "1" };
    final String[] testInput3 = { ":pow", "5", "3" };

    testAlg.power(testInput1);
    assertEquals(outContent.toString().trim(), "4.0");
    outContent.reset();

    testAlg.power(testInput2);
    assertEquals(outContent.toString().trim(), "0.0");
    outContent.reset();

    testAlg.power(testInput3);
    assertEquals(outContent.toString().trim(), "125.0");
    outContent.reset();
  }
}
