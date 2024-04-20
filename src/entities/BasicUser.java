package entities;

public abstract class BasicUser {

    /**
     * The account associated with the user
     */
    private final Account account;

    /**
     * Create a Basic User of a library system
     * <p>
     * A Basic User is someone with a username and password
     * </p>
     *
     * @param userName the user's display and login name
     * @param password the user's password
     */
    public BasicUser(String userName, String password) {
        account = new Account(userName, password);
    }

    /**
     * Get the user's display and login name
     *
     * @return the user's display and login name
     */
    public String getUserName() {
        return account.getUserName();
    }

    /**
     * Set the user's display and login name
     *
     * @param userName the user's display and login name
     */
    public void setUserName(String userName) {
        account.setUserName(userName);
    }

    /**
     * Get the user's password
     *
     * @return the user's password
     */
    public String getPassword() {
        return account.getPassword();
    }

    /**
     * Set the user's password
     *
     * @param password the user's password
     */
    public void setPassword(String password) {
        account.setPassword(password);
    }

}
