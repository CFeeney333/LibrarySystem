/**
 * A member of Staff of a Library
 */
public class Staff {

    /**
     * The first name of the staff member
     */
    private String firstName;
    /**
     * The last name of the staff member
     */
    private String lastName;
    /**
     * The staff member's email address
     */
    private String email;
    /**
     * The staff member's phone number
     */
    private String phone;
    /**
     * The staff member's password for their account
     */
    private String password;


    /**
     * Create a Staff member
     * @param firstName the staff member's first name
     * @param lastName the staff member's surname
     * @param email the staff member's email address
     * @param phone the staff member's phone number
     * @param password the password for the staff member's account
     */
    public Staff(String firstName, String lastName, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }


    /**
     * Get the staff member's first name
     * @return the staff member's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the staff member's first name
     * @param firstName the staff member's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the staff member's last name
     * @return the staff member's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the staff member's last name
     * @param lastName the staff member's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the staff member's email address
     * @return the staff member's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the staff member's email address
     * @param email the staff member's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the staff member's phone number
     * @return the staff member's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the staff member's phone number
     * @param phone the staff member's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the staff member's password
     * @return the staff member's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the staff member's password
     * @param password the staff member's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
