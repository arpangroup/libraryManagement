package DataAccess;

import Model.BorrowBookDAO;
import Model.ReturnBook;
import Model.ReturnBookDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wishwa
 */
public class ReturnBookPersistantDAO implements ReturnBookDAO {


    @Override
    public ReturnBook validate(int bookcopyId, int memberId) {

        String sqlMember = "SELECT memberName,memberStatus FROM member       WHERE memberId=?";
        String sqlBookCopy = "SELECT bookcopyName,bookcopyStatus FROM bookcopy WHERE bookcopyId=?";
        String sqlBorrow = "SELECT Employee_empId,borrowDate FROM borrow WHERE Bookcopy_bookcopyId=? and Member_memberId=? and borrow_status=?";

        Connection conMember = null;
        Connection conBookCopy = null;
        Connection conBorrow = null;

        PreparedStatement pstMember = null;
        PreparedStatement pstBookCopy = null;
        PreparedStatement pstBorrow = null;

        ResultSet rsMember = null;
        ResultSet rsBookCopy = null;
        ResultSet rsBorrow = null;
        
        ReturnBook returnBook = new ReturnBook();

        try {
            conMember = DBconnectionProject.connect();
            conBookCopy = DBconnectionProject.connect();
            conBorrow = DBconnectionProject.connect();

            pstMember = conMember.prepareStatement(sqlMember);
            pstBookCopy = conBookCopy.prepareStatement(sqlBookCopy);
            pstBorrow = conBorrow.prepareStatement(sqlBorrow);

            pstMember.setInt(1, memberId);
            pstBookCopy.setInt(1, bookcopyId);

            pstBorrow.setInt(1, bookcopyId);
            pstBorrow.setInt(2, memberId);
            pstBorrow.setBoolean(3, false);

            rsMember = pstMember.executeQuery();
            rsBookCopy = pstBookCopy.executeQuery();
            rsBorrow = pstBorrow.executeQuery();

            if (rsBookCopy.next()) {
                returnBook.setBkcName(rsBookCopy.getString("bookcopyName"));
                returnBook.setBkcStatus(rsBookCopy.getBoolean("bookcopyStatus"));
            } else {
                returnBook.setBkcName(null);
                returnBook.setBkcStatus(false);
            }

            if (rsMember.next()) {
                returnBook.setMbrName(rsMember.getString("memberName"));
                returnBook.setMbrStatus(rsMember.getBoolean("memberStatus"));
            } else {
                returnBook.setMbrName(null);
                returnBook.setMbrStatus(false);
            }

            if (rsBorrow.next()) {
                returnBook.setBrwDate(rsBorrow.getDate("borrowDate"));
                returnBook.setBorrowedMemberId(rsBorrow.getInt("Employee_empId"));
            } else {
                returnBook.setBrwDate(null);
                returnBook.setBorrowedMemberId(0);
            }

        } catch (SQLException ex) {
            System.out.println("Exception occured");
            ex.printStackTrace();
        } finally {
            try {
                rsMember.close();
                rsBookCopy.close();
                rsBorrow.close();

                pstMember.close();
                pstBookCopy.close();
                pstBorrow.close();

                conMember.close();
                conBookCopy.close();
                conBorrow.close();

            } catch (SQLException ex) {
                Logger.getLogger(BookCopyPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(MemberPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnBook;
    }

    @Override
    public void addReturn(ReturnBook rtnbook) {
        String sqlReturn = "INSERT INTO returnbook VALUES(?,CURRENT_DATE,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state = false;

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlReturn);

            pst.setInt(1, rtnbook.getReturnId());
            pst.setInt(2, rtnbook.getBookcopyId());
            pst.setInt(3, rtnbook.getMemberId());
            pst.setInt(4, rtnbook.getEmployeeId());

            pst.executeUpdate();

            state = true;

        } catch (SQLException ex) {
            Logger.getLogger(ReturnBookDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            state = false;

        } finally {

            try {
                pst.close();
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(BorrowBookDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateStatus(int bookcopyId) {
        String sqlUpdate = "UPDATE bookcopy SET bookcopyStatus=? WHERE bookcopyId=?";
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlUpdate);

            pst.setBoolean(1, true);
            pst.setInt(2, bookcopyId);

            pst.executeUpdate();

        } catch (SQLException ex) {

        } finally {

            try {
                pst.close();
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(ReturnBookPersistantDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int setId() {
        int setId = 0;

        String sqlReturn = "SELECT MAX(returnbookId) FROM returnbook";
        Connection conReturn = null;
        PreparedStatement pstReturn = null;
        ResultSet rsReturn = null;

        try {
            conReturn = DBconnectionProject.connect();
            pstReturn = conReturn.prepareStatement(sqlReturn);
            rsReturn = pstReturn.executeQuery();

            if (rsReturn.next()) {
                setId = rsReturn.getInt(1);
            }

        } catch (SQLException ex) {
        } finally {
            try {
                rsReturn.close();
                pstReturn.close();
                conReturn.close();

            } catch (SQLException ex) {
                Logger.getLogger(ReturnBookPersistantDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
                Logger
                        .getLogger(ReturnBookPersistantDAO.class
                                .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setId;
    }

}
