package delicacy;

import util.Chain;

import java.util.StringJoiner;

public interface Dish {
    public double getPrice();
    public Chain<String> getIngredients();
    default String ingredientsToString(){
        var j = new StringJoiner(",","ingredients[","]");
        for (var c = getIngredients();c != null; c = c.getNext()) {
            j.add(c.getValue());
        }
        return j.toString();
    }
}
