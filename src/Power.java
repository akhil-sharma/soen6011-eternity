class Power {

    private double power(int base, int power) {
        int solution = 1;
        for (int i = 0; i < power; i++) {
            solution *= base;
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(new Power().power(2, 3));
    }
}