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
        String password;
        boolean valid = true;
        do {
            password = d.showInput("ADMIN LOGIN", ("Enter password for " + a.getUserName() + ". Leave empty to return to login screen."), !valid);
            if (password.isEmpty()) {
                return false;
            }
            valid = password.equals(a.getPassword());
        } while (!valid);

        return valid;
    }

    private static Staff staffLogin() {
        final String HEADING = "STAFF LOGIN";

        while (true) {
            String username, password;
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

    private static Member memberLogin() {
        final String HEADING = "MEMBER LOGIN";

        while (true) {
            String username, password;
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
        d.showMessage("START ADMIN SESSION", "Not yet implemented!");
    }

    private static void startStaffSession(Staff s) {
        d.showMessage("START STAFF SESSION", "Not yet implemented!");
    }

    private static void startMemberSession(Member m) {
        d.showMessage("START MEMBER SESSION", "Not yet implemented!");
    }
}
