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
     * Return an arraylist of all staff with a certain id
     * <p>
     * Note that each staff should have a unique id. However this method allows for the chance that there is a
     * duplicate, and can be dealt with by the called. Also note that this method will return an empty arraylist if
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
