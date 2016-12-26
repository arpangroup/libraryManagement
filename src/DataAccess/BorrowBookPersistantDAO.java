package DataAccess;

import Model.BorrowBook;
import Model.BorrowBookDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wishwa
 */
public class BorrowBookPersistantDAO implements BorrowBookDAO {

    @Override
    public BorrowBook validate(int bookcopyId, int memberId) {
        
        String sqlMember = "SELECT memberName,memberStatus FROM member WHERE memberId=?";
        String sqlBookCopy = "SELECT bookcopyName,bookcopyStatus FROM bookcopy WHERE bookcopyId=?";
        Connection conMember = null;
        Connection conBookCopy = null;
        PreparedStatement pstMember = null;
        PreparedStatement pstBookCopy = null;
        ResultSet rsMember = null;
        ResultSet rsBookCopy = null;
        boolean state = false;

        BorrowBook brbook = new BorrowBook();

        try {
            conMember = DBconnectionProject.connect();
            conBookCopy = DBconnectionProject.connect();
            pstMember = conMember.prepareStatement(sqlMember);
            pstBookCopy = conBookCopy.prepareStatement(sqlBookCopy);
            pstMember.setInt(1, memberId);
            pstBookCopy.setInt(1, bookcopyId);
            rsMember = pstMember.executeQuery();
            rsBookCopy = pstBookCopy.executeQuery();

            if (rsBookCopy.next()) {
                brbook.setBkcName(rsBookCopy.getString("bookcopyName"));
                brbook.setBkcStatus(rsBookCopy.getBoolean("bookcopyStatus"));

            } else {
                brbook.setBkcName(null);
                brbook.setBkcStatus(false);
            }
            if (rsMember.next()) {
                brbook.setMbrName(rsMember.getString("memberName"));
                brbook.setMbrStatus(rsMember.getBoolean("memberStatus"));
            } else {
                 brbook.setMbrName(null);
                brbook.setMbrStatus(false);
            }

        } catch (SQLException ex) {
        } finally {
            try {
                rsMember.close();
                rsBookCopy.close();
                pstMember.close();
                pstBookCopy.close();
                conMember.close();
                conBookCopy.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookCopyPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(MemberPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         return brbook;

    }

    @Override
    public void addBorrow(BorrowBook borrow) {
        String sqlBorrow = "INSERT INTO borrow VALUES(?,CURRENT_DATE,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state = false;

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlBorrow);

            pst.setInt(1, borrow.getBorrowId());
            pst.setInt(2, borrow.getMemberId());
            pst.setInt(3, borrow.getEmployeeId());
            pst.setInt(4, borrow.getBookcopyId());
            pst.setBoolean(5, false);

            pst.executeUpdate();

            state = true;

        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookDAO.class.getName()).log(Level.SEVERE, null, ex);
            state = false;

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BorrowBookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // return state;
    }

    @Override
    public void updateStatus(int bookcopyId) {
        String sqlUpdate = "UPDATE bookcopy SET bookcopyStatus=? WHERE bookcopyId=?";
        String sqlUpdate2 = "UPDATE borrow SET bookcopyStatus=? WHERE bookcopyId=?";
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);

            pst.setBoolean(1, false);
            pst.setInt(2, bookcopyId);

            pst.executeUpdate();

        } catch (SQLException ex) {

        } finally {

            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BorrowBookPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int setId() {
        int setId = 0;

        String sqlBorrow = "SELECT MAX(borrowId) FROM borrow";
        Connection conBorrow = null;
        PreparedStatement pstBorrow = null;
        ResultSet rsBorrow = null;

        try {
            conBorrow = DBconnectionProject.connect();
            pstBorrow = conBorrow.prepareStatement(sqlBorrow);
            rsBorrow = pstBorrow.executeQuery();

            if (rsBorrow.next()) {
                setId = rsBorrow.getInt(1);
            }

        } catch (SQLException ex) {
        } finally {
            try {
                rsBorrow.close();
                pstBorrow.close();
                conBorrow.close();

            } catch (SQLException ex) {
                Logger.getLogger(BorrowBookPersistantDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
                Logger
                        .getLogger(BorrowBookPersistantDAO.class
                                .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setId;
    }

}
