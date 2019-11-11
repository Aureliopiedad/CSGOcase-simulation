package Logup;

public class Logup {
    public static long uid = 1;
    private String uname;
    private String upwd;

    public Logup(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
        long id = Logup.uid;
        ++Logup.uid;
    }
    public long getid(){
      return uid;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
