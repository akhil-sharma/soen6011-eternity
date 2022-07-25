/**
 * This class processes the user input for power command.
 */
public class Algorithms {
    /**
     * Default constructor.
     */
    Algorithms() {
    }

    /*
     * Expects the command in the for of String[].
     * 
     * A valid command looks like [":pow", "x", "y"]
     * where x is a double and y is an integer.
     * 
     * <bold> y will be casted to integer if it is a double.</bold>
     * 
     * This method
     * <ol>
     * <li> Validates the arguments provided by the user.</li>
     * <li> Converts the arguments to appropriate types.</li>
     * </ol>
     */
    public void power(String[] command) {
        // Check that :pow gets 2 arguments
        if (command.length != 3) {
            System.err.println(ErrorStrings.BAD_ARGUMENT_COUNT_POWER);
            return;
        }

        double x;
        double y_temp;
        int y;

        // check that the first argument is a real number
        try {
            x = Double.parseDouble(command[1]);
        } catch (NumberFormatException nfe) {
            System.err.println(ErrorStrings.FIRST_ARGUMENT_NOT_NUM_POWER);
            return;
        }

        // check that the second argument is an integer.
        try {
            y_temp = Double.parseDouble(command[2]);

            if (Math.ceil(y_temp) != Math.floor(y_temp)) {
                System.out.println(ErrorStrings.SECOND_ARGUMENT_NOT_NUM_POWER);
                return;
            }

            y = (int) y_temp;

        } catch (NumberFormatException nfe) {
            System.err.println(ErrorStrings.SECOND_ARGUMENT_NOT_NUM_POWER);
            return;
        }

        // adjust for negative power.
        if (y < 0) {
            if (x == 0) {
                System.out.println(ErrorStrings.ZERO_BASE_NEGATIVE_POWER);
                return;
            }
            System.out.println(1 / powerDivideAndConquer(x, -y));
        } else {
            System.out.println(powerDivideAndConquer(x, y));
        }
    }

    /**
     * Recursively computes the power function using the divide and
     * conquer approach.
     * 
     * @param base  Double value of base c in x^y
     * @param power Integer value of power in x^y
     * @return Double value of power function.
     */
    private Double powerDivideAndConquer(double base, int power) {
        if (power == 0) {
            return 1.0;
        }

        double pow = powerDivideAndConquer(base, power / 2);

        if ((power & 1) == 1) { // if `y` is odd
            return base * pow * pow;
        }

        return pow * pow;
    }

    public static void main(String[] args) {
        Algorithms alg = new Algorithms();
        alg.power(new String[] { ":pow", "1", "2" });
        alg.power(new String[] { ":pow", "0", "2" });
        alg.power(new String[] { ":pow", "2", "2" });
        alg.power(new String[] { ":pow", "2", "0" });
        alg.power(new String[] { ":pow", "2", "-1" });
        alg.power(new String[] { ":pow", "0", "-1" });
        alg.power(new String[] { ":pow", "11", "15" });
        alg.power(new String[] { ":pow", "0", "0" });
    }

}
