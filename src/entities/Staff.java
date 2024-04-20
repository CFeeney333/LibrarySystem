package entities;

/**
 * A member of Staff of a Library
 */
public class Staff extends User {

    /**
     * Create a Staff user of a library system
     * <p>
     * A Staff is an administrator of the library system
     * </p>
     *
     * @param id        the staff user's id
     * @param firstName the staff user's first name
     * @param lastName  the staff user's last name
     * @param userName  the staff user's display and login name
     * @param password  the staff user's password
     * @param phone     the staff user's phone number
     * @param email     the staff user's email address
     */
    public Staff(long id, String firstName, String lastName, String userName, String password, String phone, String email) {
        super(id, firstName, lastName, userName, password, phone, email);
    }

    @Override
    protected Staff clone() {
        Staff staff = (Staff) super.clone();
        return new Staff(getId(), getFirstName(), getLastName(), getUserName(), getPassword(), getPhone(), getEmail());
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + getId() + '\'' +
                ", firstname='" + getFirstName() + '\'' +
                ", lastname=" + getLastName() +
                ", username=" + getUserName() +
                ", password=" + getPassword() +
                ", phone=" + getPhone() +
                ", email=" + getEmail() +
                '}';
    }
}
