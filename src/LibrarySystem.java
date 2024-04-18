import entities.Admin;
import entities.Library;
import entities.Member;
import entities.Staff;
import utilities.LibraryUtils;
import view.CLDisplay;
import view.Display;

import java.util.ArrayList;

/**
 * This class simulates a Library System
 */
public class LibrarySystem {
    private static final Display d = new CLDisplay();
    private static final Library l = new Library("Luke Wadding Library", "");
    private static final Admin a = new Admin("admin", "password");

    public static void main(String[] args) {
        // Add placeholder staff user
        l.addStaff(new Staff(1111, "Tom", "Dwyer", "tdwyer", "pwd", "089 123 4567", "t.dwyer@lib.ie"));

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
                    "Manage Password",
                    "Logout"
            });

            switch (option) {
                case 1:
                    manageStaff();
                    break;
                case 2:
                    d.showMessage("MANAGE PASSWORD", "Not yet implemented!");
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
                    d.showMessage("MANAGE STAFF ACCOUNT", "Not yet implemented!");
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
                    d.showMessage("BORROW BOOKS", "Not yet implemented!");
                    break;
                case 2:
                    d.showMessage("RETURN BOOKS", "Not yet implemented!");
                    break;
                case 3:
                    d.showMessage("MANAGE MEMBER ACCOUNT", "Not yet implemented!");
                    break;
                case 4:
                    return;
            }
        } while (true);
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
                    d.showMessage(HEADING, "Staff with ID " + id + " already exists!. Please enter a unique id");
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
                d.showMessage(HEADING, "Search Results:\n" + LibraryUtils.orderedStaffList(searchResult));
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
                    options[i] = LibraryUtils.staffListItem(searchResult.get(i));
                }
                selection = searchResult.get(d.showOptions(HEADING, "Choose a staff member:\n", options) - 1);  // take away one to represent the index
            }

            // Find the property to update - this will only run if the else clause has been run so no need to put it inside
            boolean keepUpdating = true;
            do {
                int propertyOption = d.showOptions(HEADING, "What property do you want to update:\n",
                        new String[]{
                                "ID",
                                "First Name",
                                "Last Name",
                                "Username",
                                "Password",
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
                                d.showMessage(HEADING, "Staff with ID " + id + " already exists!. Please enter a unique id");
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
                        selection.setUserName(d.showInput(HEADING, "Enter new Username\nCurrent value: " + selection.getUserName(), false));
                        break;
                    case 5:
                        String pwdAttempt = d.showInput(HEADING, "Please enter current Password", false);
                        if (pwdAttempt.equals(selection.getPassword())) {
                            // now we can change the password
                            selection.setPassword(d.showInput(HEADING, "Enter new Password", false));
                        } else {
                            d.showMessage(HEADING, "Incorrect password!");
                        }
                        break;
                    case 6:
                        selection.setPhone(d.showInput(HEADING, "Enter new Phone Number\nCurrent value: " + selection.getPhone(), false));
                        break;
                    case 7:
                        selection.setEmail(d.showInput(HEADING, "Enter new Email Address\nCurrent value: " + selection.getEmail(), false));
                        break;
                    case 8:
                        keepUpdating = false;
                        break;
                }
                if (keepUpdating) {
                    if (d.showConfirm(HEADING, "Do you want to update another property?") == 1) {
                        d.showMessage(HEADING, "Updated Staff Member\n" + LibraryUtils.staffListItem(selection));
                        keepUpdating = false;
                    }
                }
            } while (keepUpdating);
        } while (true);
    }

    /**
     * Menu to delete a Staff member based on a search selection
     */
    private static void deleteStaff() {
        final String HEADING = "DELETE STAFF";
        ArrayList<Staff> searchResult;
        do {
            Staff selection;
            // search for and select a staff member
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
                    options[i] = LibraryUtils.staffListItem(searchResult.get(i));
                }
                selection = searchResult.get(d.showOptions(HEADING, "Choose a staff member:\n", options) - 1);  // take away one to represent the index
            }

            if (d.showConfirm(HEADING, "Are you sure you want to delete the following staff member from the system?\n" + LibraryUtils.staffListItem(selection)) == 0) {
                l.removeStaff(selection);
                d.showMessage(HEADING, "Staff member removed");
            }
        } while (true);
    }

    private static void manageBooks() {
        d.showMessage("MANAGE BOOKS", "Not yet implemented!");
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
    private static void addMember() {
        final String HEADING = "ADD MEMBER";
        d.showMessage(HEADING, "Not yet implemented!");
    }

    private static void displayMember() {
        final String HEADING = "DISPLAY MEMBER";
        d.showMessage(HEADING, "Not yet implemented!");
    }

    private static void updateMember() {
        final String HEADING = "UPDATE MEMBER";
        d.showMessage(HEADING, "Not yet implemented!");
    }

    private static void deleteMember() {
        final String HEADING = "DELETE MEMBER";
        d.showMessage(HEADING, "Not yet implemented!");
    }
}
