package commenting.NNN;

import util.NNN.CommentPlus119;
import util.NNN.Grade119;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

// 4. (45 points) From the "CommentablePlus999" interface in the previous question,

// 4.1 (2 points) create a public "CommentList999" class 
//     (in the "commenting.NNNNN" package) that implements 
//     "CommentablePlus999" interface.  The "CommentList999" class 
//     must contain the following field and overriding methods.

public class CommentList119 implements CommentablePlus119{

    // 4.2 (3 points) a "comments999" field that is a private final field 
    // of "LinkedList<CommentPlus999>" type, and initializes to 
    // a newly-created LinkedList.
    private final LinkedList<CommentPlus119> comment119 = new LinkedList<>();

    // 4.3 (10 points) a "addComment(...)" method that returns true if it adds 
    // the comment message with the grade to the "comments999" field successfully.
    // Otherwise, it returns false. It will not add the comment message with 
    // the grade if the comment message is null.
    // @Override
    public boolean addComment(String message, Grade119 grade) {
         if (!message.isBlank() && grade != null) {
            comment119.add(new CommentPlus119(message, grade));
            return true;
        }
        return false;
    }

    // 4.4 (10 points) a "removeComment(...)" method that returns true if it removes 
    //     the first comment containing the given message (in the parameter) from 
    //     the "comments999" field successfully.  Otherwise, it returns false. 
    //     It will not remove the comment if the comment message is null.
    //     @Override
    public boolean removeComment(String message) {
        for (var a : comment119) {
            if (message.equals(a)){
                comment119.remove(a);
                return true;
            }
        }
        return false;
    }


    // 4.5 (5 points) an "iterator()" method that returns the iterator of 
    //     the "comments999" field.
    @Override
	public Iterator<CommentPlus> iterator() {
        return new Iterator<CommentPlus>() {
            int cursor;
            @Override
            public boolean hasNext() {
                return cursor < comments.size();
            }
            @Override
            public CommentPlus next() {
                return comments.get(cursor++);
            }
        };
    }

    // 4.7 (10 points) an "extract(...)" method that returns a String Collection of 
    //     all comment messages in the "comments999" field that matches ("match999")
    //     the grade parameter.
    public Collection<String> extract(Grade119 grade) {
        var list = new LinkedList<String>();
        comments.forEach(x -> {
            if (CommentPlus.match.test(x)) {
                list.add(x.toString());
            }
        });
        return (Collection<String>)list;
    }

    // 4.6 (5 points) a "sort()" method that sorts the "comments999" field 
    // using the "GRADE999_COMPARATOR" of the "CommentPlus999" class.
    // @Override
    @Override
    public void sort() {
        comment119.sort(CommentPlus119.GRADE119_COMPARATOR);
    }
}
