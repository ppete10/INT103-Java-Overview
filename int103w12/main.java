package int103;


import exception.*;
import delicacy.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Today's Topic");
        //demoException();
        demoDecolator();
    }

    private static void demoDecolator() {
        System.out.println("----- Decolator Design Patterns -----");
        Dish d1 = Meat.addBeef(Noodle.RICE_NOODLE);
        Dish d2 = Meat.addPork(Meat.addBeef(Noodle.RICE_NOODLE));
        Dish d3 = Meat.addBeef(Noodle.EGG_NOODLE);
        System.out.println("Dish1 : " + d1.ingredientsToString() + " " + d1.getPrice() + " B." );
        System.out.println("Dish1 : " + d2.ingredientsToString() + " " + d2.getPrice() + " B.");
        System.out.println("Dish1 : " + d3.ingredientsToString() + " " + d3.getPrice() + " B.");
        Dish d4 = new Meat(50,"Tuna", (new Meat(50,"Salmon", new Noodle(30, "Sticky Rice"))));
        System.out.println("Dish1 : " + d4.ingredientsToString() + " " + d4.getPrice() + " B.");
    }

    private static void demoException() {
        System.out.println("----- Exception -----");
        try {
            demoUnCheckedException();
        } catch (MyUnCheckedException e) {
            e.printStackTrace();
        }

        List<String> x = new LinkedList<>();
        try {
            x = new LinkedList<>();
            x.add("abc");
            demoCheckedException();
            x.add("x");
        } catch (MyCheckedException e){
            e.printStackTrace();
            System.out.println(x);
        } finally {
            if (x != null)
                x.clear();
            System.out.println(x);
        }
    }

    private static void demoCheckedException() throws MyCheckedException{
        throw new MyCheckedException("Test Unchecked Exception");
    }

    private static void demoUnCheckedException() {
        throw new MyUnCheckedException("Test Checked Exception");

    }

}