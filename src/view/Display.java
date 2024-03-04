package view;

public interface Display {

    /**
     * Show a screen with the options yes and no
     * @param title the title of the screen
     * @param content the content displayed below the title
     * @return integer indicating the user option, 0:yes, 1:no
     */
    public int showConfirm(String title, String content);

    /**
     * Show a screen for user to enter input
     * @param title the title of the screen
     * @param content the content displayed below the title including the prompt
     * @param invalid show error message if this is true
     * @return the String input by the user
     */
    public String showInput(String title, String content, boolean invalid);

    /**
     * Show a message to the user
     * @param title the title of the screen
     * @param content the content displayed below the title
     */
    public void showMessage(String title, String content);

    /**
     * Show a screen of options to the user
     * @param title the title of the screen
     * @param content the content of the screen
     * @param options the array of options
     * @return and integer representing the index of the option chosen
     */
    public int showOptions(String title, String content, String[] options);
}