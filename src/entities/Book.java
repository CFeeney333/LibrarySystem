package entities;

/**
 * Book class for managing books in a library
 * <p>
 * A book defines an author, an isbn, the amount of pages, whether the book is illustrated or not, and whether
 * the book is currently in the library i.e. whether someone has taken the book out or not.
 */
public class Book {

    /**
     * The title of the book
     */
    private String title;
    /**
     * The author of the book
     */
    private String author;
    /**
     * The 13-digit ISBN of the book
     */
    private long isbn;
    /**
     * The pages in the book
     */
    private int pages;
    /**
     * Whether the book is illustrated
     */
    private boolean isIllustrated;
    /**
     * Whether the book is in the library
     */
    private boolean inLibrary;


    /**
     * Create a book object
     *
     * @param title         the title of the book as it appears on the cover
     * @param author        the author of the book as it appears on the cover
     * @param isbn          the 13-digit ISBN of the book
     * @param pages         the amount of pages in the book
     * @param isIllustrated whether the book is illustrated
     * @param inLibrary     whether the book is in the library i.e. not taken out on loan
     */
    public Book(String title, String author, long isbn, int pages, boolean isIllustrated, boolean inLibrary) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.isIllustrated = isIllustrated;
        this.inLibrary = inLibrary;
    }

    /**
     * Create a book object
     * <p>
     * The flag saying that the book is in the library is set to true by default
     * </p>
     *
     * @param title         the title of the book as it appears on the cover
     * @param author        the author of the book as it appears on the cover
     * @param isbn          the 13-digit ISBN of the book
     * @param pages         the amount of pages in the book
     * @param isIllustrated whether the book is illustrated
     */
    public Book(String title, String author, long isbn, int pages, boolean isIllustrated) {
        this(title, author, isbn, pages, isIllustrated, true);
    }

    /**
     * Create a book object
     * <p>
     * The flag saying the book is in the library is set to true by default
     * The flag saying whether the book is illustrated is set to false be default
     * </p>
     *
     * @param title  the title of the book as it appears on the cover
     * @param author the author of the book as it appears on the cover
     * @param isbn   the 13-digit ISBN of the book
     * @param pages  the amount of pages in the book
     */
    public Book(String title, String author, long isbn, int pages) {
        this(title, author, isbn, pages, false);
    }


    /**
     * Get the title of the book
     * @return the title as it appears on the cover of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the book
     * @param title the title as it appears on the cover of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the author of the book
     *
     * @return the author as it appears on the cover of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set the author of the book
     *
     * @param author the author as it appears on the cover of the book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get the isbn of the book
     *
     * @return the 13-digit ISBN of the book
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * Set the isbn of the book
     *
     * @param isbn the 13-digit ISBN of the book
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    /**
     * Get the amount of pages in the book
     *
     * @return the page count
     */
    public int getPages() {
        return pages;
    }

    /**
     * Set the amount of pages in the book
     *
     * @param pages the page count
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Is the book illustrated?
     *
     * @return true if the book is illustrated
     */
    public boolean isIllustrated() {
        return isIllustrated;
    }

    /**
     * Set whether the book is illustrated
     *
     * @param illustrated true if the book is illustrated
     */
    public void setIllustrated(boolean illustrated) {
        isIllustrated = illustrated;
    }

    /**
     * Is the book in the library?
     *
     * @return true if the book is in the library
     */
    public boolean isInLibrary() {
        return inLibrary;
    }

    /**
     * Set whether the book is in the library
     *
     * @param inLibrary true if the book is in the library
     */
    public void setInLibrary(boolean inLibrary) {
        this.inLibrary = inLibrary;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = super.clone();
        return new Book(title, author, isbn, pages, isIllustrated, inLibrary);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", pages=" + pages +
                ", isIllustrated=" + isIllustrated +
                ", inLibrary=" + inLibrary +
                '}';
    }
}
