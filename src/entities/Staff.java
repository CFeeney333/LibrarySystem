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
     * @param password  the staff user's password
     * @param phone     the staff user's phone number
     * @param email     the staff user's email address
     */
    public Staff(long id, String firstName, String lastName, String password, String phone, String email) {
        super(id, firstName, lastName, password, phone, email);
    }

    @Override
    protected Staff clone() throws CloneNotSupportedException {
        return new Staff(getId(), getFirstName(), getLastName(), getPassword(), getPhone(), getEmail());
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + getId() + '\'' +
                ", firstname='" + getFirstName() + '\'' +
                ", lastname=" + getLastName() +
                ", password=" + getPassword() +
                ", phone=" + getPhone() +
                ", email=" + getEmail() +
                '}';
    }
}
