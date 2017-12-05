
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    Item item1;
    Item item2;

    @Before
    public void before() {
        item1 = new Item("vase", 99.99, ConditionType.EXCELLENT);
        item2 = new Item("painting", 1000, ConditionType.POOR);
    }

    @Test
    public void canGetName() {
        assertEquals("vase", item1.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(99.99, item1.getPrice(), 0.01);
    }

    @Test
    public void canGetCondition() {
        assertEquals(ConditionType.EXCELLENT, item1.getCondition());
    }

    @Test
    public void canSetCondition(){
        item1.setCondition(ConditionType.AVERAGE);
        assertEquals(ConditionType.AVERAGE, item1.getCondition());
    }

    @Test
    public void canImproveCondition(){
        item2.improveItem();
        assertEquals(ConditionType.AVERAGE, item2.getCondition());
    }

    @Test
    public void canImproveConditionTwice(){
        item2.improveItem();
        item2.improveItem();
        assertEquals(ConditionType.GOOD, item2.getCondition());
    }

    @Test
    public void cantImproveExcellent(){
        item1.improveItem();
        assertEquals(ConditionType.EXCELLENT, item1.getCondition());
    }
}
