package utilities;

import entities.Staff;

import java.util.ArrayList;

public class LibraryUtils {
    public static String orderedStaffList(ArrayList<Staff> staffArrayList) {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < staffArrayList.size(); i++) {
            Staff s = staffArrayList.get(i);
            list.append(i + 1).append(":").append(staffListItem(s));
        }
        return list.toString();
    }

    public static String staffListItem(Staff staff) {
        return "\t\tID: " + staff.getId() + "\n" +
                "\t\tName: " + staff.getFirstName() + " " + staff.getLastName() + "\n" +
                "\t\tUsername: " + staff.getUserName() + "\n" +
                "\t\tPhone Number: " + staff.getPhone() + "\n" +
                "\t\tEmail: " + staff.getEmail() + "\n";
    }
}
