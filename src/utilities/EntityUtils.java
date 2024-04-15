package utilities;

import entities.Staff;

import java.util.ArrayList;

public class EntityUtils {
    public static String listStaff(ArrayList<Staff> staffArrayList) {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < staffArrayList.size(); i++) {
            Staff s = staffArrayList.get(i);
            list.append(i + 1).append(":")
                    .append("\t\tID: ").append(s.getId()).append("\n")
                    .append("\t\tName: ").append(s.getFirstName()).append(" ").append(s.getLastName()).append("\n")
                    .append("\t\tUsername: ").append(s.getUserName()).append("\n")
                    .append("\t\tPhone Number: ").append(s.getPhone()).append("\n")
                    .append("\t\tEmail: ").append(s.getEmail()).append("\n\n");
        }
        return list.toString();
    }
}
