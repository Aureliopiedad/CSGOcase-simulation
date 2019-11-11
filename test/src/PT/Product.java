package PT;

public class Product{
  //所在的箱子ID
  private int CSID;
  private int PTID;
  //皮肤名+枪名
  private String PTNAME;
  //皮肤稀有度
  private int RAGE;
  private String[] RAGEArray = {"White", "Lightblue", "Darkerblue" ,"Purple",
                "Pinkishpurple", "Red", "ExceedinglyRare"};
  //皮肤磨损程度
  private int WearRAGE;
  private String[] WearRAGEArray = {"Battle-Scarred", "ell-Worn", "Field-Tested",
                "MinimalWear", "FactoryNew"};
  //出现概率
  private Double Probability;

  public void setCSID(int id){
    this.CSID = id;
  }
  public int getCSID(){
    return this.CSID;
  }
  public void setPTID(int id){
    this.PTID = id;
  }
  public int getPTID(){
    return this.PTID;
  }
  public void setName(String name){
    this.PTNAME = name;
  }
  public String getName(){
    return this.PTNAME;
  }
  public void setWearRage(int wearrage){
    this.WearRAGE = wearrage;
  }
  public String getWearRage(){
    return RAGEArray[this.RAGE];
  }
  public void setRage(int rage){
    this.RAGE = rage;
  }
  public String getRage(){
    return WearRAGEArray[this.WearRAGE];
  }
  public void setProbability(Double probability){
    this.Probability = probability;
  }
  public Double getProbability(){
    return this.Probability;
  }
  public Product(int id, String name, int rage, int wearrage, Double probability){
    PTID = id;
    PTNAME = name;
    RAGE = rage;
    WearRAGE = wearrage;
    Probability = probability;
  }

    @Override
    public String toString() {
        return "Product->" + this.PTNAME;
    }
}
