package entities;

/**
 * A Member user of the library system.
 * <p>
 * A Member refers to someone who has an account with the library for borrowing books.
 * </p>
 */
public class Member {

    /**
     * The member user's id
     */
    private long id;
    /**
     * The first name of the member user
     */
    private String firstName;
    /**
     * The last name of the member user
     */
    private String lastName;
    /**
     * The member user's password for their account
     */
    private String password;
    /**
     * The member user's phone number
     */
    private String phone;
    /**
     * The member user's email address
     */
    private String email;


    /**
     * Create a Member user
     *
     * @param id        the member user's id
     * @param firstName the member user's first name
     * @param lastName  the member user's last name
     * @param password  the password for the member user's account
     * @param phone     the member user's phone number
     * @param email     the member user's email address
     */
    public Member(long id, String firstName, String lastName, String password, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }


    /**
     * Get the member user's id
     *
     * @return the member user's id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the member user's id
     *
     * @param id the member user's id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the member user's first name
     *
     * @return the member user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the member user's first name
     *
     * @param firstName the member user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the member user's last name
     *
     * @return the member user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the member user's last name
     *
     * @param lastName the member user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the member user's password
     *
     * @return the member user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the member user's password
     *
     * @param password the member user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the member user's phone number
     *
     * @return the member user's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the member user's phone number
     *
     * @param phone the member user's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the member user's email address
     *
     * @return the member user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the member user's email address
     *
     * @param email the member user's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
