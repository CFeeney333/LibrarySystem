package view;
import utilities.Console;

public class CLDisplay implements Display {

    /**
     * Show a screen with the options yes and no
     *
     * @param title   the title of the screen
     * @param content the content displayed below the title
     * @return integer indicating the user option, 0:yes, 1:no
     */
    @Override
    public int showConfirm(String title, String content) {
        boolean invalid = false;
        do {
            Console.clear();
            Console.printLine(title);
            if (invalid) {
                Console.printLine("Invalid option! Please select 1 or 2");
            }
            Console.printLine();
            Console.printLine(content);
            Console.printLine();
            Console.printLine("1) Yes");
            Console.printLine("2) No");
            Console.print(">>> ");

            try {
                int input = Console.getInt();
                if (input == 1) {
                    return 0;
                } else if (input == 2) {
                    return 1;
                } else {
                    invalid = true;
                }
            } catch (NumberFormatException e) {
                invalid = true;
            }
        } while (true);
    }

    /**
     * Show a screen for user to enter input
     *
     * @param title   the title of the screen
     * @param content the content displayed below the title including the prompt
     * @return the String input by the user
     */
    @Override
    public String showInput(String title, String content, boolean invalid) {
        Console.clear();
        Console.printLine(title);
        if (invalid) {
            Console.printLine("Invalid input! Enter a valid value");
        }
        Console.print(content);
        Console.printLine();
        Console.print(">>> ");
        return Console.nextLine();
    }

    /**
     * Show a message to the user
     *
     * @param title   the title of the screen
     * @param content the content displayed below the title
     */
    @Override
    public void showMessage(String title, String content) {
        Console.clear();
        Console.printLine(title);
        Console.printLine();
        Console.printLine(content);
        pressEnter();
    }

    /**
     * Prompt the user to press Enter, and wait for them to click it
     */
    private void pressEnter() {
        Console.print("Press the ENTER key to continue... ");
        Console.nextLine();
    }

    /**
     * Show a screen of options to the user
     *
     * @param title   the title of the screen
     * @param content the content of the screen
     * @param options the array of options
     * @return and integer representing the index of the option chosen beginning with 1 to the size of the array inclusive
     */
    @Override
    public int showOptions(String title, String content, String[] options) {
        boolean invalid = false;
        do {
            Console.clear();
            Console.printLine(title);
            if (invalid) {
                Console.printLine("Invalid option! Please select a number from 1 to " + options.length);
            }
            Console.printLine();
            Console.printLine(content);
            Console.printLine();
            for (int i = 0; i < options.length; i++) {
                Console.printLine((i+1) + ") " + (options[i]));
            }
            Console.print(">>> ");

            try {
                int input = Console.getInt();
                if (input >= 1 && input <= options.length) {
                    return input;
                } else {
                    invalid = true;
                }
            } catch (NumberFormatException e) {
                invalid = true;
            }
        } while (true);
    }


}
