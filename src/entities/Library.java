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
     * The name of the library
     */
    private String name;
    /**
     * The library's eircode
     */
    private String eircode;
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
    public Library(String name, String eircode) {
        this.name = name;
        this.eircode = eircode;
    }


    /**
     * Get the name of the library
     *
     * @return the library's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the library
     *
     * @param name the library's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the library's eircode
     *
     * @return the library's eircode
     */
    public String getEircode() {
        return eircode;
    }

    /**
     * Set the library's eircode
     *
     * @param eircode the library's eircode
     */
    public void setEircode(String eircode) {
        this.eircode = eircode;
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

    /**
     * Remove a book from the library
     *
     * @param book the book to remove from the library
     * @return true if the book was in the library, otherwise false
     */
    public boolean removeBook(Book book) {
        return this.books.remove(book);
    }

    /**
     * Remove a staff user from the library
     *
     * @param staff the staff user to remove from the library
     * @return true if the staff user was in the library, otherwise false
     */
    public boolean removeStaff(Staff staff) {
        return this.staff.remove(staff);
    }

    /**
     * Remove a member from the library
     *
     * @param member the member to remove from the library
     * @return true if the member was in the library
     */
    public boolean removeMember(Member member) {
        return this.members.remove(member);
    }

    /**
     * Return an arraylist of all staff with a certain id
     * <p>
     * Note that each staff should have a unique id. However this method allows for the chance that there is a
     * duplicate, and can be dealt with by the caller. Also note that this method will return an empty arraylist if
     * a staff user with the given id is not found. This can be checked with aList.isEmpty();
     * </p>
     *
     * @param id the staff id to search for
     * @return an arraylist of staff user with that id
     */
    public ArrayList<Staff> getStaffByID(long id) {
        ArrayList<Staff> withID = new ArrayList<>();
        for (Staff s : staff) {
            if (s.getId() == id) {
                withID.add(s);
            }
        }
        return withID;
    }

    /**
     * Return an arraylist of all staff with a given first name
     *
     * @param name the staff first name to search for
     * @return an arraylist of all staff users with that first name
     */
    public ArrayList<Staff> getStaffByFirstName(String name) {
        ArrayList<Staff> withName = new ArrayList<>();
        for (Staff s : staff) {
            if (s.getFirstName().equals(name)) {
                withName.add(s);
            }
        }
        return withName;
    }

    /**
     * Return an arraylist of all staff with a given last name
     *
     * @param name the staff last name to search for
     * @return an arraylist of all staff users with that last name
     */
    public ArrayList<Staff> getStaffByLastName(String name) {
        ArrayList<Staff> withName = new ArrayList<>();
        for (Staff s : staff) {
            if (s.getLastName().equals(name)) {
                withName.add(s);
            }
        }
        return withName;
    }

    /**
     * Return an arraylist of all staff with a given username
     *
     * @param name the staff username to search for
     * @return an arraylist of all staff users with that username
     */
    public ArrayList<Staff> getStaffByUserName(String name) {
        ArrayList<Staff> withName = new ArrayList<>();
        for (Staff s : staff) {
            if (s.getUserName().equals(name)) {
                withName.add(s);
            }
        }
        return withName;
    }

    /**
     * Return an arraylist of all staff with a given password
     *
     * @param password the staff password to search for
     * @return an arraylist of all staff users with that password
     */
    public ArrayList<Staff> getStaffByPassword(String password) {
        ArrayList<Staff> withPassword = new ArrayList<>();
        for (Staff s : staff) {
            if (s.getPassword().equals(password)) {
                withPassword.add(s);
            }
        }
        return withPassword;
    }

    /**
     * Return an arraylist of all staff with a given phone number
     *
     * @param phoneNumber the phone number to search staff users for
     * @return an arraylist of all staff users with that phone number
     */
    public ArrayList<Staff> getStaffByPhoneNumber(String phoneNumber) {
        ArrayList<Staff> withNumber = new ArrayList<>();
        for (Staff s : staff) {
            if (s.getPhone().equals(phoneNumber)) {
                withNumber.add(s);
            }
        }
        return withNumber;
    }

    /**
     * Return an arraylist of all staff with a given email address
     * <p>
     * The size of the returned arraylist should be 0 or 1
     * </p>
     *
     * @param emailAddress the email address to search staff users for
     * @return an arraylist of all staff users with that email address
     */
    public ArrayList<Staff> getStaffByEmail(String emailAddress) {
        ArrayList<Staff> withEmail = new ArrayList<>();
        for (Staff s : staff) {
            if (s.getEmail().equals(emailAddress)) {
                withEmail.add(s);
            }
        }
        return withEmail;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Staff> getAllStaff() {
        return (ArrayList<Staff>) staff.clone();
    }

    /**
     * Return an arraylist of all members with a certain id
     * <p>
     * Note that each member should have a unique id. However this method allows for the chance that there is a
     * duplicate, and can be dealt with by the caller. Also note that this method will return an empty arraylist if
     * a member user with the given id is not found. This can be checked with aList.isEmpty();
     * </p>
     *
     * @param id the member id to search for
     * @return an arraylist of member users with that id
     */
    public ArrayList<Member> getMemberByID(long id) {
        ArrayList<Member> withID = new ArrayList<>();
        for (Member m : members) {
            if (m.getId() == id) {
                withID.add(m);
            }
        }
        return withID;
    }

    /**
     * Return an arraylist of all members with a given first name
     *
     * @param name the member first name to search for
     * @return an arraylist of all members users with that first name
     */
    public ArrayList<Member> getMemberByFirstName(String name) {
        ArrayList<Member> withName = new ArrayList<>();
        for (Member m : members) {
            if (m.getFirstName().equals(name)) {
                withName.add(m);
            }
        }
        return withName;
    }

    /**
     * Return an arraylist of all members with a given last name
     *
     * @param name the member last name to search for
     * @return an arraylist of all member users with that last name
     */
    public ArrayList<Member> getMemberByLastName(String name) {
        ArrayList<Member> withName = new ArrayList<>();
        for (Member m : members) {
            if (m.getLastName().equals(name)) {
                withName.add(m);
            }
        }
        return withName;
    }

    /**
     * Return an arraylist of all members with a given username
     *
     * @param name the member username to search for
     * @return an arraylist of all member users with that username
     */
    public ArrayList<Member> getMemberByUserName(String name) {
        ArrayList<Member> withName = new ArrayList<>();
        for (Member m : members) {
            if (m.getUserName().equals(name)) {
                withName.add(m);
            }
        }
        return withName;
    }

    public ArrayList<Member> getMemberByPassword(String password) {
        ArrayList<Member> withPassword = new ArrayList<>();
        for (Member m : members) {
            if (m.getPassword().equals(password)) {
                withPassword.add(m);
            }
        }
        return withPassword;
    }

    /**
     * Return an arraylist of all members with a given phone number
     *
     * @param phoneNumber the phone number to search member users for
     * @return an arraylist of all member users with that phone number
     */
    public ArrayList<Member> getMemberByPhoneNumber(String phoneNumber) {
        ArrayList<Member> withNumber = new ArrayList<>();
        for (Member m : members) {
            if (m.getPhone().equals(phoneNumber)) {
                withNumber.add(m);
            }
        }
        return withNumber;
    }

    /**
     * Return an arraylist of all members with a given email address
     * <p>
     * The size of the returned arraylist should be 0 or 1
     * </p>
     *
     * @param emailAddress the email address to search member users for
     * @return an arraylist of all member users with that email address
     */
    public ArrayList<Member> getMemberByEmail(String emailAddress) {
        ArrayList<Member> withEmail = new ArrayList<>();
        for (Member m : members) {
            if (m.getEmail().equals(emailAddress)) {
                withEmail.add(m);
            }
        }
        return withEmail;
    }

    /**
     * Return an arraylist of all books with a certain isbn
     * <p>
     * This means that there can be duplicates of the same book.
     * </p>
     *
     * @param isbn the isbn to search for
     * @return an arraylist of books with this isbn
     */
    public ArrayList<Book> getBookByISBN(long isbn) {
        ArrayList<Book> withISBN = new ArrayList<>();
        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                withISBN.add(b);
            }
        }
        return withISBN;
    }

    /**
     * Return an arraylist of all books with a given title
     *
     * @param title the title to search for
     * @return an arraylist of all books with that title
     */
    public ArrayList<Book> getBookByTitle(String title) {
        ArrayList<Book> withTitle = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                withTitle.add(b);
            }
        }
        return withTitle;
    }

    /**
     * Return an arraylist of all books with a given author
     *
     * @param author the author to search for
     * @return an arraylist of all books with that author
     */
    public ArrayList<Book> getBookByAuthor(String author) {
        ArrayList<Book> withAuthor = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                withAuthor.add(b);
            }
        }
        return withAuthor;
    }

    /**
     * Return an arraylist of all books with a given page count
     *
     * @param pages the page count to search for
     * @return an arraylist of all books with that page count
     */
    public ArrayList<Book> getBookByPages(int pages) {
        ArrayList<Book> withPages = new ArrayList<>();
        for (Book b : books) {
            if (b.getPages() == pages) {
                withPages.add(b);
            }
        }
        return withPages;
    }

    /**
     * Return an arraylist of all the illustrated or non-illustrated books
     *
     * @param isIllustrated true to search for illustrated books, false to search for non-illustrated books
     * @return an arraylist of books
     */
    public ArrayList<Book> getBooksByIsIllustrated(boolean isIllustrated) {
        ArrayList<Book> withIllustrations = new ArrayList<>();
        for (Book b : books) {
            if (b.isIllustrated() == isIllustrated) {
                withIllustrations.add(b);
            }
        }
        return withIllustrations;
    }

    /**
     * Return an arraylist of all the books that are, or are not in the library
     *
     * @param inLibrary true to search for books in the library, false to search for books not in the library
     * @return an arraylist of books
     */
    public ArrayList<Book> getBooksByInLibrary(boolean inLibrary) {
        ArrayList<Book> booksInLibrary = new ArrayList<>();
        for (Book b : books) {
            if (b.isIllustrated() == inLibrary) {
                booksInLibrary.add(b);
            }
        }
        return booksInLibrary;
    }
    // TODO 04/03/24: Add methods to remove, update, and delete objects from the library
    // TODO 04/03/24: Make methods to search for books static methods of the Book class maybe or in EntityUtils - decide where to put these methods
    // TODO 04/03/24: Give Members an arraylist of books that they have borrowed
    // TODO 04/03/24: Enable case insensitive searching
    // TODO 04/03/24: Add an option to search in a given arraylist
    // TODO 04/03/24: Remove the inLibrary method of the Book class

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", eircode='" + eircode + '\'' +
                ", books=" + books.size() +
                ", staff=" + staff.size() +
                ", members=" + members.size() +
                '}';
    }
}
