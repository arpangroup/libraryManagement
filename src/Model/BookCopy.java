
package Model;

/**
 *
 * @author Wishwa
 */
public class BookCopy {
    
   private int bookcopyId;
   private String bookcopyName;
   private boolean bookcopyStatus;
   private int bookId;

    public BookCopy(int bookcopyId, String bookcopyName, boolean bookcopyStatus, int bookId) {
        this.bookcopyId = bookcopyId;
        this.bookcopyName = bookcopyName;
        this.bookcopyStatus = bookcopyStatus;
        this.bookId = bookId;
    }

    public int getBookcopyId() {
        return bookcopyId;
    }

    public void setBookcopyId(int bookcopyId) {
        this.bookcopyId = bookcopyId;
    }

    public String getBookcopyName() {
        return bookcopyName;
    }

    public void setBookcopyName(String bookcopyName) {
        this.bookcopyName = bookcopyName;
    }

    public boolean isBookcopyStatus() {
        return bookcopyStatus;
    }

    public void setBookcopyStatus(boolean bookcopyStatus) {
        this.bookcopyStatus = bookcopyStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    
}

