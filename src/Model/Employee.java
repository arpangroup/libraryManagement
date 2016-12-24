
package Model;

public class Employee {
    
    private int userId;
    private String userName;
    private int userContactNo;
    private String userAddress;
    private String username;
    private String userPassword;
    private String userAccess;

 
    public Employee(int userId, String userName,int userContactNo, String userAddress, String username,String userPassword, String userAccess ){
                this.userId=userId;
                this.userName=userName;
                this.userContactNo=userContactNo;
                this.userAddress=userAddress;
                this.username=username;
                this.userPassword=userPassword;
                this.userAccess=userAccess;
         }
    
    


    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userContactNo
     */
    public int getUserContactNo() {
        return userContactNo;
    }

    /**
     * @param userContactNo the userContactNo to set
     */
    public void setUserContactNo(int userContactNo) {
        this.userContactNo = userContactNo;
    }

    /**
     * @return the userAddress
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * @param userAddress the userAddress to set
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the userAccess
     */
    public String getUserAccess() {
        return userAccess;
    }

    /**
     * @param userAccess the userAccess to set
     */
    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }


}  
  