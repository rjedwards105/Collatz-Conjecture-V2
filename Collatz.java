import java.util.Scanner;

public class Collatz {
    private Scanner keyboard;

    public Collatz() {
        keyboard = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Collatz collatz = new Collatz();
        collatz.start();
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    System.out.print("Enter a number to calculate Collatz Conjecture: ");
                    int num = Integer.parseInt(keyboard.nextLine());
                    calculate(num);
                    break;
                case 2:
                    exit();
                    exit = true;
                    break;
                default:
                    System.out.println("Input invalid. Try again.\n");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Collatz Conjecture (3n + 1) Solver");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        int choice;
        try {
            choice = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            choice = -1;
        }
        return choice;
    }

    public void calculate(int num) {
        int counter = 0;
        while (num != 1) {
            if (num % 2 == 1) {
                num = num * 3 + 1;
                counter++;
            } else {
                num = num / 2;
                counter++;
            }
            System.out.println("Iteration #" + counter + ": " + num);
        }
        System.out.println("Total number of iterations: " + counter + "\n");
    }

    public void exit() {
        System.out.println("Exiting the application...");
    }
}
