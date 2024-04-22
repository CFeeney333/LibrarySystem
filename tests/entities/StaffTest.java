package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaffTest {
    final Staff s = new Staff(123412341234L, "Cathal", "Feeney", "CFeeney", "asdfasdf", "089 123 4567", "cfeeney@gmail.com");

    @Test
    void testStaff() {
        Staff s1 = new Staff(123412341234L, "Cathal", "Feeney", "CFeeney", "asdfasdf", "089 123 4567", "cfeeney@gmail.com");
        assertEquals(123412341234L, s1.getId());
        assertEquals("Cathal", s1.getFirstName());
        assertEquals("Feeney", s1.getLastName());
        assertEquals("CFeeney", s1.getUserName());
        assertEquals("asdfasdf", s1.getPassword());
        assertEquals("089 123 4567", s1.getPhone());
        assertEquals("cfeeney@gmail.com", s1.getEmail());
    }

    @Test
    void testGetId() {
        assertEquals(123412341234L, s.getId());
    }

    @Test
    void testSetId() {
        s.setId(987698769867L);
        assertEquals(987698769867L, s.getId());
    }

    @Test
    void testGetFirstName() {
        assertEquals("Cathal", s.getFirstName());
    }

    @Test
    void testSetFirstName() {
        s.setFirstName("Jim");
        assertEquals("Jim", s.getFirstName());
    }

    @Test
    void testGetLastName() {
        assertEquals("Feeney", s.getLastName());
    }

    @Test
    void testSetLastName() {
        s.setLastName("Murphy");
        assertEquals("Murphy", s.getLastName());
    }

    @Test
    void testGetPhone() {
        assertEquals("089 123 4567", s.getPhone());
    }

    @Test
    void testSetPhone() {
        s.setPhone("086 987 6543");
        assertEquals("086 987 6543", s.getPhone());
    }

    @Test
    void testGetEmail() {
        assertEquals("cfeeney@gmail.com", s.getEmail());
    }

    @Test
    void testSetEmail() {
        s.setEmail("jmurphy@gmail.com");
        assertEquals("jmurphy@gmail.com", s.getEmail());
    }

    @Test
    void testGetUserName() {
        assertEquals("CFeeney", s.getUserName());
    }

    @Test
    void testSetUserName() {
        s.setUserName("JMurphy");
        assertEquals("JMurphy", s.getUserName());
    }

    @Test
    void testGetPassword() {
        assertEquals("asdfasdf", s.getPassword());
    }

    @Test
    void testSetPassword() {
        s.setPassword("password");
        assertEquals("password", s.getPassword());
    }
}