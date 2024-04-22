package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addBook() {
        Library l = new Library("The Library", "X91 A1B2");
        Book b = new Book("The Hobbit", "JRR Tolkien", 123412341234L, 1234);
        l.addBook(b);
        assertEquals(1, l.getAllBooks().size());
    }

    @Test
    void removeBook() {
        Library l = new Library("The Library", "X91 A1B2");
        Book b = new Book("The Hobbit", "JRR Tolkien", 123412341234L, 1234);
        l.addBook(b);
        assertEquals(1, l.getAllBooks().size());
        l.removeBook(b);
        assertTrue(l.getAllBooks().isEmpty());
    }

    @Test
    void getAllBooks() {
        Library l = new Library("The Library", "X91 A1B2");
        Book b = new Book("The Hobbit", "JRR Tolkien", 123412341234L, 1234);
        l.addBook(b);

        Book b1 = new Book("The Lord of the Rings", "JRR Tolkien", 234523452345L, 4321);
        l.addBook(b1);

        ArrayList<Book> allBooks = new ArrayList<>();
        allBooks.add(b);
        allBooks.add(b1);

        // test to see if the arraylist of books is cloned with getAllBooks
        assertTrue(l.getAllBooks().removeAll(allBooks));
        assertFalse(l.getAllBooks().isEmpty());

        l.removeBook(b);
        l.removeBook(b1);
        assertTrue(l.getAllBooks().isEmpty());
    }

    @Test
    void getBookByTitle() {
        Library l = new Library("The Library", "X91 A1B2");
        Book b = new Book("The Hobbit", "JRR Tolkien", 123412341234L, 1234);
        l.addBook(b);
        assertEquals("The Hobbit", l.getBookByTitle("The Hobbit").get(0).getTitle());
    }

    @Test
    void getBookByPages() {
        Library l = new Library("The Library", "X91 A1B2");
        Book b = new Book("The Hobbit", "JRR Tolkien", 123412341234L, 1234);
        l.addBook(b);
        assertTrue(l.getBookByPages(1234).contains(b));
    }
}