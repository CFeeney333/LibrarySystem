import entities.Library;
import view.CLDisplay;
import view.Display;

public class LibrarySystem {
    public static void main(String[] args) {
        Display d = new CLDisplay();
        Library l = new Library("Luke Wadding Library", "");

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

    }

    private static void memberLogin() {

    }
}
