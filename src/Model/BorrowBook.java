package Model;

import java.sql.Date;

/**
 *
 * @author Wishwa
 */
public class BorrowBook {

    private int borrowId;
    private Date addDate;
    private int bookcopyId;
    private int memberId;
    private int employeeId;

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
        return brwId;
    }

    public void setBrwId(int brwId) {
        this.brwId = brwId;
    }
    
      public BorrowBook(){}
    
    

    public BorrowBook(int borrowId, Date addDate, int bookcopyId, int memberId, int employeeId) {
        this.borrowId = borrowId;
        this.addDate = addDate;
        this.bookcopyId = bookcopyId;
        this.memberId = memberId;
        this.employeeId = employeeId;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public int getBookcopyId() {
        return bookcopyId;
    }

    public void setBookcopyId(int bookcopyId) {
        this.bookcopyId = bookcopyId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
