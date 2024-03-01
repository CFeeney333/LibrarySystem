import entities.Book;
import entities.Library;
import entities.Member;
import entities.Staff;
import utilities.IO;

public class LibrarySystem {
    public static void main(String[] args) {
        Book b = new Book("The Lord of the Rings", "J.R.R. Tolkien", 124123412341L, 1234, true, true);
        IO.printLine(b.toString());
        Staff s = new Staff(98709870987L, "Mary", "Murphy", "abcd1234", "08912345678", "m.murphy@lib.ie");
        IO.printLine(s.toString());
        Member m = new Member(253647586L, "Jim", "Whelan", "messithegoat", "0874564567", "j.whelan@gmail.com");
        IO.printLine(m.toString());

        Library l = new Library("Luke Wadding", "XYZ 1234");
        IO.printLine(l.toString());
        l.addBook(b);
        l.addStaff(s);
        l.addMember(m);
        IO.printLine(l.toString());
    }
}
