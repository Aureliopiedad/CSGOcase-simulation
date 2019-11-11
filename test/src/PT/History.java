package PT;

public class History{
  private long userid;
  private int caseid;
  private int ptid;

  public History(long id,int caseid,int ptid){
        userid = id;
        this.caseid = caseid;
        this.ptid = ptid;
  }
    public History(long id){
        userid = id;
    }
  public void setUserid(long id){
    userid = id;
  }
  public long getUserid(){
    return this.userid;
  }
  public void setCaseid(int caseid){
    this.caseid = caseid;
  }
  public int getCaseid(){
    return this.caseid;
  }
  public void setPtid(int ptid){
    this.ptid = ptid;
  }
  public int getPtid(){
    return this.ptid;
  }
}
