import entities.Book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookTest {

    Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1234123412345L, 1234, false, true);

    // Test constructors
    @Test
    public void constructor1Test() {
        Book b = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1234123412345L, 1234, true, false);
        assertEquals("The Lord of the Rings", b.getTitle());
        assertEquals("J.R.R. Tolkien", b.getAuthor());
        assertEquals(1234123412345L, b.getIsbn());
        assertEquals(1234, b.getPages());
        assertTrue(b.isIllustrated());
        assertFalse(b.isInLibrary());
    }

    @Test
    public void constructor2Test() {
        Book b = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1234123412345L, 1234, false);
        assertEquals("The Lord of the Rings", b.getTitle());
        assertEquals("J.R.R. Tolkien", b.getAuthor());
        assertEquals(1234123412345L, b.getIsbn());
        assertEquals(1234, b.getPages());
        assertFalse(b.isIllustrated());
        assertTrue(b.isInLibrary());
    }

    @Test
    public void constructor3Test() {
        Book b = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1234123412345L, 1234);
        assertEquals("The Lord of the Rings", b.getTitle());
        assertEquals("J.R.R. Tolkien", b.getAuthor());
        assertEquals(1234123412345L, b.getIsbn());
        assertEquals(1234, b.getPages());
        assertFalse(b.isIllustrated());
        assertTrue(b.isInLibrary());
    }

    @Test
    public void titleTest() {
        assertEquals("The Lord of the Rings", book.getTitle());
        book.setTitle("The Hobbit");
        assertEquals("The Hobbit", book.getTitle());
    }

    // TODO 1/3/24: Add more tests
}
