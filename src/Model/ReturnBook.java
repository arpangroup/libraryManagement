
package Model;

import java.util.Date;

/**
 *
 * @author Wishwa
 */
public class ReturnBook {
    
    private int returnId;
    private Date returnDate;
    private int bookcopyId;
    private int memberId;
    private int employeeId;

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
    
    
    
}
