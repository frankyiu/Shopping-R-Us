import java.util.ArrayList;
import java.util.HashMap;

public abstract class Rule {
    public abstract void updateItem(HashMap<Item,Integer> itemMap);
}


class BuyXGetY extends Rule {
    private int buyCount, getCount;
    private Item item;
    public BuyXGetY(int x, int y, Item item){
        this.buyCount = x;
        this.getCount = y;
        this.item = item;
    }

    public void updateItem(HashMap<Item,Integer> itemMap){

        if(itemMap.get(this.item) == null)
            return;
        int count = itemMap.get(this.item);
        int countOfFree = count/(this.buyCount+this.getCount)*this.getCount;
        itemMap.put(this.item, itemMap.get(this.item)-countOfFree);
    }
}

class DiscountMoreThanX extends Rule {
    private int buyCount;
    private double discountPrice;
    private Item item;
    public DiscountMoreThanX(int x, double discountPrice,Item item){
        this.buyCount = x;
        this.item = item;
        this.discountPrice = discountPrice;
    }

    public void updateItem(HashMap<Item,Integer> itemMap){

        if(itemMap.get(this.item) == null)
            return;
        int count = itemMap.get(this.item);
        if(count>this.buyCount) {
            item.setDiscountPrice(discountPrice);
        }
    }
}

class BuyAGiveB extends Rule {

    private Item itemA, itemB;
    public BuyAGiveB(Item A, Item B){
        this.itemA = A;
        this.itemB = B;
    }

    public void updateItem(HashMap<Item,Integer> itemMap){
        if(itemMap.get(this.itemA) == null || itemMap.get(this.itemB) == null)
            return;
        int count = itemMap.get(this.itemA);
        itemMap.put(this.itemB, itemMap.get(this.itemB)-count);

    }
}