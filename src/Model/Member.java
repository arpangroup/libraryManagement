
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
    private boolean memberStatus;
  

    public Member(int memberId, String memberName, String memberContactNo, String memberAddress, boolean memberStatus) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberContactNo = memberContactNo;
        this.memberAddress = memberAddress;
        this.memberStatus = memberStatus;
    
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberContactNo() {
        return memberContactNo;
    }

    public void setMemberContactNo(String memberContactNo) {
        this.memberContactNo = memberContactNo;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public boolean isMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(boolean memberStatus) {
        this.memberStatus = memberStatus;
    }


}
