
package Model;

/**
 *
 * @author Wishwa
 */
public class Fine {
    
    private int fineId;
    private int overdueDays;
    private double fineAmount;
    private int returnId;

    public Fine(int fineId, int overdueDays, double fineAmount, int returnId) {
        this.fineId = fineId;
        this.overdueDays = overdueDays;
        this.fineAmount = fineAmount;
        this.returnId = returnId;
    }

    public int getFineId() {
        return fineId;
    }

    public void setFineId(int fineId) {
        this.fineId = fineId;
    }

    public int getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        this.overdueDays = overdueDays;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }
    
    
    
    
    
}
