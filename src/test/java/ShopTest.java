import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    Shop myShop;
    Warehouse myWarehouse;
    Item item1;
    Item item2;
    Item item3;

    @Before
    public void before() {
        myShop = new Shop("Antiques R US", 100);
        myWarehouse = new Warehouse("Main Warehouse");
        item1 = new Item("vase", 99.99, ConditionType.EXCELLENT);
        item2 = new Item("painting", 1000, ConditionType.AVERAGE);
        item3 = new Item("chair", 200, ConditionType.GOOD);
    }

    @Test
    public void shopStartEmpty(){
        assertEquals(0, myShop.countStock());
    }

    @Test
    public void canAddItems(){
        myShop.addItem(item1);
        assertEquals(1, myShop.countStock());
    }

    @Test
    public void canAddLotsItems(){
        int x  = 0;
        while (x < 50) {
            myShop.addItem(item1);
            x++;
        }
        assertEquals(50, myShop.countStock());
    }

    @Test
    public void cantAddBeyondCapacity(){
        int x  = 0;
        while (x < 200) {
            myShop.addItem(item1);
            x++;
        }
        assertEquals(100, myShop.countStock());
    }

    @Test
    public void canRemoveItem() {
        myShop.addItem(item1);
        myShop.addItem(item2);
        myShop.addItem(item3);
        myShop.removeItem(item2);
        assertEquals(2, myShop.countStock());
    }

    @Test
    public void cantRemoveItemIfNotInShop() {
        myShop.addItem(item1);
        myShop.addItem(item2);
        myShop.removeItem(item3);
        assertEquals(2, myShop.countStock());
    }

    @Test
    public void canSendItemToWarehouse() {
        myShop.addItem(item1);
        myShop.addItem(item2);
        myShop.sendItemBack(item2, myWarehouse);
        assertEquals(1, myWarehouse.countStock());
        assertEquals(1, myShop.countStock());
    }
}
