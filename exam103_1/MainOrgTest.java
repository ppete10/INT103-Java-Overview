package solution.main;

import solution.base.Group;
import solution.base.Loggable;
import solution.base.OrgUnit;
import solution.unit.Department;
import solution.unit.School;
import solution.unit.Staff;

/*
3. Write a MainOrgTest class in exam.main package to test 
School, Department, OrgUnit, and Loggable. 
*/
public class MainOrgTest {

    // 3.5. public static void main(String[] args) calls all of the test methods. 
    public static void main(String[] args) {
        testSchool();
        testDepartment();
        testSchoolAsOrgUnit();
        testDepartmentAsLoggable();
        testStaff();
        testDepartmentGroup();
    }
    
    // 3.1. testSchool() tests that School objects work correctly as School.
    // OrgUnit: getCode(), getName(), setName(), getLog()
    // School: getBalance(), earn(), spend()
    static void testSchool() {
        System.out.println("\nTest School ...");
        School s = new School(1, "SIT");
        System.out.format("School: code[%d] name[%s] balance[%.2f] log[%s]%n", 
                s.getCode(), s.getName(), s.getBalance(), s.getLog());
        s.setName("School of IT");
        s.earn(5_000);
        s.spend(2_125);
        System.out.format("School: code[%d] name[%s] balance[%.2f] log[%s]%n", 
                s.getCode(), s.getName(), s.getBalance(), s.getLog());        
    }
    
    // 3.2. testDepartment() tests that Department objects work correctly as Department.
    // OrgUnit: getCode(), getName(), setName(), getLog()
    // Department: getSchool(), setSchool()
    static void testDepartment() {
        System.out.println("\nTest Department ...");
        Department d = new Department(11, "Software Technology", new School(1, "SIT"));
        System.out.format("Department: code[%d] name[%s] school[%s] log[%s]%n", 
                d.getCode(), d.getName(), d.getSchool().getName(), d.getLog());
        d.setSchool(new School(2, "School of IT"));
        System.out.format("Department: code[%d] name[%s] school[%s] log[%s]%n", 
                d.getCode(), d.getName(), d.getSchool().getName(), d.getLog());
    }
    
    // 3.3. testSchoolAsOrgUnit() tests that School objects work correctly as OrgUnit.
    // OrgUnit: getCode(), getName(), setName(), getLog()
    static void testSchoolAsOrgUnit() {
        System.out.println("\nTest School as OrgUnit ...");
        School s = new School(1, "SIT");
        System.out.format("School: code[%d] name[%s] balance[%.2f] log[%s]%n", 
                s.getCode(), s.getName(), s.getBalance(), s.getLog());
        s.earn(5_000);
        OrgUnit o = s;
        o.setName("School of IT");
        s.spend(2_125);
        ((School) o).earn(10_000);
        System.out.format("OrgUnit: code[%d] name[%s] log[%s]%n", 
                o.getCode(), o.getName(), o.getLog());
        OrgUnit u = new School(2, "School of IT");
        System.out.format("OrgUnit: code[%d] name[%s] log[%s]%n", 
                u.getCode(), u.getName(), u.getLog());
        ((School) u).earn(10_000);        
        ((School) u).spend(7_000);        
        u.setName("School of Information Technology");
        System.out.format("OrgUnit: code[%d] name[%s] log[%s]%n", 
                u.getCode(), u.getName(), u.getLog());
    }
    
    // 3.4. testDepartmentAsLoggable() tests that Department objects 
    // work correctly as Loggable.
    // Loggable: fetLog(), clearLog()
    static void testDepartmentAsLoggable() {
        System.out.println("\nTest Department as Loggable ...");
        Department d = new Department(22, "Infrastructure Technology", new School(1, "SIT"));
        System.out.format("Department: code[%d] name[%s] school[%s] log[%s]%n", 
                d.getCode(), d.getName(), d.getSchool().getName(), d.getLog());
        d.setSchool(new School(2, "School of IT"));
        d.setSchool(new School(4, "School of Information Technology"));
        Loggable lg = d;
        System.out.format("Loggable: log[%s]%n", lg.getLog());
        lg.clearLog();
        d.setSchool(new School(8, "School of Information Technology"));        
        ((Department) lg).setSchool(new School(10, "S.I.T."));
        System.out.format("Loggable: log[%s]%n", lg.getLog());
    }
    
    /* 
    4.2. Write a test method named testStaff() in the MainOrgTest to test that 
    Staff objects work correctly on its constructor and both getter and setter 
    for affiliation attribute.
    */
    static void testStaff() {
        System.out.println("\nTest Staff ...");
        Staff s = new Staff(100, "Adam", "Family", new School(1, "SIT"));
        System.out.format("Staff: id[%d] firsname[%s] lastname[%s] affiliation[%s]%n",
                s.getId(), s.getFirstname(), s.getLastname(), s.getAffliation().getName());
        s.setId(99);
        s.setFirstname("Mada");
        s.setLastname("Fama");
        s.setAffliation(new Department(22, "Digital Innovation", (School) s.getAffliation()));
        System.out.format("Staff: id[%d] firsname[%s] lastname[%s] affiliation[%s]%n",
                s.getId(), s.getFirstname(), s.getLastname(), s.getAffliation().getName());        
    }
    
    /*
    6. Write a test method named testDepartmentGroup() in the MainOrgTest 
    to test that Group<Department> objects work correctly on append(), find(), remove(), 
    and get() and also use a for loop to access all Department objects in the group.
    */
    static void testDepartmentGroup() {
        System.out.println("\nTest Department Group ...");
        Group<Department> dg = new Group<>(10);
        School s = new School(1, "SIT");
        Department d11 = new Department(11, "Dept First", s);
        Department d22 = new Department(22, "Dept Junior", s);
        Department d33 = new Department(33, "Dept Triad", s);
        Department d44 = new Department(44, "Dept Square", s);
        Department d55 = new Department(55, "Dept Penta", s);
        Department d66 = new Department(66, "Dept Hex", s);
        boolean b;
        System.out.format("Append %s : %s%n", d11.getName(), dg.append(d11) ? "Success" : "Failure");
        System.out.format("Append %s : %s%n", d22.getName(), dg.append(d22) ? "Success" : "Failure");
        System.out.format("Append %s : %s%n", d33.getName(), dg.append(d33) ? "Success" : "Failure");
        System.out.format("Append %s : %s%n", d22.getName(), dg.append(d22) ? "Success" : "Failure");
        System.out.format("Append %s : %s%n", d44.getName(), dg.append(d44) ? "Success" : "Failure");
        System.out.format("Append %s : %s%n", d55.getName(), dg.append(d55) ? "Success" : "Failure");
        System.out.println("Size = " + dg.getSize());
        int x = dg.find(d33);
        System.out.format("Find [%s] : %s%n", d33.getName(),
                x < 0 ? "Not Found" : "At " + x + " -> "+ dg.get(x).getName());
        x = dg.find(d66);
        System.out.format("Find [%s] : %s%n", d66.getName(),
                x < 0 ? "Not Found" : "At " + x + " -> "+ dg.get(x).getName());
        b = dg.remove(d33);
        System.out.format("Remove [%s] : %s%n", d33.getName(), b ? "Success" : "Failure");
        b = dg.remove(d66);
        System.out.format("Remove [%s] : %s%n", d66.getName(), b ? "Success" : "Failure");
        for (int i = 0; i < dg.getSize(); i++) {
            Department d = dg.get(i);
            System.out.format("[%d] Department code[%d] name[%s]%n", i, d.getCode(), d.getName());
        }
    }
}
