package entities;

/**
 * A member of Staff of a Library
 */
public class Staff {

    /**
     * The staff user's id
     */
    private long id;
    /**
     * The first name of the staff user
     */
    private String firstName;
    /**
     * The last name of the staff user
     */
    private String lastName;
    /**
     * The staff user's password for their account
     */
    private String password;
    /**
     * The staff user's phone number
     */
    private String phone;
    /**
     * The staff user's email address
     */
    private String email;


    /**
     * Create a Staff user
     *
     * @param id        the staff user's id
     * @param firstName the staff user's first name
     * @param lastName  the staff user's surname
     * @param password  the password for the staff user's account
     * @param phone     the staff user's phone number
     * @param email     the staff user's email address
     */
    public Staff(long id, String firstName, String lastName, String password, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }


    /**
     * Get the staff user's id
     *
     * @return the staff user's id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the staff user's id
     *
     * @param id the staff user's id
     */
    public void setId(long id) {
        this.id = id;
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
