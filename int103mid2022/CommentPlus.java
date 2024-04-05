package util.NNN;

import java.util.Comparator;
import java.util.function.Predicate;

/* 2.1 (3 points) create a public "CommentPlus999" class (in the "util.NNNNN" package) 
   that extends the "Comment" class.  You must not modify anything in 
    the "Comment" class.  The "CommentPlus999" class must contain 
    the following members (i.e., fields & methods).*/

public class CommentPlus119 extends Comment{
    // 2.2 (2 points) "grade999" which is a private final field of "Grade999" type.
    private final Grade119 grade119;

    // 2.3 (10 points) "GRADE999_COMPARATOR" which is a public static final field 
    //     of "Comparator<CommentPlus999>" type. The value of this field is 
    //     a lambda expression for comparing 2 "CommentPlus999" 
    //     by comparing their "grade999".
    public static final Comparator<CommentPlus119> GRADE119_COMPARATOR = Comparator.comparing(CommentPlus119::getGrade119);

    // 2.4 (10 points) a public static "match999(...)" method that receives 
    // a "grade" parameter of "Grade999" type and returns "Predicate<CommentPlus999>" 
    // type. This method returns a lambda expression.  This lambda expression receives 
    // a "CommentPlus999" object and returns true if the grade999 of that object 
    // equals the "grade" parameter. Otherwise, this lambda expression returns false.
    public static Predicate<CommentPlus119> match119(Grade119 grade){
        return c -> c.grade119 == grade;
    }

    // 2.5 (10 points) a public constructor that receives a "message" of "String" type
    // and a "grade" of "Grade999" type. This constructor must call the constructor 
    // of its supertype ("Comment") with the "message" as the parameter.
    // If "message" is null, it initializes the "message" field to "NO_COMMENT" instead.
    // If "grade" is null, it initializes the "grade999" field to Grade999.NONE instead.
    public CommentPlus119(String message,Grade119 grade) {
        super(message == null ? "NO_COMMENT" : message);
        this.grade119 = grade == null ? Grade119.NONE : grade;
    }

    // 2.6 (10 points) a protected "getContent()" method that overrides its superclass's method.
    // This method returns a String which consisting of (1) the result string from 
    // its superclass's getContent() method, concatenating with (2) the result string 
    // from its grade999 field.  Note that if its grade999 field is null, 
    // it concatenates an empty String instead of null.
    // @Override
    protected String getContent() {
        return super.getContent() + (grade119 == null ? "" : grade119);
    }

    public Grade119 getGrade119() {
        return grade119;
    }

    public String getMessage() {
        return null;
    }
}
