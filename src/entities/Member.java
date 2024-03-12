package entities;

import java.util.ArrayList;

/**
 * A Member user of the library system.
 * <p>
 * A Member refers to someone who has an account with the library for borrowing books.
 * </p>
 */
public class Member extends User {

    private ArrayList<Book> borrowedBooks = new ArrayList<>();


    /**
     * Create a Member user of a library system
     * <p>
     * A Member is someone who borrows and returns books
     * </p>
     *
     * @param id        the member user's id
     * @param firstName the member user's first name
     * @param lastName  the member user's last name
     * @param userName  the member user's display and login name
     * @param password  the member user's password
     * @param phone     the member user's phone number
     * @param email     the member user's email address
     */
    public Member(long id, String firstName, String lastName, String userName, String password, String phone, String email) {
        super(id, firstName, lastName, userName, password, phone, email);
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            return true;
        }
        return false;
    }

    @Override
    protected Member clone() throws CloneNotSupportedException {
        return new Member(getId(), getFirstName(), getLastName(), getUserName(), getPassword(), getPhone(), getEmail());
    }

    @Override
    public String toString() {
        return "Member{" +
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
