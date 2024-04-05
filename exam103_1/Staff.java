package solution.unit;

import solution.base.OrgUnit;

/*
4. Create a public class named Staff in exam.unit package and 
the Staff class contains the following attributes: id (int), firstname (String), 
lastname (String), and affiliation (OrgUnit) which are all private.
*/
public class Staff {

    private int id;
    private String firstname;
    private String lastname;
    private OrgUnit affliation;

    /*
    4.1. This class has a constructor that receives parameters 
    to initialize all of its attributes. It contains all getters and setters.
    */
    public Staff(int id, String firstname, String lastname, OrgUnit affliation) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.affliation = affliation;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public OrgUnit getAffliation() { return affliation; }
    public void setAffliation(OrgUnit affliation) { this.affliation = affliation; }
}
