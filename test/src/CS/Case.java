package CS;
import PT.Product;
import java.util.ArrayList;
import java.util.List;

public class Case{
  private int CSID;
  //箱子名称
  private String NAME;
  //这个箱子中的物品
  private List<Product> products = new ArrayList<>();
  //开箱次数
  private int count;

  public void setID(int id){
    this.CSID = id;
  }
  public int getID(){
    return this.CSID;
  }
  public void setName(String name){
    this.NAME = name;
  }
  public String getName(){
    return this.NAME;
  }
  public void addProducts(Product product){
    products.add(product);
  }
  public Product[] getAllProducts(){
    Product[] newproduct = new Product[products.size() - 1];
    for(int i = 0; i < products.size(); i ++){
      newproduct[i] = products.get(i);
    }
    return newproduct;
  }
  public void setCount(){
    count++;
  }
  public int getCount(){
    return count;
  }
}
