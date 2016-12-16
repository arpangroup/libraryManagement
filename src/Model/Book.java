
package Model;

import java.sql.Date;
/**
 *
 * @author Wishwa
 */
public class Book {

    private String bookId;
    private String bookName;
     private String isbn;
    private String author;
    private String publisher;
    private int noBooksAvailable;
    private String language;
    private Date addDate;

    public Book(String bookId, String bookName, String isbn, String author, String publisher, int noBooksAvailable, String language,Date addDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.noBooksAvailable = noBooksAvailable;
        this.language = language;
        this.addDate = addDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNoBooksAvailable() {
        return noBooksAvailable;
    }

    public void setNoBooksAvailable(int noBooksAvailable) {
        this.noBooksAvailable = noBooksAvailable;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


}