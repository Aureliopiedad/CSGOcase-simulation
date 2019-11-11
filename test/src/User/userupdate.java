package User;

public class userupdate {
    private long UserID;
    private String UserName;
    private String PassWD;
    private boolean isVIP;

    public userupdate(long id, String userName, String passWD, boolean isvip){
        UserID = id;
        UserName = userName;
        PassWD = passWD;
        isVIP = isvip;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWD() {
        return PassWD;
    }

    public void setPassWD(String passWD) {
        PassWD = passWD;
    }
    public void setvip(boolean isvip){
      isVIP = isvip;
    }
    public boolean getvip(){
      return isVIP;
    }

    public long getUserID() {
        return UserID;
    }

    public void setUserID(long userID) {
        UserID = userID;
    }
}
