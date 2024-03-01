package entities;

import java.util.ArrayList;

/**
 * A Library manages users (members and staff) and the books of a library
 * <p>
 * Create, remove, update and delete members, staff and books in the library. Borrow and return books from and to
 * the library.
 * </p>
 */
public class Library {

    /**
     * The arraylist of books belonging to the library
     */
    private ArrayList<Book> books = new ArrayList<>();
    /**
     * The arraylist of library staff
     */
    private ArrayList<Staff> staff = new ArrayList<>();
    /**
     * The arraylist of members of the library
     */
    private ArrayList<Member> members = new ArrayList<>();


    /**
     * Create a Library object
     */
    public Library() {

    }


    /**
     * Add a book to the library
     *
     * @param book the book to add to the library
     */
    public void addBook(Book book) {
        this.books.add(book);
    }

    /**
     * Add a staff user to the library
     * <p>
     * A staff user is one who has admin privileges in the system
     * </p>
     *
     * @param staff the staff user to add to the library
     */
    public void addStaff(Staff staff) {
        this.staff.add(staff);
    }

    /**
     * Add a member to the library
     * <p>
     * A member of the library borrows and returns books
     * </p>
     *
     * @param member the member to add to the library
     */
    public void addMember(Member member) {
        this.members.add(member);
    }
}
