package Model;

/**
 *
 * @author Wishwa
 */
public interface ReturnBookDAO {

    public ReturnBook validate(int bookcopyId, int memberId);

    public void addReturn(ReturnBook rtnbook);

    public void updateStatus(int bookcopyId);
    
    public int setId();
}
