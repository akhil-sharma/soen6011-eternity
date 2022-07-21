/**
 * Algorithms
 * 
 * This class processes the user input for power command.
 */
public class Algorithms {
    /**
     * Default constructor.
     * empty.
     */
    Algorithms() {
    }

    /*
     * Validates the command entered by the user.
     * then computes the power.
     */
    public void power(String[] command) {
        // Check that :pow gets 2 arguments
        if (command.length != 3) {
            System.err.println(":pow command requires 2 parameters, base and power. USAGE> :pow x y");
            return;
        }

        double x;
        double y_temp;
        int y;

        // check that the first argument is a real number
        try {
            x = Double.parseDouble(command[1]);
        } catch (NumberFormatException nfe) {
            System.err.println("The first argument of :pow must be a number.");
            return;
        }

        // check that the second argument is an integer.
        try {
            y_temp = Double.parseDouble(command[2]);

            if (Math.ceil(y_temp) != Math.floor(y_temp)) {
                System.out.println("The second argument was cast to integer.");
            }

            y = (int) y_temp;

        } catch (NumberFormatException nfe) {
            System.err.println("The second argument of :pow must be a number.");
            return;
        }

        // adjust for negative power.
        if (y < 0) {
            if (x == 0) {
                System.out.println("base cannot be 0 when power is negative.");
                return;
            }
            System.out.println(1 / powerDivideAndConquer(x, -y));
        } else {
            System.out.println(powerDivideAndConquer(x, y));
        }
    }

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
