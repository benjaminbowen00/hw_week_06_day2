import java.util.ArrayList;

public class Warehouse {
    String name;
    ArrayList<Item> stock;

    public Warehouse(String name) {
        this.name = name;
        this.stock = new ArrayList<>();
    }


    public int countStock() {
        return stock.size();
    }

    public void addItem(Item item) {
            this.stock.add(item);
    }

    public boolean containsItem(Item item){
        return this.stock.contains(item);
    }


    public void removeItem(Item item) {
        if (this.containsItem(item)) {
        this.stock.remove(item);
        }
    }

    public void sendItemToShop(Item item, Shop shop) {
        if (this.containsItem(item)) {
            this.removeItem(item);
            shop.addItem(item);
        }
    }

    public double valueOfStock(){
        double total = 0;
        for (int i=0; i<this.countStock();i++) {
            total += this.stock.get(i).getPrice();
        }
        return total;
    }
}
