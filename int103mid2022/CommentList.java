package commenting.NNN;

import util.NNN.CommentPlus119;
import util.NNN.Grade119;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class CommentList119 implements CommentablePlus119{
    private final LinkedList<CommentPlus119> comment119 = new LinkedList<>();

    @Override
    public boolean addComment(String message, Grade119 grade) {
        for (CommentPlus119 a : comment119) {
            if (message != null && grade != null) {
                comment119.add(new CommentPlus119(message, grade));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeComment(String message) {
        for (CommentPlus119 a : comment119) {
            if ((message != null) && (message == a.getMessage())) {
                comment119.remove(a);
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<CommentPlus119> iterator() {
        return iterator();
    }

    @Override
    public Collection<String> extract(Grade119 grade) {
        var list = new LinkedList<String>();
        comments.forEach(x -> {
            if (CommentPlus.match.test(x)) {
                list.add(x.toString());
            }
        });
        return (Collection<String>)list;
    }

    @Override
    public void sort() {
        comment119.sort(CommentPlus119.GRADE119_COMPARATOR);
    }
}
