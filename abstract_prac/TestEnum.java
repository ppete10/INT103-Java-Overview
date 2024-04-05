public class TestEnum {
    // Defining an enum called Day
    enum Day {
        MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

        Day(int i) {
        }
    }

    public static void main(String[] args) {
        //Day today = Day.MONDAY;
        //System.out.println(today);
        //if (today == Day.SATURDAY || today == Day.SUNDAY) System.out.println("It's weekend!");
        //else System.out.println("It's weenday :(");

        for (Day today : Day.values()) {
            System.out.println(today);
            if (today == Day.SATURDAY || today == Day.SUNDAY) System.out.println("It's weekend!");
            else System.out.println("It's weenday :(");
        }
        System.out.println();
    }
}
