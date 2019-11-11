package User;
import PT.Product;
import java.util.List;
import java.util.ArrayList;

public class user{
  private long UserID;
  private String UserName;
  private String PassWD;
  private List<Product> History = new ArrayList<>();
  private boolean isVIP;

  public user(String name, String passwd, boolean isvip){
    this.UserName = name;
    this.PassWD = passwd;
    this.isVIP = isvip;
  }
  public void addUser(String name, String passwd){
    this.UserName = name;
    this.PassWD = passwd;
  }

  public String getUserName(){
    return this.UserName;
  }
  public String getPasswd(){
    return this.PassWD;
  }
  public void setVIP(boolean isvip){
    this.isVIP = isvip;
  }
  public boolean getVIP(){
    return this.isVIP;
  }
  public void addHistory(Product pro){
    History.add(pro);
  }

  public Product[] getAllHistory(){
    Product[] newHistroy = new Product[this.History.size() - 1];
    for(int i = 0; i < this.History.size(); i++){
      newHistroy[i] = this.History.get(i);
    }
    return newHistroy;
  }
  public void updateUserInfo(String name, String passwd, boolean isvip){
    this.UserName = name;
    this.PassWD = passwd;
    this.isVIP = isvip;
  }

  public long getUserID() {
    return UserID;
  }

  public void setUserID(int userID) {
    UserID = userID;
  }
}

