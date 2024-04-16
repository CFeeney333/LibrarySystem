import entities.Admin;
import entities.Library;
import entities.Member;
import entities.Staff;
import utilities.EntityUtils;
import view.CLDisplay;
import view.Display;

import java.util.ArrayList;

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
        boolean loggedIn = true;
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
                    loggedIn = false;
                    break;
            }
        } while (loggedIn);
    }

    private static void manageStaff() {
        do {
            int option = d.showOptions("STAFF MANAGEMENT", "Choose an option", new String[]{
                    "Add Staff User",
                    "Display Staff Users",
                    "Update Staff User",
                    "Delete Staff User",
                    "Back to Main Menu"
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

    private static void updateStaff() {
        d.showMessage("UPDATE STAFF USER", "Not yet implemented!");
    }

    private static void deleteStaff() {
        d.showMessage("DELETE STAFF USER", "Not yet implemented!");
    }

    private static void manageBooks() {
        d.showMessage("MANAGE BOOKS", "Not yet implemented!");
    }

    private static void manageMembers() {
        d.showMessage("MANAGE MEMBERS", "Not yet implemented!");
    }
}
