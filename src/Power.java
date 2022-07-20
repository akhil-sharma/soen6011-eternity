class Power {

    private double powerRepeatedMultiply(double base, double power) {
        double solution = 1;
        for (int i = 0; i < power; i++) {
            solution *= base;
        }

        return solution;
    }

    private double checkedPower(double base, int power) {
        if (power == 0) {
            return 1;
        }

        if (power == 1) {
            return base;
        }

        if (power < 0) {
            return 1 / powerRepeatedMultiply(base, -power);
        }

        return powerRepeatedMultiply(base, power);

    }

    public static void main(String[] args) {
        System.out.println(new Power().checkedPower(2, 3));
        System.out.println(new Power().checkedPower(2, -1));
        System.out.println(new Power().checkedPower(2, 0));
        System.out.println(new Power().checkedPower(0, 0));
        System.out.println(new Power().checkedPower(2, -2));
    }
}