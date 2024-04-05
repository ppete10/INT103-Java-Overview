package solution.unit;

import solution.base.OrgUnit;

public class School extends OrgUnit {

    private double balance;
    
    public School(int code, String name) {
        super(code, name);
    }

    public double getBalance() { return balance; }

    public void earn(double amount) {
        balance += amount;
        logging += "earn(" + amount + ")";
    }

    public void spend(double amount) {
        balance -= amount;
        logging += "spend(" + amount + ")";
    }

}
