public class Item {
    private final double price;
    private final String name;
    private final String SKU;
    private Double discountPrice;

    public Item(String SKU,String name, double price){
        this.price = price;
        this.name = name;
        this.SKU = SKU;
        this.discountPrice = null;
    }

    public void setDiscountPrice(Double price){
        this.discountPrice = price;
    }

    public String getName(){
        return this.name;
    }
    public String getSKU(){
        return this.SKU;
    }
    public double getPrice(){
        return discountPrice==null? this.price:this.discountPrice.doubleValue();
    }
}