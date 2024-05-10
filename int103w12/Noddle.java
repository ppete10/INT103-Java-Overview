package delicacy;

public class Noodle extends Food{
    public static Noodle RICE_NOODLE = new Noodle(15.0,"Rice Noodle");
    public static Noodle EGG_NOODLE = new Noodle(20.0,"Egg Noodle");
    public Noodle(double price, String name) {
        super(price, name);
    }
}
