package utilities;

import entities.Member;
import entities.Staff;

import java.util.ArrayList;

/**
 * This class contains a collection of static utility methods for use by the Library System
 */
public class LibraryUtils {

    /**
     * Create a nice readable representation of an ArrayList of Staff members
     *
     * <p>
     * Uses the staffListItem method to create a nice readable String representation of an ArrayList of Staff members
     * </p>
     *
     * @param staffArrayList the ArrayList of staff members to make a list of
     * @return the String representation of the ArrayList
     */
    public static String orderedStaffList(ArrayList<Staff> staffArrayList) {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < staffArrayList.size(); i++) {
            Staff s = staffArrayList.get(i);
            list.append(i + 1).append(":").append(staffListItem(s));
        }
        return list.toString();
    }

    /**
     * Create a nice readable representation of an ArrayList of Member users
     *
     * <p>
     * Users the memberListItem method to create a nice readable String representation of an ArrayList of Member users
     * </p>
     *
     * @param memberArrayList the ArrayList of member users to make a list of
     * @return the String representation of the ArrayList
     */
    public static String orderedMemberList(ArrayList<Member> memberArrayList) {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < memberArrayList.size(); i++) {
            Member m = memberArrayList.get(i);
            list.append(i + 1).append(":").append(memberListItem(m));
        }
        return list.toString();
    }

    /**
     * Create a nice readable representation of a Staff member
     *
     * <p>
     * This method creates a nice readable String representation of a Staff member for display in the system. It
     * intentionally does not include the password in the output, and the first name and last name are joined to make
     * the full name
     * </p>
     *
     * @param staff the staff member to get the String representation of
     * @return the String representation of the staff member
     */
    public static String staffListItem(Staff staff) {
        return "\t\tID: " + staff.getId() + "\n" +
                "\t\tName: " + staff.getFirstName() + " " + staff.getLastName() + "\n" +
                "\t\tUsername: " + staff.getUserName() + "\n" +
                "\t\tPhone Number: " + staff.getPhone() + "\n" +
                "\t\tEmail: " + staff.getEmail() + "\n";
    }

    /**
     * Create a nice readable representation of a member user
     *
     * <p>
     * This method creates a nice readable String representation of a Member user for display in the system. It
     * intentionally does not include the password in the output, and the first name and last name are joined to make
     * the full name
     * </p>
     *
     * @param member the member user to get the String representation of
     * @return the String representation of the member user
     */
    public static String memberListItem(Member member) {
        return "\t\tID: " + member.getId() + "\n" +
                "\t\tName: " + member.getFirstName() + " " + member.getLastName() + "\n" +
                "\t\tUsername: " + member.getUserName() + "\n" +
                "\t\tPhone Number: " + member.getPhone() + "\n" +
                "\t\tEmail: " + member.getEmail() + "\n";

    }
}
