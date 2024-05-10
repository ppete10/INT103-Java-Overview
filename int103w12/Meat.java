package delicacy;

public class Meat extends Topping{
    public Meat(double price, String name, Dish dish) {
        super(price, name, dish);
    }
    public static Meat addPork(Dish dish){
        return new Meat(20.0,"Pork", dish);
    }
    public static Meat addBeef(Dish dish){
        return new Meat(25.0,"Beef", dish);
    }
}
