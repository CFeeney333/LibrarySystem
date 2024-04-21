package entities;

import java.util.ArrayList;

/**
 * A Member user of the library system.
 * <p>
 * A Member refers to someone who has an account with the library for borrowing books.
 * </p>
 */
public class Member extends User {

    /**
     * An arraylist of all the books that the member currently has borrowed
     */
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();


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

    /**
     * Borrow a book from the library
     *
     * <p>Add this book to the member's list of books that they have borrowed</p>
     *
     * @param book the book to borrow from the library
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Return a book to the library
     * <p>Remove this book from the member's list of books that they have borrowed</p>
     *
     * @param book the book to return to the library
     * @return true if the book was borrowed and has been removed, otherwise false
     */
    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            return true;
        }
        return false;
    }

    /**
     * Get a copy of all the books that the Member has borrowed
     *
     * @return a copy of the arraylist of borrowed books
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Book> getBorrowedBooks() {
        return (ArrayList<Book>) borrowedBooks.clone();
    }

    @Override
    protected Member clone() throws CloneNotSupportedException {
        Member member = (Member) super.clone();
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
