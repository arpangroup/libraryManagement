package Model;

import java.util.List;

/**
 *
 * @author Wishwa
 */
public interface FineDAO {

    public List<Fine> fineOnMember(int Id);

    public void blacklistMember(int id);

    public void removeBlacklistMember(int id);
    
    public void addFine(Fine fine);
    
     public int setId();

}
