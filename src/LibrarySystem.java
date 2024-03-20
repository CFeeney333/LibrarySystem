import entities.Library;
import entities.Staff;
import view.CLDisplay;
import view.Display;

import java.util.ArrayList;

public class LibrarySystem {
    private static final Display d = new CLDisplay();
    private static final Library l = new Library("Luke Wadding Library", "");

    public static void main(String[] args) {
        // Add placeholder staff user
        l.addStaff(new Staff(1111, "Tom", "Dwyer", "tdwyer", "pwd", "089 123 4567", "t.dwyer@lib.ie"));

        d.showMessage("LIBRARY MANAGEMENT SYSTEM",
                """
                        Welcome to the Library Management System!
                                                
                        Here, you can create Staff, Members and Books, and add them to the system.
                        You can view, update and delete the objects""");

        int option = d.showOptions("LIBRARY MANAGEMENT SYSTEM", "Log In", new String[] {
                "Staff Login",
                "Member Login"
        });

        switch (option) {
            case 1:
                staffLogin();
                break;
            case 2:
                memberLogin();
                break;
        }
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
}
