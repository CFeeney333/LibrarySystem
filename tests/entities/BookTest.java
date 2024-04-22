package entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookTest {

    final Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1234123412345L, 1234, false, true);

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

    @Test
    public void isbnTest() {
        assertEquals(1234123412345L, book.getIsbn());
        book.setIsbn(4567456745678L);
        assertEquals(4567456745678L, book.getIsbn());
    }

    @Test
    public void pagesTest() {
        assertEquals(1234, book.getPages());
        book.setPages(2345);
        assertEquals(2345, book.getPages());
    }

    @Test
    public void illustratedTest() {
        assertFalse(book.isIllustrated());
        book.setIllustrated(true);
        assertTrue(book.isIllustrated());
    }

    @Test
    public void inLibraryTest() {
        assertTrue(book.isInLibrary());
        book.setInLibrary(false);
        assertFalse(book.isInLibrary());
    }
}
