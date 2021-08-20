import java.util.Scanner;

/**
 * The program implements a scientific calculator that can perform addition, subtraction, multiplication, division,
 * exponentiation, and a logarithmic operation. It can also display the average of all the calculations performed
 * so far.
 *
 * Citations:
 * Calculator.java, author: kptil
 * Oracle Java Documentation for Class Double, https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/Double.html
 * "How to print a float with 2 decimal places in Java," https://stackoverflow.com/questions/2538787/how-to-print-a-float-with-2-decimal-places-in-java
 *
 * @author kptil
 * @version 1.0
 */

public class SciCalculator {
    /**
     * Method prints a menu with six calculator operations, an option to exit the program, and an option to display
     * the average of all calculations performed so far.
     */
    public static void printMenu() {
        String menuTitle = "Calculator Menu";
        System.out.println(menuTitle);
        for (int i = 0; i < menuTitle.length(); i++) {
            if (i == (menuTitle.length() - 1)) {
                System.out.println("-");
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println("0. Exit Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Display Average");

        System.out.println();
    }

    /**
     * Gets the first operand from the user as a string. If the input is RESULT, assigns the value of answer to the
     * firstOperand variable. If the input is not RESULT, the value of the input is stored instead as a double. Assumes
     * input will either be RESULT or a number. The answer variable holds the result from the previous calculation, or
     * zero if no calculation has been performed.
     *
     * @param scnr A scanner object created in main to get input from the user.
     * @param answer double, the result of the previous calculation
     * @return returns a double with the value of the first operand
     */
    public static double getFirstOperand(Scanner scnr, double answer) {
        double firstOperand;

        System.out.print("Enter first operand: ");
        String firstInput = scnr.next();

        if (firstInput.equals("RESULT")) {
            firstOperand = answer;
        }
        else {

            firstOperand = Double.valueOf(firstInput);
        }

        return firstOperand;
    }

    /**
     * Gets the second operand from the user as a string. If the input is RESULT, assigns the value of answer to the
     * firstOperand variable. If the input is not RESULT, the value of the input is stored instead as a double.
     * The answer variable holds the result from the previous calculation, or zero if no calculation has been performed.
     *
     * @param scnr A scanner object created in main to get input from the user.
     * @param answer double, the result of the previous calculation
     * @return returns a double with the value of the second operand
     */
    public static double getSecondOperand(Scanner scnr, double answer) {
        double secondOperand;

        System.out.print("Enter second operand: ");
        String secondInput = scnr.next();

        if (secondInput.equals("RESULT")) {
            secondOperand = answer;
        }
        else {
            secondOperand = Double.valueOf(secondInput);
        }

        return secondOperand;
    }

    public static void main(String[] args) {
        double firstOperand;
        double secondOperand;

        int userMenuChoice;
        double answer = 0.0;

        double sumAnswers = 0.0;
        int numCalculations = 0;

        Scanner scnr = new Scanner(System.in);

        //Prints the current result once, which starts out as zero, and then prints the menu.
        System.out.println("Current Result: " + answer);
        System.out.println();

        printMenu();

        //Gets input from user to determine appropriate calculator function.
        System.out.print("Enter Menu Selection: ");
        userMenuChoice = scnr.nextInt();
        System.out.println();

        while (userMenuChoice != 0) {

            /*
            If statement performs operations based on the user's menu choice, provided the user input is not zero.
            Options 1 through 6 call the getFirstOperand and getSecondOperand methods, perform a calculation, and save
            the result in the answer variable. The value of the result is added to sumAnswers and numCalculations is
            incremented. Options 1 through 4 perform basic addition, subtraction, multiplication, and division.
            */

            if (userMenuChoice == 1) {
                firstOperand = getFirstOperand(scnr, answer);
                secondOperand = getSecondOperand(scnr, answer);

                answer = firstOperand + secondOperand;
                sumAnswers = sumAnswers + answer;
                numCalculations++;
            }
            else if (userMenuChoice == 2) {
                firstOperand = getFirstOperand(scnr, answer);
                secondOperand = getSecondOperand(scnr, answer);

                answer = firstOperand - secondOperand;
                sumAnswers = sumAnswers + answer;
                numCalculations++;
            }
            else if (userMenuChoice == 3) {
                firstOperand = getFirstOperand(scnr, answer);
                secondOperand = getSecondOperand(scnr, answer);

                answer = firstOperand * secondOperand;
                sumAnswers = sumAnswers + answer;
                numCalculations++;
            }
            else if (userMenuChoice == 4) {
                firstOperand = getFirstOperand(scnr, answer);
                secondOperand = getSecondOperand(scnr, answer);

                answer = firstOperand / secondOperand;
                sumAnswers = sumAnswers + answer;
                numCalculations++;
            }
            /*
            Option 5 performs exponentiation. The first operand is used as the base and the second operand is used as
            the exponent power.
             */
            else if (userMenuChoice == 5) {
                firstOperand = getFirstOperand(scnr, answer);
                secondOperand = getSecondOperand(scnr, answer);

                answer = Math.pow(firstOperand, secondOperand);
                sumAnswers = sumAnswers + answer;
                numCalculations++;
            }
            /*
            Option 6 takes the logarithm of the second operand, using the first operand as the base. The change of base
            formula is used.
             */
            else if (userMenuChoice == 6) {
                firstOperand = getFirstOperand(scnr, answer);
                secondOperand = getSecondOperand(scnr, answer);

                answer = Math.log(secondOperand) / Math.log(firstOperand);
                sumAnswers = sumAnswers + answer;
                numCalculations++;
            }
            /*
            Option 7 prints a menu of statistics. No calculation is performed, so the answer, sumAnswers, and
            numCalculations variables are not changed. If no calculations have been performed, an error message is
            printed. Otherwise, the sum of the calculations, the number of calculations, and the average of the
            calculations are printed.
             */
            else if (userMenuChoice == 7) {

                if (numCalculations == 0) {
                    System.out.println("Error: No calculations yet to average!");
                }
                else {
                    System.out.print("Sum of calculations: ");
                    System.out.printf("%.2f", sumAnswers);
                    System.out.println();
                    System.out.println("Number of calculations: " + numCalculations);
                    double average = sumAnswers / numCalculations;
                    System.out.print("Average of calculations: ");
                    System.out.printf("%.2f", average);
                    System.out.println();
                }
            }
            //Prints an error message if menu choice is outside the range 0 to 7, inclusive.
            else {
                System.out.println("Error: Invalid selection!");
            }

            /*
            Reprints the current result and the menu, but only if an actual calculation is performed (if user menu
            choice is not 0, 7, or invalid).
             */
            if ((userMenuChoice > 0) && (userMenuChoice < 7)) {
                System.out.println();
                System.out.println("Current Result: " + answer);
                System.out.println();
                printMenu();
            }

            //Prompts for a new menu choice at the end of each loop iteration, no matter previous menu choice.
            System.out.print("Enter Menu Selection: ");
            userMenuChoice = scnr.nextInt();
            System.out.println();

        }

        //Prints a goodbye message when user enters zero and the loop exits.
        System.out.println("Thanks for using this calculator. Goodbye!");

    }
}
