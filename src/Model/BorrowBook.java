
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
