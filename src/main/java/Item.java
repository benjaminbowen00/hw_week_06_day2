public class Item {

    private String name;
    private double price;
    private ConditionType condition;

    public Item(String name, double price, ConditionType condition) {
        this.name = name;
        this.price = price;
        this.condition = condition;
    }

    public ConditionType getCondition(){
        return this.condition;
    }

    public void setCondition(ConditionType newCondition) {this.condition = newCondition;}

    public String getName() {return this.name; }

    public double getPrice() {return this.price;}

    public void improveItem() {
        ConditionType currentCondition = this.getCondition();
                switch(currentCondition){
                    case POOR:
                        this.setCondition(ConditionType.AVERAGE);
                        break;
                    case AVERAGE:
                        this.setCondition(ConditionType.GOOD);
                        break;
                    case GOOD:
                        this.setCondition(ConditionType.EXCELLENT);
                        break;
                }
    }
}