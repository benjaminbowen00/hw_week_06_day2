import java.util.ArrayList;

public class Shop {

    String name;
    ArrayList<Item> stock;
    int capacity;

    public Shop(String name, int capacity) {
        this.name = name;
        this.stock = new ArrayList<>();
        this.capacity = capacity;
    }


    public int countStock() {
        return stock.size();
    }

    public void addItem(Item item) {
        if (this.countStock() < this.capacity) {
            this.stock.add(item);
        }
    }

    public boolean containsItem(Item item){
        return this.stock.contains(item);
    }

    public void removeItem(Item item) {
        if (this.containsItem(item)){
        this.stock.remove(item);
        }
    }

    public void sendItemBack(Item item, Warehouse warehouse) {
        if (this.containsItem(item)){
            this.removeItem(item);
            warehouse.addItem(item);
        }
    }
}