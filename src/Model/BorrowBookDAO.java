
package Model;

/**
 *
 * @author Wishwa
 */
public interface BorrowBookDAO {
    
    public void validate(int bookcopyId,int memberId);
    
    public void addBorrow(BorrowBook borrow);
    
    public void updateStatus(int bookcopyId);
    
    public int getBrwId(int bookcopyId, int memberId);
    
 
    
}
