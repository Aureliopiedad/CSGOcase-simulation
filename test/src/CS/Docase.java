package CS;

public class Docase {
    private long userid;
    private int csid;
    public static int count = 0;

    public Docase(long uid, int csid){
        this.userid = uid;
        this.csid = csid;
        count++;
    }

    public int getCount(){return count;}

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
