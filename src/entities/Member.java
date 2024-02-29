package entities;

/**
 * A Member user of the library system.
 * <p>
 * A Member refers to someone who has an account with the library for borrowing books.
 * </p>
 */
public class Member extends User {

    /**
     * Create a Member user of a library system
     * <p>
     * A Member is someone who borrows and returns books
     * </p>
     *
     * @param id        the member user's id
     * @param firstName the member user's first name
     * @param lastName  the member user's last name
     * @param password  the member user's password
     * @param phone     the member user's phone number
     * @param email     the member user's email address
     */
    public Member(long id, String firstName, String lastName, String password, String phone, String email) {
        super(id, firstName, lastName, password, phone, email);
    }
}
