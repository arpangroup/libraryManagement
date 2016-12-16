
package Model;

/**
 *
 * @author Wishwa
 */
public class Guarantor {
    
    private int guarantorId;
    private String guarantorName;
    private String guarantorContactNo;
    private String guarantorAddress;
    private String fk_memberId;

    public Guarantor(int guarantorId,String guarantorName,String guarantorContactNo,String guarantorAddress,String fk_memberId){
        this.guarantorId=guarantorId;
        this.guarantorName=guarantorName;
        this.guarantorContactNo=guarantorContactNo;
        this.guarantorAddress=guarantorAddress;
        this.fk_memberId=fk_memberId;
    }

  

    /**
     * @return the guarantorId
     */
    public int getGuarantorId() {
        return guarantorId;
    }

    /**
     * @param guarantorId the guarantorId to set
     */
    public void setGuarantorId(int guarantorId) {
        this.guarantorId = guarantorId;
    }

    /**
     * @return the guarantorName
     */
    public String getGuarantorName() {
        return guarantorName;
    }

    /**
     * @param guarantorName the guarantorName to set
     */
    public void setGuarantorName(String guarantorName) {
        this.guarantorName = guarantorName;
    }

    /**
     * @return the guarantorContactNo
     */
    public String getGuarantorContactNo() {
        return guarantorContactNo;
    }

    /**
     * @param guarantorContactNo the guarantorContactNo to set
     */
    public void setGuarantorContactNo(String guarantorContactNo) {
        this.guarantorContactNo = guarantorContactNo;
    }

    /**
     * @return the guarantorAddress
     */
    public String getGuarantorAddress() {
        return guarantorAddress;
    }

    /**
     * @param guarantorAddress the guarantorAddress to set
     */
    public void setGuarantorAddress(String guarantorAddress) {
        this.guarantorAddress = guarantorAddress;
    }

    /**
     * @return the fk_memberId
     */
    public String getFk_memberId() {
        return fk_memberId;
    }

    /**
     * @param fk_memberId the fk_memberId to set
     */
    public void setFk_memberId(String fk_memberId) {
        this.fk_memberId = fk_memberId;
    }
    
    
    
}
