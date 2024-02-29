package entities;

/**
 * A member of Staff of a Library
 */
public class Staff {

    /**
     * The first name of the staff user
     */
    private String firstName;
    /**
     * The last name of the staff user
     */
    private String lastName;
    /**
     * The staff user's email address
     */
    private String email;
    /**
     * The staff user's phone number
     */
    private String phone;
    /**
     * The staff user's password for their account
     */
    private String password;


    /**
     * Create a staff user
     *
     * @param firstName the staff user's first name
     * @param lastName  the staff user's surname
     * @param email     the staff user's email address
     * @param phone     the staff user's phone number
     * @param password  the password for the staff user's account
     */
    public Staff(String firstName, String lastName, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }


    /**
     * Get the staff user's first name
     *
     * @return the staff user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the staff user's first name
     *
     * @param firstName the staff user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the staff user's last name
     *
     * @return the staff user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the staff user's last name
     *
     * @param lastName the staff user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the staff user's email address
     *
     * @return the staff user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the staff user's email address
     *
     * @param email the staff user's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the staff user's phone number
     *
     * @return the staff user's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the staff user's phone number
     *
     * @param phone the staff user's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the staff user's password
     *
     * @return the staff user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the staff user's password
     *
     * @param password the staff user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
