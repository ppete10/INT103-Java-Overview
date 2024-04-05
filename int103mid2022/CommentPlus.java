package util.NNN;

import java.util.Comparator;
import java.util.function.Predicate;

public class CommentPlus119 extends Comment{

    private final Grade119 grade119;
    public static final Comparator<CommentPlus119> GRADE119_COMPARATOR = Comparator.comparing(CommentPlus119::getGrade119);
    public CommentPlus119(String message,Grade119 grade) {
        super(message == null ? "NO_COMMENT" : message);
        this.grade119 = grade == null ? Grade119.NONE : grade;
    }

    public static Predicate<CommentPlus119> match119(Grade119 grade){
        return c -> c.grade119 == grade;
    }

    @Override
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
