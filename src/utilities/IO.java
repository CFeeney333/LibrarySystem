package utilities;

import java.util.Scanner;

/**
 * IO handles all input and output from and to the console
 * <p>
 * This differs from EasyScanner in that it uses a single static instance of the Scanner class, rather than creating
 * a new Scanner every time a method is called, which is inefficient. It provides access to its static methods for
 * reading from the console and writing to the console. The Scanner 'error' is mitigated by calling
 * scannerObj.nextLine() after each call to a Scanner method that does not consume the newline character. For example,
 * nextInt() retrieves the next integer from the console but does not consume the newline character which was appended
 * to the input stream when the user pressed enter. This means that the next time nextLine is called, it will read the
 * newline character which is at the beginning of the input stream, and will ignore any characters that the user entered
 * after it, thus returning an empty String.
 * </p>
 */
public class IO {

    /**
     * Scanner for reading input from the console
     */
    private static final Scanner sc = new Scanner(System.in);


    /**
     * Get the next line from the console
     *
     * @param prompt the prompt to display on the console
     * @return the text that the user entered in the console
     */
    public static String getLine(String prompt) {
        print(prompt);
        return sc.nextLine();
    }

    /**
     * Get the next word from the console
     * <p>
     * Any words following are discarded
     * </p>
     *
     * @param prompt the prompt to display on the console
     * @return the first word that the user entered in the console
     */
    public static String getWord(String prompt) {
        print(prompt);
        String word = sc.next();
        sc.nextLine();
        return word;
    }

    /**
     * Get the next integer from the console
     * @param prompt the prompt to display to the console
     * @return the next integer the user entered in the console
     */
    public static int getInt(String prompt) {
        print(prompt);
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    /**
     * Print a message to the console
     * <p>
     *     This does not add a newline. If you want to add a newline, use the IO.printLine method instead
     * </p>
     * @param message the message to print to the console
     */
    public static void print(String message) {
        System.out.print(message);
    }

    /**
     * Print a message to the console then go on to a new line
     * @param message the message to print to the console
     */
    public static void printLine(String message) {
        System.out.println(message);
    }

    /**
     * Clear the console
     */
    public static void clear() {
        // TODO 1/3/24: implement clear method
    }
}
