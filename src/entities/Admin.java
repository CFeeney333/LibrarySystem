package entities;

/**
 * An Admin controls the staff in the library
 *
 * <p>
 * An Admin has control over creating, reading, updating, and deleting staff users from the system.
 * There should always be one and only one admin on the system, created or loaded at startup
 * </p>
 */
public class Admin extends BasicUser {

    /**
     * Create a Basic User of a library system
     * <p>
     * A Basic User is someone with a username and password. Password may not be an empty string.
     * </p>
     *
     * @param userName the user's display and login name
     * @param password the user's password
     */
    public Admin(String userName, String password) {
        super(userName, password);
    }
}
