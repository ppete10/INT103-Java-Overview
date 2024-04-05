package testEnum;

public enum TestEnum {
        MONDAY(1),TUESDAY(2),WENDESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7);

    private final int TestEnum;

    TestEnum(int TestEnum) {
        this.TestEnum = TestEnum;
    }

    public int getTestEnum() {
        return TestEnum;
    }
}

class Main1 {
    public static void main(String[] args) {
        //TestEnum today = TestEnum.MONDAY;

        for (TestEnum today : TestEnum.values()) {
            if (today == TestEnum.SATURDAY || today == TestEnum.SUNDAY)
                System.out.println("It's weedend!" + " Day number: " + today.getTestEnum() + " " + today);
            else System.out.println("Weekday:(" + " Day number: " + today.getTestEnum() + " " + today);
        }
    }
}
