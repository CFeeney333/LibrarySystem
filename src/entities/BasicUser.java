package entities;

abstract class BasicUser {

    /**
     * The user's display and login name
     */
    private String userName;
    /**
     * The user's password
     */
    private String password;

    /**
     * Create a Basic User of a library system
     * <p>
     * A Basic User is someone with a username and password
     * </p>
     *
     * @param userName  the user's display and login name
     * @param password  the user's password
     */
    public BasicUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Get the user's display and login name
     *
     * @return the user's display and login name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the user's display and login name
     *
     * @param userName the user's display and login name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the user's password
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password
     *
     * @param password the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
