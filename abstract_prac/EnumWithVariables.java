public class EnumWithVariables {
    // Defining an enum called Day
    enum Day {
        MONDAY("Monday"),
        TUESDAY("Tuesday"),
        WEDNESDAY("Wednesday"),
        THURSDAY("Thursday"),
        FRIDAY("Friday"),
        SATURDAY("Saturday"),
        SUNDAY("Sunday");

        // Variable to store the day name
        private final String dayName;

        // Constructor to initialize the day name
        Day(String dayName) {
            this.dayName = dayName;
        }

        // Method to get the day name
        public String getDayName() {
            return dayName;
        }

    }

    public static void main(String[] args) {
        // Accessing variables and methods of the enum constants
        for (Day day : Day.values()) {
            System.out.println(day + " is also known as " + day.getDayName());
        }
    }
}