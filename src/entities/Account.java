package entities;

/**
 * An Account represents anyone with a username and password
 */
public class Account {

    /**
     * The username of the Account
     */
    private String userName;
    /**
     * The account password
     */
    private String password;

    /**
     * Create an Account with a username and password
     *
     * @param userName the username of the new Account
     * @param password the password of the new Account
     */
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Get the username of the account
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the username of the account
     *
     * @param userName the new username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the account password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the account password
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
