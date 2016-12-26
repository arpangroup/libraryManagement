package DataAccess;

import Model.Fine;
import Model.FineDAO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wishwa
 */
public class FinePersistantDAO implements FineDAO {

    int setId = 0;

    @Override
    public List<Fine> fineOnMember(int Id) {

        String sqlFine = "SELECT * FROM Fine,ReturnBook,bookcopy WHERE ReturnBook_returnbookId=ReturnbookId and "
                + "bookcopy_bookcopyId = bookcopyId and Member_memberId=?";
        Connection conFine = null;
        PreparedStatement pstFine = null;
        ResultSet rsFine = null;
        List<Fine> fines = null;

        try {

            conFine = DBconnectionProject.connect();
            pstFine = conFine.prepareStatement(sqlFine);
            pstFine.setInt(1, Id);

            pstFine.executeQuery();

            rsFine = pstFine.executeQuery();
            fines = new ArrayList<>();

            while (rsFine.next()) {
                Fine ff = new Fine();
                ff.setReturnDay(rsFine.getDate("returnbookDate"));
                ff.setOverdueDays(rsFine.getInt("overdueDays"));
                ff.setFineAmount(rsFine.getDouble("overdueFine"));
                ff.setBookcopyName(rsFine.getString("bookcopyname"));
                fines.add(ff);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FineDAO.class.getName()).log(Level.SEVERE, null, ex);
            fines = null;
        } finally {

            try {
                rsFine.close();
                pstFine.close();
                conFine.close();
            } catch (SQLException ex) {
                Logger.getLogger(FineDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return fines;
    }

    @Override
    public void blacklistMember(int id) {
        String sqlBlacklist = "UPDATE member SET memberStatus=? WHERE memberId=?";
        Connection conBlacklist = null;
        PreparedStatement pstBlacklist = null;

        ReturnBookPersistantDAO rbook = new ReturnBookPersistantDAO();

        try {

            conBlacklist = DBconnectionProject.connect();
            pstBlacklist = conBlacklist.prepareStatement(sqlBlacklist);
            pstBlacklist.setBoolean(1, false);
            pstBlacklist.setInt(2, id);
            pstBlacklist.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FineDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                pstBlacklist.close();
                conBlacklist.close();
            } catch (SQLException ex) {
                Logger.getLogger(FineDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override

    public void removeBlacklistMember(int id) {
        String sqlRemoveBlacklist = "UPDATE member SET memberStatus=? WHERE memberId=?";
        Connection RemoveconBlacklist = null;
        PreparedStatement RemovepstBlacklist = null;

        ReturnBookPersistantDAO rbook2 = new ReturnBookPersistantDAO();

        try {

            RemoveconBlacklist = DBconnectionProject.connect();
            RemovepstBlacklist = RemoveconBlacklist.prepareStatement(sqlRemoveBlacklist);
            RemovepstBlacklist.setBoolean(1, true);
            RemovepstBlacklist.setInt(2, id);
            RemovepstBlacklist.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FineDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                RemovepstBlacklist.close();
                RemoveconBlacklist.close();
            } catch (SQLException ex) {
                Logger.getLogger(FineDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void addFine(Fine fine) {

        String sqlAdd = "INSERT INTO fine VALUES(?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        int id = setId();
        System.out.println("check this: overdue days " + fine.getOverdueDays());

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlAdd);
            pst.setInt(1, id);
            pst.setInt(2, fine.getOverdueDays());
            pst.setDouble(3, fine.getFineAmount());
            pst.setInt(4, fine.getReturnId());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Fine.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Fine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int setId() {

        String sqlFine = "SELECT MAX(FineId) FROM Fine";
        Connection conFine = null;
        PreparedStatement pstFine = null;
        ResultSet rsFine = null;

        try {
            conFine = DBconnectionProject.connect();
            pstFine = conFine.prepareStatement(sqlFine);
            rsFine = pstFine.executeQuery();

            if (rsFine.next()) {
                setId = rsFine.getInt(1) + 1;
            }

        } catch (SQLException ex) {
        } finally {
            try {
                rsFine.close();
                pstFine.close();
                conFine.close();

            } catch (SQLException ex) {
                Logger.getLogger(FinePersistantDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
                Logger
                        .getLogger(FinePersistantDAO.class
                                .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setId;
    }

}
