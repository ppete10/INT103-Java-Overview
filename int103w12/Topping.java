package delicacy;

import util.Chain;

public abstract class Topping implements Dish{
    private Dish dish;
    private double price;
    private String name;

    @Override
    public double getPrice() {
        return price + dish.getPrice();
    }

    @Override
    public Chain<String> getIngredients() {
        return Chain.getInstance(name, dish.getIngredients());
    }

    public Topping(double price, String name,Dish dish) {
        if (price < 0 || name == null || dish == null)
            throw new IllegalArgumentException();

        this.price = price;
        this.name = name;
        this.dish = dish;
    }
}
