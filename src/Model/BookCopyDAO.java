package Model;

import java.util.ArrayList;

/**
 *
 * @author Wishwa
 */
public interface BookCopyDAO {

    public boolean addBookCopy(BookCopy bookcopy);
    
    public boolean updateBookCopy(BookCopy bookcopy);
    
    public boolean removeBookCopy(int Id);

    public BookCopy searchBookCopyById(int bookId);

    public ArrayList<BookCopy> searchBookCopyByName(String bookName);

    public int setId();

}
