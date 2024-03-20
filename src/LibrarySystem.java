import entities.Admin;
import entities.Library;
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
                    staffLogin();
                    break;
                case 3:
                    memberLogin();
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
            password = d.showInput("ADMIN LOGIN", ("Enter password for " + a.getUserName() + ". Leave empty to return to login screen"), !valid);
            if (password.isEmpty()) {
                return false;
            }
            valid = password.equals(a.getPassword());
        } while (!valid);

        return valid;
    }

    private static void staffLogin() {
        String username;
        boolean valid = true;
        do {
            username = d.showInput("STAFF LOGIN", "Please enter username", !valid);
            ArrayList<Staff> withName = l.getStaffByUserName(username);
            if (withName.isEmpty()) {
                valid = false;
            }
        } while (!valid);
    }

    private static void memberLogin() {

    }

    private static void startAdminSession() {

    }
}
