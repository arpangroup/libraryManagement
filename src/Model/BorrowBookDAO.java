
package Model;

/**
 *
 * @author Wishwa
 */
public interface BorrowBookDAO {
    
    public BorrowBook validate(int bookcopyId,int memberId);
    
    public void addBorrow(BorrowBook borrow);
    
    public void updateStatus(int bookcopyId);

    public int setId();
    
 
    
}
