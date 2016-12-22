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

    private String bkcName;
    private String mbrName;
    private boolean bkcStatus;
    private boolean mbrStatus;
    private int brwId;

    public String getBkcName() {
        return bkcName;
    }

    public void setBkcName(String bkcName) {
        this.bkcName = bkcName;
    }

    public String getMbrName() {
        return mbrName;
    }

    public boolean isBkcStatus() {
        return bkcStatus;
    }

    public void setBkcStatus(boolean bkcStatus) {
        this.bkcStatus = bkcStatus;
    }

    public boolean isMbrStatus() {
        return mbrStatus;
    }

    public void setMbrStatus(boolean mbrStatus) {
        this.mbrStatus = mbrStatus;
    }

    public int getBrwId() {
        return brwId;
    }

    public void setBrwId(int brwId) {
        this.brwId = brwId;
    }
    

    @Override
    public void validate(int bookcopyId, int memberId) {
        String sqlMember = "SELECT memberName,memberStatus FROM member WHERE memberId=?";
        String sqlBookCopy = "SELECT bookcopyName,bookcopyStatus FROM bookcopy WHERE bookcopyId=?";
        Connection conMember = null;
        Connection conBookCopy = null;
        PreparedStatement pstMember = null;
        PreparedStatement pstBookCopy = null;
        ResultSet rsMember = null;
        ResultSet rsBookCopy = null;
        boolean state = false;

        try {
            conMember = DBconnectionProject.connect();
            conBookCopy = DBconnectionProject.connect();
            pstMember = conMember.prepareStatement(sqlMember);
            pstBookCopy = conBookCopy.prepareStatement(sqlBookCopy);
            pstMember.setInt(1, memberId);
            pstBookCopy.setInt(1, bookcopyId);
            rsMember = pstMember.executeQuery();
            rsBookCopy = pstBookCopy.executeQuery();

            if (rsBookCopy.next() && rsMember.next()) {
                bkcName = rsBookCopy.getString("bookcopyName");
                bkcStatus = rsBookCopy.getBoolean("bookcopyStatus");
                mbrName = rsMember.getString("memberName");
                mbrStatus = rsMember.getBoolean("memberStatus");
                state = true;
               

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
        // return state;

    }

    @Override
    public void addBorrow(BorrowBook borrow) {
        String sqlBorrow = "INSERT INTO borrow VALUES(?,CURRENT_DATE,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        boolean state = false;

        try {

            con = DBconnectionProject.connect();
            pst = con.prepareStatement(sqlBorrow);

            pst.setInt(1, borrow.getBorrowId());
            pst.setInt(2, borrow.getBookcopyId());
            pst.setInt(3, borrow.getMemberId());
            pst.setInt(4, borrow.getEmployeeId());

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
    public int getBrwId(int bookcopyId, int memberId) {
        
        String sqlBorrow = "SELECT borrowId FROM borrow ,member ,bookcopy WHERE  bookcopyId=? and memberId=? and member.memberId=member_memberId and bookcopy.bookcopyId=bookcopy_bookcopyId";
        Connection conBorrow = null;
        PreparedStatement pstBorrow = null;
        ResultSet rsBorrow = null;
       // boolean state = false;
        
          try {
            conBorrow = DBconnectionProject.connect();
            pstBorrow = conBorrow.prepareStatement(sqlBorrow);
            pstBorrow.setInt(1, bookcopyId);
            pstBorrow.setInt(2, memberId);
            rsBorrow = pstBorrow.executeQuery();

            if (rsBorrow.next()) {
                brwId = rsBorrow.getInt("borrowId");
                System.out.println(brwId);
               
               // state = true;
         
            }

        } catch (SQLException ex) {
        } finally {
            try {
                rsBorrow.close();
                pstBorrow.close();
                conBorrow.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookCopyPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(MemberPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           return brwId;
    }
    
    
    
}
