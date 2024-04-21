import entities.*;
import utilities.LibraryUtils;
import view.CLDisplay;
import view.Display;

import java.util.ArrayList;

import static utilities.LoadAndSave.*;

/**
 * This class simulates a Library System
 */
public class LibrarySystem {
    private static final Display d = new CLDisplay();
    private static final Library l = new Library("Luke Wadding Library", "");
    private static Admin a = null;

    public static void main(String[] args) {

        // Try and load files
        ArrayList<String> unloaded = new ArrayList<>();
        try {
            ArrayList<Book> books = load("books.xml");
            for (Book b : books) {
                l.addBook(b);
            }
        } catch (Exception e) {
            unloaded.add("books");
        }

        try {
            ArrayList<Member> members = load("members.xml");
            for (Member m : members) {
                l.addMember(m);
            }
        } catch (Exception e) {
            unloaded.add("members");
        }

        try {
            ArrayList<Staff> staff = load("staff.xml");
            for (Staff s : staff) {
                l.addStaff(s);
            }
        } catch (Exception e) {
            unloaded.add("staff");
        }

        try {
            a = (Admin) loadObject("admin.xml");
        } catch (Exception e) {
            // TODO 18/04/24: I should be able to add the admin to the library even if there is only one
            // if we can't load the admin, we have to create it ourselves
            a = new Admin("admin", "password");
            unloaded.add("admin");
        }

        // Print a message to the screen if some of the files couldn't load
        if (!unloaded.isEmpty()) {
            d.showMessage("WARNING!!!", "Unable to load " + unloaded);
        }

        d.showMessage("LIBRARY MANAGEMENT SYSTEM",
                """
                        Welcome to the Library Management System!
                                               \s
                        Here, you can create Staff, Members and Books, and add them to the system.
                        You can view, update and delete the objects""");

        boolean keepRunning = true;
        do {
            int option = d.showOptions("LIBRARY MANAGEMENT SYSTEM", "Log In", new String[]{
                    "Admin Login",
                    "Staff Login",
                    "Member Login",
                    "Exit"
            });

            switch (option) {
                case 1:
                    if (adminLogin()) {
                        startAdminSession();
                    }
                    break;
                case 2:
                    Staff s = staffLogin();
                    if (s != null) {
                        startStaffSession(s);
                    }
                    break;
                case 3:
                    Member m = memberLogin();
                    if (m != null) {
                        startMemberSession(m);
                    }
                    break;
                case 4:
                    keepRunning = false;
                    break;
            }
        } while (keepRunning);

        if (d.showConfirm("SAVE", "Do you want to save before closing?") == 0) {
            ArrayList<String> unsaved = new ArrayList<>();
            try {
                save("members.xml", l.getAllMembers());
            } catch (Exception e) {
                unsaved.add("members");
            }

            try {
                save("staff.xml", l.getAllStaff());
            } catch (Exception e) {
                unsaved.add("staff");
            }

            try {
                save("books.xml", l.getAllBooks());
            } catch (Exception e) {
                unsaved.add("books");
            }

            try {
                saveObject("admin.xml", a);
            } catch (Exception e) {
                unsaved.add("admin");
            }

            if (!unsaved.isEmpty()) {
                d.showMessage("WARNING!!!", "Unable to save " + unsaved);
            }
        }
    }

    /**
     * Return true if we have a valid administrator login
     *
     * @return true if successful login
     */
    private static boolean adminLogin() {
        final String HEADING = "ADMIN LOGIN";

        String password;

        while (true) {
            password = d.showInput(HEADING, "Enter password for " + a.getUserName() + ".", false);
            if (password.equals(a.getPassword())) {
                return true;
            }
            if (d.showConfirm(HEADING, "Invalid password for " + a.getUserName() + ". Do you want to try again?") == 1) {
                return false;
            }
        }
    }

    /**
     * Return the Staff user if we have a valid login
     *
     * @return the Staff object if we have a valid login, otherwise null
     */
    private static Staff staffLogin() {
        final String HEADING = "STAFF LOGIN";

        String username, password;
        while (true) {
            username = d.showInput(HEADING, "Enter Staff username", false);
            ArrayList<Staff> withUsername = l.getStaffByUserName(username);

            password = d.showInput(HEADING, ("Enter password for " + username + "."), false);
            ArrayList<Staff> withPassword = l.getStaffByPassword(password);

            for (Staff u : withUsername) {
                for (Staff p : withPassword) {
                    if (u == p) {
                        return u;
                    }
                }
            }
            if (d.showConfirm(HEADING, "Invalid username or password. Do you want to try again?") == 1) {
                // no
                return null;
            }
        }
    }

    /**
     * Return the Member user if we have a valid login
     *
     * @return the Member object if we have a valid login, otherwise null
     */
    private static Member memberLogin() {
        final String HEADING = "MEMBER LOGIN";

        String username, password;
        while (true) {
            username = d.showInput(HEADING, "Enter Member username", false);
            ArrayList<Member> withUsername = l.getMemberByUserName(username);

            password = d.showInput(HEADING, ("Enter password for " + username + "."), false);
            ArrayList<Member> withPassword = l.getMemberByPassword(password);

            for (Member u : withUsername) {
                for (Member p : withPassword) {
                    if (u == p) {
                        return u;
                    }
                }
            }
            if (d.showConfirm(HEADING, "Invalid username or password. Do you want to try again?") == 1) {
                // no
                return null;
            }
        }
    }

    private static void startAdminSession() {
        boolean loggedIn = true;
        do {
            // TODO 15/04/24: Add option to change library details
            // TODO 15/04/24: Save library details to file
            int option = d.showOptions("MAIN MENU", "Logged in as " + a.getUserName(), new String[]{
                    "Manage Staff",
                    "Change Password",
                    "Logout"
            });

            switch (option) {
                case 1:
                    manageStaff();
                    break;
                case 2:
                    changePassword(a);
                    break;
                case 3:
                    loggedIn = false;
                    break;
            }
        } while (loggedIn);
    }

    private static void startStaffSession(Staff s) {
        boolean loggedIn = true;
        do {
            int option = d.showOptions("MAIN MENU", "Logged in as " + s.getUserName(), new String[]{
                    "Manage Members",
                    "Manage Books",
                    "Manage Account",
                    "Logout"
            });

            switch (option) {
                case 1:
                    manageMembers();
                    break;
                case 2:
                    manageBooks();
                    break;
                case 3:
                    manageAccount(s);
                    break;
                case 4:
                    loggedIn = false;
                    break;
            }
        } while (loggedIn);
    }

    private static void startMemberSession(Member m) {
        do {
            int option = d.showOptions("MAIN MENU", "Logged in as " + m.getUserName(), new String[]{
                    "Borrow Books",
                    "Return Books",
                    "Manage Account",
                    "Logout"
            });

            switch (option) {
                case 1:
                    borrowBook(m);
                    break;
                case 2:
                    returnBook(m);
                    break;
                case 3:
                    manageAccount(m);
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    private static void borrowBook(Member m) {
        final String HEADING = "BORROW BOOKS";
        d.showMessage(HEADING, "Not yet implemented!");
    }

    private static void returnBook(Member m) {
        final String HEADING = "RETURN BOOKS";
        d.showMessage(HEADING, "Not yet implemented!");
    }

    /**
     * Method to manage an account, giving the user options to change their username and password
     *
     * @param account any user that extends BasicUser has an account
     */
    private static void manageAccount(BasicUser account) {
        final String HEADING = "MANAGE ACCOUNT";
        do {
            int option = d.showOptions(HEADING, "Choose an option", new String[]{
                    "Change username",
                    "Change password",
                    "<- Back to Main Menu"
            });
            switch (option) {
                case 1:
                    d.showMessage("CHANGE USERNAME", "Not yet implemented!");
                    break;
                case 2:
                    changePassword(account);
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    /**
     * Method to change the password of a Basic User account
     *
     * @param account the account to change the password of
     */
    private static void changePassword(BasicUser account) {
        final String HEADING = "CHANGE PASSWORD";
        String pwdAttempt;
        while (true) {
            pwdAttempt = d.showInput(HEADING, "Please enter current Password", false);
            if (pwdAttempt.equals(account.getPassword())) {
                // now we can change the password
                account.setPassword(d.showInput(HEADING, "Enter new Password", false));
            } else {
                if (d.showConfirm(HEADING, "Incorrect Password! Do you want to try again") == 1) {
                    return;
                }
            }
        }
    }

    /**
     * The main menu for staff crud functionality
     */
    private static void manageStaff() {
        do {
            int option = d.showOptions("STAFF MANAGEMENT", "Choose an option", new String[]{
                    "Add Staff User",
                    "Display Staff Users",
                    "Update Staff User",
                    "Delete Staff User",
                    "<- Back to Main Menu"
            });

            switch (option) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    displayStaff();
                    break;
                case 3:
                    updateStaff();
                    break;
                case 4:
                    deleteStaff();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    /**
     * A helper method for searching for staff members, giving the user the option of various search methods
     *
     * @param heading the heading to use for the display
     * @return an ArrayList with the search results of all the staff matching the user's search criteria or null if the user opted to go back
     */
    private static ArrayList<Staff> searchStaff(String heading) {
        ArrayList<Staff> searchResult = null;
        switch (d.showOptions(heading, "Choose a search method", new String[]{
                "All",
                "Find by First Name",
                "Find by Last Name",
                "Find by Username",
                "Find by Phone Number",
                "Find by Email Address",
                "<- Back"
        })) {
            case 1:
                searchResult = l.getAllStaff();
                break;
            case 2:
                String firstName = d.showInput(heading, "What first name do you want to search for? ", false);
                searchResult = l.getStaffByFirstName(firstName);
                break;
            case 3:
                String lastName = d.showInput(heading, "What last name do you want to search for? ", false);
                searchResult = l.getStaffByLastName(lastName);
                break;
            case 4:
                String userName = d.showInput(heading, "What username do you want to search for? ", false);
                searchResult = l.getStaffByUserName(userName);
                break;
            case 5:
                String phone = d.showInput(heading, "What phone number do you want to search for? ", false);
                searchResult = l.getStaffByPhoneNumber(phone);
                break;
            case 6:
                String email = d.showInput(heading, "What email address do you want to search for? ", false);
                searchResult = l.getStaffByEmail(email);
                break;
            case 7:
                return null;
        }
        return searchResult;
    }

    /**
     * Menu to add a Staff member to the system
     */
    private static void addStaff() {
        final String HEADING = "ADD STAFF";
        do {
            // Get the id
            boolean invalid = false;
            long id = 0L;
            do {
                String input = d.showInput(HEADING, "ID:", invalid);
                try {
                    id = Long.parseLong(input);
                } catch (NumberFormatException e) {
                    invalid = true;
                    continue;
                }
                invalid = false;

                // if the id is already in use by a staff user, it can't be used again
                if (!l.getStaffByID(id).isEmpty()) {
                    invalid = true;
                    d.showMessage(HEADING, "Staff with ID " + id + " already exists! Please enter a unique id");
                }

            } while (invalid);

            // Get the firstname and lastname
            String firstName, lastName;
            firstName = d.showInput(HEADING, "First Name:", false);
            lastName = d.showInput(HEADING, "Last Name:", false);

            // Get the username and password
            String userName, password;
            userName = d.showInput(HEADING, "User Name:", false);
            password = d.showInput(HEADING, "Password:", false);

            // Get the phone number and email address
            String phone, email;
            phone = d.showInput(HEADING, "Phone Number:", false);
            email = d.showInput(HEADING, "Email Address:", false);

            // Create the staff user
            Staff s = new Staff(id, firstName, lastName, userName, password, phone, email);

            // Confirm add
            if (d.showConfirm(HEADING, "Confirm add the following staff user:\n" + s) == 0) {
                l.addStaff(s);
            }

            // Give option to return to main menu or add a new staff user
            if (d.showConfirm(HEADING, "Do you want to add another staff user?") == 1) {
                return;
            }
        } while (true);
    }

    /**
     * Menu to display Staff members based on a search selection
     */
    private static void displayStaff() {
        final String HEADING = "DISPLAY STAFF";
        ArrayList<Staff> searchResult;
        do {
            searchResult = searchStaff(HEADING);
            if (searchResult == null) {
                return;
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No staff found!");
            } else {
                d.showMessage(HEADING, "Search Results:\n" + LibraryUtils.orderedUserList(searchResult));
            }
        } while (true);
    }

    /**
     * Menu to update a Staff member based on a search selection
     */
    private static void updateStaff() {
        final String HEADING = "UPDATE STAFF";
        ArrayList<Staff> searchResult;
        do {
            Staff selection;
            // Search for and select a staff member
            searchResult = searchStaff(HEADING);
            if (searchResult == null) {
                return;  // the user wants to go back to the main menu
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No staff found!");
                continue;
            } else {
                String[] options = new String[searchResult.size()];
                for (int i = 0; i < searchResult.size(); i++) {
                    options[i] = LibraryUtils.userListItem(searchResult.get(i));
                }
                selection = searchResult.get(d.showOptions(HEADING, "Choose a staff user:\n", options) - 1);  // take away one to represent the index
            }

            // Find the property to update - this will only run if the else clause has been run so no need to put it inside
            boolean keepUpdating = true;
            do {
                int propertyOption = d.showOptions(HEADING, "What property do you want to update:\n",
                        new String[]{
                                "ID",
                                "First Name",
                                "Last Name",
                                "Phone Number",
                                "Email Address",
                                "<- Back"
                        });
                switch (propertyOption) {
                    case 1:
                        boolean invalid = false;
                        long id = 0L;
                        do {
                            String input = d.showInput(HEADING, "Enter new value for ID\nCurrent value: " + selection.getId(), invalid);
                            try {
                                id = Long.parseLong(input);
                            } catch (NumberFormatException e) {
                                invalid = true;
                                continue;
                            }
                            invalid = false;

                            // if the id is already in use by a staff user, it can't be used again
                            if (!l.getStaffByID(id).isEmpty()) {
                                invalid = true;
                                d.showMessage(HEADING, "Staff with ID " + id + " already exists! Please enter a unique id");
                            }

                        } while (invalid);
                        selection.setId(id);
                        break;
                    case 2:
                        selection.setFirstName(d.showInput(HEADING, "Enter new value for First name\nCurrent value: " + selection.getFirstName(), false));
                        break;
                    case 3:
                        selection.setLastName(d.showInput(HEADING, "Enter new value for Last name\nCurrent value: " + selection.getLastName(), false));
                        break;
                    case 4:
                        selection.setPhone(d.showInput(HEADING, "Enter new Phone Number\nCurrent value: " + selection.getPhone(), false));
                        break;
                    case 5:
                        selection.setEmail(d.showInput(HEADING, "Enter new Email Address\nCurrent value: " + selection.getEmail(), false));
                        break;
                    case 6:
                        keepUpdating = false;
                        break;
                }
                if (keepUpdating) {
                    if (d.showConfirm(HEADING, "Do you want to update another property?") == 1) {
                        d.showMessage(HEADING, "Updated Staff User\n" + LibraryUtils.userListItem(selection));
                        keepUpdating = false;
                    }
                }
            } while (keepUpdating);
        } while (true);
    }

    /**
     * Menu to delete a Staff user based on a search selection
     */
    private static void deleteStaff() {
        final String HEADING = "DELETE STAFF";
        ArrayList<Staff> searchResult;
        do {
            Staff selection;
            // search for and select a staff user
            searchResult = searchStaff(HEADING);
            if (searchResult == null) {
                return;  // the user wants to go back to the main menu
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No staff found!");
                continue;
            } else {
                String[] options = new String[searchResult.size()];
                for (int i = 0; i < searchResult.size(); i++) {
                    options[i] = LibraryUtils.userListItem(searchResult.get(i));
                }
                selection = searchResult.get(d.showOptions(HEADING, "Choose a staff user:\n", options) - 1);  // take away one to represent the index
            }

            if (d.showConfirm(HEADING, "Are you sure you want to delete the following staff user from the system?\n" + LibraryUtils.userListItem(selection)) == 0) {
                if (l.removeStaff(selection)) {
                    d.showMessage(HEADING, "Staff user removed");
                } else {
                    d.showMessage(HEADING, "Warning! Staff not found");
                }
            }
        } while (true);
    }

    /**
     * The main menu for book crud functionality
     */
    private static void manageBooks() {
        do {
            int option = d.showOptions("MEMBER MANAGEMENT", "Choose an option", new String[]{
                    "Add Book",
                    "Display Books",
                    "Update Book",
                    "Delete Book",
                    "<- Back to Main Menu"
            });

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    /**
     * A helper method for searching for books, giving the user the option of various search methods
     *
     * @param heading the heading to use for the display
     * @return an ArrayList with the search results of all the staff matching the user's search criteria or null if the user opted to go back
     */
    private static ArrayList<Book> searchBooks(String heading) {
        ArrayList<Book> searchResult = null;
        switch (d.showOptions(heading, "Choose a search method", new String[]{
                "All",
                "Find by ISBN",
                "Find by Title",
                "Find by Author",
                "Find by Page count",
                "Find by Illustrated",
                "Find books currently in library",
                "<- Back"
        })) {
            case 1:
                searchResult = l.getAllBooks();
                break;
            case 2:
                long isbn = 0L;
                boolean invalidISBN = false;
                do {
                    String input = d.showInput(heading, "What ISBN do you want to search for?", false);
                    try {
                        isbn = Long.parseLong(input);
                    } catch (NumberFormatException e) {
                        d.showMessage(heading, "Invalid ISBN number!");
                        invalidISBN = true;
                    }
                    if (isbn <= 0) {
                        d.showMessage(heading, "ISBN can not be negative!");
                        invalidISBN = true;
                    }
                } while (d.showConfirm(heading, "Try again?") == 1);
                if (invalidISBN) {
                    return new ArrayList<>();  // don't go back to the main menu, but just say that no books were found if an invalid isbn was given
                }
                break;
            case 3:
                String title = d.showInput(heading, "What title do you want to search for? ", false);
                searchResult = l.getBookByTitle(title);
                break;
            case 4:
                String author = d.showInput(heading, "What author do you want to search for? ", false);
                searchResult = l.getBookByAuthor(author);
                break;
            case 5:
                int pages = 0;
                boolean invalidPages = false;
                do {
                    String input = d.showInput(heading, "How many pages are in the book you are searching for?", false);
                    try {
                        pages = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        d.showMessage(heading, "Invalid page number!");
                        invalidPages = true;
                    }
                    if (pages <= 0) {
                        d.showMessage(heading, "Page number can not be negative!");
                        invalidPages = true;
                    }
                } while (d.showConfirm(heading, "Try again?") == 1);
                if (invalidPages) {
                    return new ArrayList<>();  // as above, don't go back to the main menu, just say that no books were found
                }
                break;
            case 6:
                searchResult = d.showOptions(heading, "Which do you want to retrieve?", new String[]{
                        "Illustrated books",
                        "Non-Illustrated books"
                }) == 1 ? l.getBooksByIsIllustrated(true) : l.getBooksByIsIllustrated(false);
                break;
            case 7:
                searchResult = d.showOptions(heading, "Which do you want to retrieve?", new String[]{
                        "Books in library",
                        "Books on loan"
                }) == 1 ? l.getBooksByInLibrary(true) : l.getBooksByInLibrary(false);
                break;
            case 8:
                return null;
        }
        return searchResult;
    }

    /**
     * Menu to add a Book to the system
     */
    private static void addBook() {
        final String HEADING = "ADD BOOK";
        do {
            // Get the title
            String title;
            title = d.showInput(HEADING, "Title:", false);

            // Get the author
            String author;
            author = d.showInput(HEADING, "Author:", false);

            // Get the isbn - there can be duplicates
            // TODO 18/04/2024: remove the ability for there to be duplicate books - use a hash map or something with the isbn as the key
            boolean invalidISBN = false;
            long isbn = 0L;
            do {
                String input = d.showInput(HEADING, "ISBN:", invalidISBN);
                try {
                    isbn = Long.parseLong(input);
                } catch (NumberFormatException e) {
                    invalidISBN = true;
                    continue;
                }
                invalidISBN = false;
            } while (invalidISBN);

            // Get the pages
            boolean invalidPages = false;
            int pages = 0;
            do {
                String input = d.showInput(HEADING, "Pages:", invalidPages);
                try {
                    pages = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    invalidPages = true;
                    continue;
                }
                invalidPages = false;
            } while (invalidPages);

            // Is it illustrated?
            boolean isIllustrated = d.showConfirm(HEADING, "Is the book illustrated?") == 0;

            // Create the new book - the book is automatically in the library
            Book b = new Book(title, author, isbn, pages, isIllustrated);

            // Confirm add
            if (d.showConfirm(HEADING, "Confirm add the following book:\n" + b) == 0) {
                l.addBook(b);
            }

            // Give option to return to main menu or add a new book
            if (d.showConfirm(HEADING, "Do you want to add another book?") == 1) {
                return;
            }
        } while (true);
    }

    /**
     * Menu to display the Books in the system based on a search selection
     */
    private static void displayBooks() {
        final String HEADING = "DISPLAY BOOKS";
        ArrayList<Book> searchResult;
        do {
            searchResult = searchBooks(HEADING);
            if (searchResult == null) {
                return;
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No books found!");
            } else {
                d.showMessage(HEADING, "Search Results:\n" + LibraryUtils.orderedBookList(searchResult));
            }
        } while (true);
    }

    /**
     * Menu to update Books in the system based on a search selection
     */
    private static void updateBook() {
        final String HEADING = "UPDATE BOOK";
        ArrayList<Book> searchResult;
        do {
            Book selection;
            // Search for and select a book
            searchResult = searchBooks(HEADING);
            if (searchResult == null) {
                return;  // the user wants to go back to the main menu
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No books found!");
                continue;
            } else {
                String[] options = new String[searchResult.size()];
                for (int i = 0; i < searchResult.size(); i++) {
                    options[i] = LibraryUtils.bookListItem(searchResult.get(i));
                }
                selection = searchResult.get(d.showOptions(HEADING, "Choose a Book:\n", options) - 1);  // take away one to represent the index
            }

            // Find the property to update
            boolean keepUpdating = true;
            do {
                int propertyOption = d.showOptions(HEADING, "What property do you want to update:\n", new String[]{
                        "ISBN",
                        "Title",
                        "Author",
                        "Pages",
                        "Is the book illustrated?",
                        "Is the book in the library?",
                        "<- Back"
                });
                switch (propertyOption) {
                    case 1:
                        boolean invalidISBN = false;
                        long isbn = 0L;
                        do {
                            String input = d.showInput(HEADING, "ISBN:", invalidISBN);
                            try {
                                isbn = Long.parseLong(input);
                            } catch (NumberFormatException e) {
                                invalidISBN = true;
                                continue;
                            }
                            invalidISBN = false;
                            // TODO 18/04/24: Create helper methods for getting a valid isbn, password, id etc. to make sure it's not negative or anything
                            // TODO 18/04/24: Make sure the isbn is not negative
                        } while (invalidISBN);
                        selection.setIsbn(isbn);
                        break;
                    case 2:
                        selection.setTitle(d.showInput(HEADING, "Enter new value for Title\nCurrent value: " + selection.getTitle(), false));
                        break;
                    case 3:
                        selection.setAuthor(d.showInput(HEADING, "Enter new value for Author\nCurrent value: " + selection.getAuthor(), false));
                        break;
                    case 4:
                        boolean invalidPages;
                        int pages = 0;
                        // TODO 18/04/24: As above, create a utility method for validating this
                        do {
                            String input = d.showInput(HEADING, "Enter new value for amount of Pages\nCurrent value: " + selection.getPages(), false);
                            try {
                                pages = Integer.parseInt(input);
                            } catch (NumberFormatException e) {
                                invalidPages = true;
                                continue;
                            }
                            invalidPages = false;
                        } while (invalidPages);
                        selection.setPages(pages);
                        break;
                    case 5:
                        selection.setIllustrated(d.showConfirm(HEADING, "Is the book illustrated?\nCurrent value: " + selection.isIllustrated()) == 0);
                        break;
                    case 6:
                        selection.setInLibrary(d.showConfirm(HEADING, "Is the book in the library?\nCurrent value: " + selection.isInLibrary()) == 0);
                        break;
                    case 7:
                        keepUpdating = false;
                        break;
                }
                if (keepUpdating) {
                    if (d.showConfirm(HEADING, "Do you want to update another property?") == 1) {
                        d.showMessage(HEADING, "Update Book\n" + LibraryUtils.bookListItem(selection));
                        keepUpdating = false;
                    }
                }
            } while (keepUpdating);
        } while (true);
    }

    /**
     * Menu to delete a Book from the system based on a search selection
     */
    private static void deleteBook() {
        final String HEADING = "DELETE BOOK";
        ArrayList<Book> searchResult;
        do {
            Book selection;
            // search for and select a book
            searchResult = searchBooks(HEADING);
            if (searchResult == null) {
                return;  // the user wants to go back to the main menu
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No books found!");
                continue;
            } else {
                String[] options = new String[searchResult.size()];
                for (int i = 0; i < searchResult.size(); i++) {
                    options[i] = LibraryUtils.bookListItem(searchResult.get(i));
                }
                selection = searchResult.get(d.showOptions(HEADING, "Choose a book:\n", options) - 1);
            }

            if (d.showConfirm(HEADING, "Are you sure you want to delete the following book from the system?\n" + LibraryUtils.bookListItem(selection)) == 0) {
                if (l.removeBook(selection))
                    d.showMessage(HEADING, "Book removed");
                else {
                    d.showMessage(HEADING, "Warning! Book not found");
                }
            }
        } while (true);
    }

    /**
     * The main menu for member crud functionality
     */
    private static void manageMembers() {
        do {
            int option = d.showOptions("MEMBER MANAGEMENT", "Choose an option", new String[]{
                    "Add Member User",
                    "Display Member Users",
                    "Update Member User",
                    "Delete Member User",
                    "<- Back to Main Menu"
            });

            switch (option) {
                case 1:
                    addMember();
                    break;
                case 2:
                    displayMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    /**
     * A helper method for searching for members, giving the user the option of various search methods
     *
     * @param heading the heading to use for the display
     * @return an ArrayList with the search results of all the staff matching the user's search criteria or null if the user opted to go back
     */
    private static ArrayList<Member> searchMembers(String heading) {
        ArrayList<Member> searchResult = null;
        switch (d.showOptions(heading, "Choose a search method", new String[]{
                // TODO 18/04/2024: Add way to search by id, also for searching staff
                "All",
                "Find by First Name",
                "Find by Last Name",
                "Find by Username",
                "Find by Phone Number",
                "Find by Email Address",
                "<- Back"
        })) {
            case 1:
                searchResult = l.getAllMembers();
                break;
            case 2:
                String firstName = d.showInput(heading, "What first name do you want to search for? ", false);
                searchResult = l.getMemberByFirstName(firstName);
                break;
            case 3:
                String lastName = d.showInput(heading, "What last name do you want to search for? ", false);
                searchResult = l.getMemberByLastName(lastName);
                break;
            case 4:
                String userName = d.showInput(heading, "What username do you want to search for? ", false);
                searchResult = l.getMemberByUserName(userName);
                break;
            case 5:
                String phone = d.showInput(heading, "What phone number do you want to search for? ", false);
                searchResult = l.getMemberByPhoneNumber(phone);
                break;
            case 6:
                String email = d.showInput(heading, "What email address do  you want to search for? ", false);
                searchResult = l.getMemberByEmail(email);
                break;
            case 7:
                return null;
        }
        return searchResult;
    }

    /**
     * Menu to add a Member user to the system
     */
    private static void addMember() {
        final String HEADING = "ADD MEMBER";
        do {
            // Get the id
            boolean invalid = false;
            long id = 0L;
            do {
                String input = d.showInput(HEADING, "ID:", invalid);
                try {
                    id = Long.parseLong(input);
                } catch (NumberFormatException e) {
                    invalid = true;
                    continue;
                }
                invalid = false;

                // if the id is already in use by a member user, it can't be used again
                if (!l.getMemberByID(id).isEmpty()) {
                    invalid = true;
                    d.showMessage(HEADING, "Members with ID " + id + " already exists! Please enter a unique id");
                }

            } while (invalid);

            // Get the firstname and lastname
            String firstName, lastName;
            firstName = d.showInput(HEADING, "First Name:", false);
            lastName = d.showInput(HEADING, "Last Name:", false);

            // Get the username and password
            String userName, password;
            userName = d.showInput(HEADING, "User Name:", false);
            password = d.showInput(HEADING, "Password:", false);

            // Get the phone number and email address
            String phone, email;
            phone = d.showInput(HEADING, "Phone Number:", false);
            email = d.showInput(HEADING, "Email Address:", false);

            // Create the member user
            Member m = new Member(id, firstName, lastName, userName, password, phone, email);

            // Confirm add
            if (d.showConfirm(HEADING, "Confirm add the following member user:\n" + m) == 0) {
                l.addMember(m);
            }

            // Give option to return to main menu or add a new member user
            if (d.showConfirm(HEADING, "Do you want to add another member user?") == 1) {
                return;
            }
        } while (true);
    }

    /**
     * Menu to display Member users based on a search selection
     */
    private static void displayMember() {
        final String HEADING = "DISPLAY MEMBER";
        ArrayList<Member> searchResult;
        do {
            searchResult = searchMembers(HEADING);
            if (searchResult == null) {
                return;
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No members found!");
            } else {
                d.showMessage(HEADING, "Search Results:\n" + LibraryUtils.orderedUserList(searchResult));
            }
        } while (true);
    }

    /**
     * Menu to update a Member user based on a search selection
     */
    private static void updateMember() {
        final String HEADING = "UPDATE MEMBER";
        ArrayList<Member> searchResult;
        do {
            Member selection;
            // Search for and select a member
            searchResult = searchMembers(HEADING);
            if (searchResult == null) {
                return;  // the user wants to go back to the main menu
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No members found!");
                continue;
            } else {
                String[] options = new String[searchResult.size()];
                for (int i = 0; i < searchResult.size(); i++) {
                    options[i] = LibraryUtils.userListItem(searchResult.get(i));
                }
                selection = searchResult.get(d.showOptions(HEADING, "Choose a member:\n", options));
            }

            // Find property to update - this will only run if the else clause has been run so no need to put it inside
            boolean keepUpdating = true;
            do {
                int propertyOption = d.showOptions(HEADING, "What property do you want to update:\n",
                        new String[]{
                                "ID",
                                "First Name",
                                "Last Name",
                                "Phone Number",
                                "Email Address",
                                "<- Back"
                        });
                switch (propertyOption) {
                    case 1:
                        boolean invalid = false;
                        long id = 0L;
                        do {
                            String input = d.showInput(HEADING, "Enter new value for ID\nCurrent value: " + selection.getId(), invalid);
                            try {
                                id = Long.parseLong(input);
                            } catch (NumberFormatException e) {
                                invalid = true;
                                continue;
                            }
                            invalid = false;

                            // if the id is already in use by a member user, it can't be used again
                            if (!l.getMemberByID(id).isEmpty()) {
                                invalid = true;
                                d.showMessage(HEADING, "Member with ID " + id + " already exists! Please enter a unique id");
                            }
                        } while (invalid);
                        selection.setId(id);
                        break;
                    case 2:
                        selection.setFirstName(d.showInput(HEADING, "Enter new value for First name\nCurrent value: " + selection.getFirstName(), false));
                        break;
                    case 3:
                        selection.setLastName(d.showInput(HEADING, "Enter new value for Last name\nCurrent value: " + selection.getLastName(), false));
                        break;
                    case 4:
                        selection.setPhone(d.showInput(HEADING, "Enter new Phone Number\nCurrent value: " + selection.getPhone(), false));
                        break;
                    case 5:
                        selection.setEmail(d.showInput(HEADING, "Enter new Email Address\nCurrent value: " + selection.getEmail(), false));
                        break;
                    case 6:
                        keepUpdating = false;
                        break;
                }
                if (d.showConfirm(HEADING, "Do you want to update another property?") == 1) {
                    d.showMessage(HEADING, "Updated Member\n" + LibraryUtils.userListItem(selection));
                    keepUpdating = false;
                }
            } while (keepUpdating);
        } while (true);
    }

    /**
     * Menu to delete a Member user based on a search selection
     */
    private static void deleteMember() {
        final String HEADING = "DELETE MEMBER";
        ArrayList<Member> searchResult;
        do {
            Member selection;
            // search for and select a member user
            searchResult = searchMembers(HEADING);
            if (searchResult == null) {
                return;  // the user wants to go back to the main menu
            }
            if (searchResult.isEmpty()) {
                d.showMessage(HEADING, "No members found!");
                continue;
            } else {
                String[] options = new String[searchResult.size()];
                for (int i = 0; i < searchResult.size(); i++) {
                    options[i] = LibraryUtils.userListItem(searchResult.get(i));
                }
                selection = searchResult.get(d.showOptions(HEADING, "Choose a member:\n", options) - 1);  //  take away one to represent the index
            }

            if (d.showConfirm(HEADING, "Are you sure you want to delete the following member from the system?\n" + LibraryUtils.userListItem(selection)) == 0) {
                if (l.removeMember(selection)) {
                    d.showMessage(HEADING, "Member user removed");
                } else {
                    d.showMessage(HEADING, "Warning! Member not found");
                }
            }
        } while (true);
    }
}
