import entities.Admin;
import entities.Library;
import entities.Member;
import entities.Staff;
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
        d.showMessage("MANAGE STAFF", "Not yet implemented!");
    }

    private static void manageBooks() {
        d.showMessage("MANAGE BOOKS", "Not yet implemented!");
    }

    private static void manageMembers() {
        d.showMessage("MANAGE MEMBERS", "Not yet implemented!");
    }
}
