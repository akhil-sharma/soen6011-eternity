import java.util.Scanner;

/**
 * Eternity
 * 
 * This is the driver class for this software project.
 * It is responsible for presenting a command line interface
 * to the users and performing the necessary actions based on
 * the input.
 */
class Eternity {
    Scanner scanner;

    /**
     * Public constructor for the Eternity class.
     */
    Eternity() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Eternity instance = new Eternity();
        instance.run();
    }

    /**
     * Starts the user interface as a read-eval-print-loop.
     */
    private void run() {
        System.out.println("Welcome to Eternity");
        String[] action = displayMenu();
        // repl
        while (true) {
            evaluate(action);
            action = displayMenu();
        }
    }

    /**
     * Evaluates the entered command.
     * 
     * @param command
     */
    private void evaluate(String[] command) {
        if (command[0].equals(":quit")) {
            this.close();
        }

        if (command[0].equals(":pow")) {
            evaluatePower(command);
        } else {
            System.err.println("Unknown command. No action was performed.");
        }
    }

    private void evaluatePower(String[] command) {
    }

    private void close() {
        scanner.close();
        System.out.println("Shutting down eternity.");
        System.exit(1);
    }

    private String[] displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Power function -> :pow <base> <power>");
        System.out.println("2. quit -> :quit");

        String[] entry = this.scanner.nextLine().strip().split(" ");

        if (!entry[0].equals(":quit") && !entry[0].equals(":pow")) {
            System.out.print("We have encountered an invalid command.\nTry again:");
            entry = this.scanner.nextLine().strip().split(" ");
        }

        return entry;
    }
}