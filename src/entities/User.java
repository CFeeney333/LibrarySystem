package entities;

abstract class User {

    /**
     * The user's id
     */
    private long id;
    /**
     * The user's first name
     */
    private String firstName;
    /**
     * The user's last name
     */
    private String lastName;
    /**
     * The user's display and login name
     */
    private String userName;
    /**
     * The user's password
     */
    private String password;
    /**
     * The user's phone number
     */
    private String phone;
    /**
     * The user's email address
     */
    private String email;

    /**
     * Create a User of a library system
     * <p>
     * A User is someone who has an account on a library system
     * </p>
     *
     * @param id        the user's id
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param userName  the user's display and login name
     * @param password  the user's password
     * @param phone     the user's phone number
     * @param email     the user's email address
     */
    public User(long id, String firstName, String lastName, String userName, String password, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Get the user's id
     *
     * @return the user's id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the user's id
     *
     * @param id the user's id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the user's first name
     *
     * @return the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the user's first name
     *
     * @param firstName the user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the user's last name
     *
     * @return the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the user's last name
     *
     * @param lastName the user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    /**
     * Get the user's phone number
     *
     * @return the user's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the user's phone number
     *
     * @param phone the user's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the user's email address
     *
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email address
     *
     * @param email the user's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
