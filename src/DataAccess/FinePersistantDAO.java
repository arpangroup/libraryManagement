package DataAccess;

import Model.Employee;
import Model.EmployeeDAO;
import Model.FineDAO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wishwa
 */
public class FinePersistantDAO implements FineDAO {

    private Date returnDay;
    private int fineDays;
    private double fineAmount;
    private String bookcopyName;

    public Date getReturnDay() {
        return returnDay;
    }

    public int getFineDays() {
        return fineDays;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public String getBookcopyName() {
        return bookcopyName;
    }

    @Override
    public void fineOnMember(int Id) {
        String sqlFine = "SELECT * FROM Fine,ReturnBook,Bookcopy WHERE ReturnBook_returnbookId=ReturnbookId and Bookcopy_bookcopyId=bookcopyId and Member_memberId=?";
        Connection conFine = null;
        PreparedStatement pstFine = null;
        ResultSet rsFine = null;

        ReturnBookPersistantDAO rbook = new ReturnBookPersistantDAO();

        try {

            conFine = DBconnectionProject.connect();
            pstFine = conFine.prepareStatement(sqlFine);
            pstFine.setInt(1, Id);
            pstFine.executeUpdate();

            rsFine = pstFine.executeQuery();

            while (rsFine.next()) {

                returnDay = rsFine.getDate("returnbookDate");
                fineDays = rsFine.getInt("overdueDays");
                fineAmount = rsFine.getDouble("overdueFine");
                bookcopyName = rsFine.getString("bookcopyname");

            }

        } catch (SQLException ex) {
            Logger.getLogger(FineDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                pstFine.close();
                conFine.close();
            } catch (SQLException ex) {
                Logger.getLogger(FineDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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

}
