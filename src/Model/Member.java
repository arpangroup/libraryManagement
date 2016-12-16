
package Model;

/**
 *
 * @author Wishwa
 */
public class Member {
    
    private int memberId;
    private String memberName;
    private String memberContactNo;
    private String memberAddress;

    public Member(int memberId,String memberName,String memberContactNo,String memberaddress){
        this.memberId=memberId;
        this.memberName=memberName;
        this.memberContactNo=memberContactNo;
        this.memberAddress=memberaddress;
    }
    
    
    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the memberContactNo
     */
    public String getMemberContactNo() {
        return memberContactNo;
    }

    /**
     * @param memberContactNo the memberContactNo to set
     */
    public void setMemberContactNo(String memberContactNo) {
        this.memberContactNo = memberContactNo;
    }

    /**
     * @return the memberAddress
     */
    public String getMemberAddress() {
        return memberAddress;
    }

    /**
     * @param memberAddress the memberAddress to set
     */
    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }
    
  
    
    
}
