
package Model;

/**
 *
 * @author Wishwa
 */
public class Guaranter {
    
    private int guaranterId;
    private String guaranterName;
    private String guaranterContactNo;
    private String guaranterAddress;
    private String fk_memberId;

    public Guaranter(int guaranterId,String guaranterName,String guaranterContactNo,String guaranterAddress,String fk_memberId){
        this.guaranterId=guaranterId;
        this.guaranterName=guaranterName;
        this.guaranterContactNo=guaranterContactNo;
        this.guaranterAddress=guaranterAddress;
        this.fk_memberId=fk_memberId;
    }

  

    /**
     * @return the guarantorId
     */
    public int getGuaranterId() {
        return guaranterId;
    }

    /**
     * @param guarantorId the guarantorId to set
     */
    public void setGuaranterId(int guarantorId) {
        this.guaranterId = guarantorId;
    }

    /**
     * @return the guarantorName
     */
    public String getGuaranterName() {
        return guaranterName;
    }

    /**
     * @param guarantorName the guarantorName to set
     */
    public void setGuaranterName(String guarantorName) {
        this.guaranterName = guarantorName;
    }

    /**
     * @return the guarantorContactNo
     */
    public String getGuaranterContactNo() {
        return guaranterContactNo;
    }

    /**
     * @param guarantorContactNo the guarantorContactNo to set
     */
    public void setGuaranterContactNo(String guarantorContactNo) {
        this.guaranterContactNo = guarantorContactNo;
    }

    /**
     * @return the guarantorAddress
     */
    public String getGuaranterAddress() {
        return guaranterAddress;
    }

    /**
     * @param guarantorAddress the guarantorAddress to set
     */
    public void setGuaranterAddress(String guarantorAddress) {
        this.guaranterAddress = guarantorAddress;
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
