package commenting.NNN;

import java.util.Iterator;

// 3.1 (2 points) create a public "CommentablePlus999" interface 
//     (in the "commenting.NNNNN" package) that extends "Commentable" interface. 
//     The "CommentablePlus999" interface must contain the following methods.
public interface CommentablePlus119 extends Commentable{

    // 3.2 (10 points) a default "inspect999()" method that returns a String. 
    // This method uses the iterator of its super-interface to iterate 
    // over all comments, convert them to Strings, and returns 
    // the concatenation of those Strings.
    default String inspect119(){
        StringBuilder sb = new StringBuilder();
        while (iterator().hasNext()){
            sb.append(iterator().hasNext());
        }
        return sb.toString();
    }
}
