import java.util.ArrayList;
import java.util.HashMap;


public class Checkout {

    private ArrayList<Rule> rules;

    private HashMap<Item, Integer> itemMap = new HashMap();

    public Checkout(ArrayList<Rule> rules){
        this.rules = rules;
    }

    public void scan(Item item){
        if(this.itemMap.get(item) == null){
            this.itemMap.put(item, 1);
        }else {
            this.itemMap.put(item, this.itemMap.get(item) + 1);
        }
    }

    public void clear(){
        this.itemMap.forEach((k,v)->k.setDiscountPrice(null));
        this.itemMap.clear();
    }

    public double total(){
        rules.forEach(r->r.updateItem(itemMap));
        return this.itemMap.entrySet()
                    .stream()
                    .mapToDouble(i-> i.getKey().getPrice()*i.getValue())
                    .sum();
    }

}


