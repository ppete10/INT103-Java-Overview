package commenting.NNN;

import util.NNN.CommentPlus119;
import util.NNN.Grade119;

import java.util.Collection;
import java.util.Iterator;
// 3. (12 points) Given the public "Commentable" interface in the "commenting.NNNNN" package,
public interface Commentable extends Iterable<CommentPlus119> {
    default boolean addComment(String message) { return addComment(message, null); }
    boolean addComment(String message, Grade119 grade);
    boolean removeComment(String message);
    Iterator<CommentPlus119> iterator();
    Collection<String> extract(Grade119 grade);
    void sort();
}
