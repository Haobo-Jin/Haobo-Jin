public class Goods {
    private int id;
    private String goodsName;
    private String goodsStyle;
    private int goodPrice;
    private int goodsNumber;
    private String storageID;
    private String state;
    private String holder;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGoodsname() {
        return goodsName;
    }
    public void setGoodsname(String goodsname) {
        this.goodsName = goodsname;
    }
    public String getGoodsstyle() {
        return goodsStyle;
    }
    public void setGoodsstyle(String goodsstyle) {
        this.goodsStyle = goodsstyle;
    }
    public int getGoodsnumber() {
        return goodsNumber;
    }
    public void setGoodsnumber(int goodsnumber) {
        this.goodsNumber = goodsnumber;
    }
    public String getStorageID() { return storageID; }
    public void setHolder(String holder) { this.holder = holder; }
    public void setState(String state) { this.state = state; }
    public void setStorageID(String storageID) {this.storageID = storageID; }
    public void setGoodPrice(int goodPrice) { this.goodPrice = goodPrice; }
    public int getGoodPrice() { return goodPrice; }
    public String getState(){ return  state; }
    public String getHolder() { return holder;
    }
}
