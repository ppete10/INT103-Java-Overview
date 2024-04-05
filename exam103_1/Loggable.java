package solution.base;

/*
2. In exam.base package, create an interface named Loggable that 
has two methods which are getLog() (returns String) and clearLog() (returns void).  
Make the OrgUnit class implement Loggable interface so that the clearLog method 
will reset the existing logging to an empty string.
*/
public interface Loggable {
    String getLog();
    void clearLog();
}
// see OrgUnit class implements Loggable interface 
// and @Override getLog() and clearLog()
