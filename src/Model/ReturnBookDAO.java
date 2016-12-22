package Model;

/**
 *
 * @author Wishwa
 */
public interface ReturnBookDAO {

    public void validate(int bookcopyId, int memberId);

    public void addReturn(ReturnBook rtnbook);

    public void updateStatus(int bookcopyId);
    
    public int getRtnId(int bookcopyId, int memberId);

}
