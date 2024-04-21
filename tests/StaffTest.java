import entities.Staff;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StaffTest {
    final Staff s = new Staff(12341234L, "Cathal", "Feeney", "CFeeney", "asdfasdf", "089 123 4567", "cfeeney@gmail.com");

    // Test constructors
    @Test
    public void constructorTest() {
        Staff s1 = new Staff(12341234L, "Cathal", "Feeney", "CFeeney", "asdfasdf", "089 123 4567", "cfeeney@gmail.com");
        assertEquals(1234124L, s1.getId());
        assertEquals("Cathal", s1.getFirstName());
        assertEquals("Feeney", s1.getLastName());
        assertEquals("CFeeney", s1.getUserName());
        assertEquals("asdfasdf", s1.getPassword());
        assertEquals("089 123 4567", s1.getPhone());
        assertEquals("cfeeney@gmail.com", s1.getEmail());
    }

    // Test getters and setters
    @Test
    public void getIdTest() {
        assertEquals(12341234L, s.getId());
    }

    @Test
    public void getFirstNameTest() {
        assertEquals("Cathal", s.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        assertEquals("Feeney", s.getLastName());
    }

    @Test
    public void getUserNameTest() {
        assertEquals("CFeeney", s.getUserName());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("asdfasdf", s.getPassword());
    }

    @Test
    public void getPhoneTest() {
        assertEquals("089 123 4567", s.getPhone());
    }

    @Test
    public void getEmailTest() {
        assertEquals("cfeeney@gmail.com", s.getEmail());
    }

    @Test
    public void setIdTest() {
        s.setId(234523452345L);
        assertEquals(234523452345L, s.getId());
    }

    @Test
    public void setFirstNameTest() {
        s.setFirstName("Phil");
        assertEquals("Phil", s.getFirstName());
    }

    @Test
    public void setLastNameTest() {
        s.setLastName("Murphy");
        assertEquals("Murphy", s.getLastName());
    }

    @Test
    public void setUserNameTest() {
        s.setUserName("PMurphy");
        assertEquals("PMurphy", s.getUserName());
    }

    @Test
    public void setPasswordTest() {
        s.setPassword("password");
        assertEquals("password", s.getPassword());
    }

    @Test
    public void setPhoneTest() {
        s.setPhone("086 987 6543");
        assertEquals("086 987 6543", s.getPhone());
    }

    @Test
    public void setEmailTest() {
        s.setEmail("pmurphy@gmail.com");
        assertEquals("pmurphy@gmail.com", s.getEmail());
    }
}
