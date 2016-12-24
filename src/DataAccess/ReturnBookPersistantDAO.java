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

    private String bkcName = null;
    private String mbrName = null;
    private boolean bkcStatus = false;
    private boolean mbrStatus = false;
    private int rtnId = 0;
    private int empId = 0;
    private Date rtnDate = null;

    public String getBkcName() {
        return bkcName;
    }

    public void setBkcName(String bkcName) {
        this.bkcName = bkcName;
    }

    public String getMbrName() {
        return mbrName;
    }

    public void setMbrName(String mbrName) {
        this.mbrName = mbrName;
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
        return rtnId;
    }

    public void setBrwId(int brwId) {
        this.rtnId = brwId;
    }

    public int getRtnId() {
        return rtnId;
    }

    public void setRtnId(int rtnId) {
        this.rtnId = rtnId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getRtnDate() {
        return rtnDate;
    }

    public void setRtnDate(Date rtnDate) {
        this.rtnDate = rtnDate;
    }

    @Override
    public void validate(int bookcopyId, int memberId) {
        String sql = "SELECT memberName,memberStatus,bookcopyName,bookcopyStatus,Employee_empId,borrowDate from borrow\n"
                + "JOIN bookcopy on borrow.bookcopy_bookcopyId = bookcopy.bookcopyId\n"
                + "JOIN member on borrow.Member_memberId = member.memberId\n"
                + "JOIN employee on borrow.Employee_empId = employee.empId\n"
                + "WHERE bookcopy_bookcopyId = 1 AND Member_memberId = 2";

        String sqlMember = "SELECT memberName,memberStatus FROM member       WHERE memberId=?";
        String sqlBookCopy = "SELECT bookcopyName,bookcopyStatus FROM bookcopy WHERE bookcopyId=?";
        String sqlEmployee = "SELECT Employee_empId FROM borrow,bookcopy WHERE bookcopyId= Bookcopy_bookcopyId and Bookcopy_bookcopyId=? and Member_memberId=? and bookcopyStatus=?";
        String sqlBrwDate = "SELECT borrowDate     FROM borrow,bookcopy WHERE bookcopyId= Bookcopy_bookcopyId and Bookcopy_bookcopyId=? and Member_memberId=? and bookcopyStatus=?";

        Connection conMember = null;
        Connection conBookCopy = null;
        Connection conEmployee = null;
        Connection conBrwDate = null;

        PreparedStatement pstMember = null;
        PreparedStatement pstBookCopy = null;
        PreparedStatement pstEmployee = null;
        PreparedStatement pstBrwdate = null;

        ResultSet rsMember = null;
        ResultSet rsBookCopy = null;
        ResultSet rsEmployee = null;
        ResultSet rsBrwDate = null;

        try {
            conMember = DBconnectionProject.connect();
            conBookCopy = DBconnectionProject.connect();
            conEmployee = DBconnectionProject.connect();
            conBrwDate = DBconnectionProject.connect();

            pstMember = conMember.prepareStatement(sqlMember);
            pstBookCopy = conBookCopy.prepareStatement(sqlBookCopy);
            pstEmployee = conEmployee.prepareStatement(sqlEmployee);
            pstBrwdate = conBrwDate.prepareStatement(sqlBrwDate);

            pstMember.setInt(1, memberId);
            pstBookCopy.setInt(1, bookcopyId);

            pstEmployee.setInt(1, bookcopyId);
            pstEmployee.setInt(2, memberId);
            pstEmployee.setBoolean(3, false);

            pstBrwdate.setInt(1, bookcopyId);
            pstBrwdate.setInt(2, memberId);
            pstBrwdate.setBoolean(3, false);

            rsMember = pstMember.executeQuery();
            rsBookCopy = pstBookCopy.executeQuery();
            rsEmployee = pstEmployee.executeQuery();
            rsBrwDate = pstBrwdate.executeQuery();

            if (rsBookCopy.next()) {
                bkcName = rsBookCopy.getString("bookcopyName");
                bkcStatus = rsBookCopy.getBoolean("bookcopyStatus");
            } else {
                bkcName = null;
                bkcStatus = false;
            }

            if (rsMember.next()) {
                mbrName = rsMember.getString("memberName");
                mbrStatus = rsMember.getBoolean("memberStatus");
            } else {
                mbrName = null;
                mbrStatus = false;
            }

            if (rsBrwDate.next()) {
                rtnDate = rsBrwDate.getDate("borrowDate");
            } else {
                rtnDate = null;
            }

            if (rsEmployee.next()) {
                empId = rsEmployee.getInt("Employee_empId");
            } else {
                empId = 0;
            }

        } catch (SQLException ex) {
            System.out.println("Exception occured");
            ex.printStackTrace();
        } finally {
            try {
                rsMember.close();
                rsBookCopy.close();
                rsEmployee.close();
                rsBrwDate.close();

                pstMember.close();
                pstBookCopy.close();
                pstEmployee.close();
                pstBrwdate.close();

                conMember.close();
                conBookCopy.close();
                conEmployee.close();
                conBrwDate.close();

            } catch (SQLException ex) {
                Logger.getLogger(BookCopyPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(MemberPersistantDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
    public int getRtnId(int bookcopyId, int memberId) {
        String sqlReturn = "SELECT returnbookId FROM returnbook WHERE  Bookcopy_bookcopyId=? and Member_memberId=?";
        Connection conReturn = null;
        PreparedStatement pstReturn = null;
        ResultSet rsReturn = null;

        try {
            conReturn = DBconnectionProject.connect();
            pstReturn = conReturn.prepareStatement(sqlReturn);
            pstReturn.setInt(1, bookcopyId);
            pstReturn.setInt(2, memberId);
            rsReturn = pstReturn.executeQuery();

            if (rsReturn.next()) {
                rtnId = rsReturn.getInt("returnbookId");
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
        return rtnId;
    }

}
