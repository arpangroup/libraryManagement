
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wishwa
 */
public interface BookDAO {


public boolean addBook(Book book);

public Book searchBookById(int bookId);

public ArrayList<Book> searchBookByName(String bookName);

public boolean updateBook(Book book);

public boolean removeBook(int id);

public ArrayList<Book> getAllBooks();

public int setId();
    
}
