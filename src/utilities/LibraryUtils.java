package utilities;

import entities.Member;
import entities.Staff;
import entities.User;

import java.util.ArrayList;

/**
 * This class contains a collection of static utility methods for use by the Library System
 */
public class LibraryUtils {

    /**
     * Create a nice readable representation of an ArrayList of users
     *
     * <p>
     * Uses the userListItem method to create a nice readable String representation of an ArrayList of Users
     * </p>
     *
     * @param userArrayList the arrayList of objects that extend the User class
     * @param <T>           the user abstract class
     * @return a String list of readable Users
     */
    public static <T extends User> String orderedUserList(ArrayList<T> userArrayList) {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < userArrayList.size(); i++) {
            T u = userArrayList.get(i);
            list.append(i + 1).append(":").append(userListItem(u));
        }
        return list.toString();
    }

    /**
     * Create a nice readable representation of a user
     *
     * <p>
     * This method creates a nice readable String representation of any user for display in the system. It
     * intentionally does not include the password in the output, and the first name and last name are joined to make
     * the full name
     * </p>
     *
     * @param user the user to get the representation of
     * @param <T>  any class the extends the User abstract class, e.g. Member, Staff
     * @return a String representation of the User
     */
    public static <T extends User> String userListItem(T user) {
        return "\t\tID: " + user.getId() + "\n" + "\t\tName: " + user.getFirstName() + " " + user.getLastName() + "\n" + "\t\tUsername: " + user.getUserName() + "\n" + "\t\tPhone Number: " + user.getPhone() + "\n" + "\t\tEmail: " + user.getEmail() + "\n";
    }
}
