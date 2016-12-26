
package Model;

import java.sql.Date;

/**
 *
 * @author Wishwa
 */
public class ReturnBook {
    
    private int returnId;
    private Date brwDate;
    private Date returnDate;
    
    private int bookcopyId;
    private String bkcName;
    private boolean bkcStatus;
    
    private int memberId;
    private String mbrName;
    private boolean mbrStatus;
    
    private int employeeId;
    private int borrowedMemberId;

    public ReturnBook(){}

    public ReturnBook(int returnId, Date returnDate, int bookcopyId, int memberId, int employeeId) {
        this.returnId = returnId;
        this.returnDate = returnDate;
        this.bookcopyId = bookcopyId;
        this.memberId = memberId;
        this.employeeId = employeeId;
    }

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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

    public Date getBrwDate() {
        return brwDate;
    }

    public void setBrwDate(Date brwDate) {
        this.brwDate = brwDate;
    }

    public String getBkcName() {
        return bkcName;
    }

    public void setBkcName(String bkcName) {
        this.bkcName = bkcName;
    }

    public boolean isBkcStatus() {
        return bkcStatus;
    }

    public void setBkcStatus(boolean bkcStatus) {
        this.bkcStatus = bkcStatus;
    }

    public String getMbrName() {
        return mbrName;
    }

    public void setMbrName(String mbrName) {
        this.mbrName = mbrName;
    }

    public boolean isMbrStatus() {
        return mbrStatus;
    }

    public void setMbrStatus(boolean mbrStatus) {
        this.mbrStatus = mbrStatus;
    }

    public int getBorrowedEmployeeId() {
        return borrowedMemberId;
    }

    public void setBorrowedMemberId(int borrowedMemberId) {
        this.borrowedMemberId = borrowedMemberId;
    }
    
    
}
