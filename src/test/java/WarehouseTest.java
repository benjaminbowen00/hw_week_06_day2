import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarehouseTest {
    Warehouse myWarehouse;
    Shop myShop;
    Item item1;
    Item item2;
    Item item3;

    @Before
    public void before() {
        myWarehouse = new Warehouse("Main Warehouse");
        myShop = new Shop("Antiques R US", 100);
        item1 = new Item("vase", 99.99, ConditionType.EXCELLENT);
        item2 = new Item("painting", 1000, ConditionType.POOR);
        item3 = new Item("teapot", 50, ConditionType.AVERAGE);
    }

    @Test
    public void warehouseStartEmpty(){
        assertEquals(0, myWarehouse.countStock());
    }

    @Test
    public void canAddItem(){
        myWarehouse.addItem(item1);
        assertEquals(1 ,myWarehouse.countStock());
    }

    @Test
    public void canCheckIfContainsItem(){
        myWarehouse.addItem(item1);
        assertEquals(true, myWarehouse.containsItem(item1));
        assertEquals(false, myWarehouse.containsItem(item2));
    }

    @Test
    public void canRemoveItem(){
        myWarehouse.addItem(item1);
        myWarehouse.addItem(item2);
        assertEquals(2 ,myWarehouse.countStock());
        myWarehouse.removeItem(item2);
        assertEquals(1 ,myWarehouse.countStock());
        myWarehouse.removeItem(item1);
        myWarehouse.removeItem(item3);
        assertEquals(0 ,myWarehouse.countStock());
    }

    @Test
    public void canSendItemToShop(){
        myWarehouse.addItem(item1);
        myWarehouse.addItem(item2);
        myWarehouse.sendItemToShop(item1,myShop);
        assertEquals(1, myShop.countStock());
        assertEquals(1, myWarehouse.countStock());
    }

    @Test
    public void canSumPrices(){
        myWarehouse.addItem(item1);
        myWarehouse.addItem(item2);
        assertEquals(1099.99, myWarehouse.valueOfStock(), 0.01);
    }
}
