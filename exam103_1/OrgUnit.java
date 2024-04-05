package solution.base;

/*
1. Given the following two classes (School and Department) 
in exam.unit package, refactor these two classes by creating 
a public abstract superclass named OrgUnit in exam.base package 
and moving/adjusting common parts (attributes, methods, and constructors) 
in School and Department to OrgUnit as many as possible and 
changing access modifiers minimally if needed.
*/
public abstract class OrgUnit implements Loggable {

    private final int code;
    private String name;
    protected String logging;

    public OrgUnit(int code, String name) {
        this.code = code;
        this.name = name;
        this.logging = "";
    }
    
    public int getCode() { return code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override public String getLog() { return logging; }
    @Override public void clearLog() { logging = ""; } // 2. for Pluggable interface
}
