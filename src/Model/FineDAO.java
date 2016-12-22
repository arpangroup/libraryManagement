package Model;

/**
 *
 * @author Wishwa
 */
public interface FineDAO {

    public void fineOnMember(int Id);
    
    public void blacklistMember(int id);
    
     public void removeBlacklistMember(int id);
    
}
