package commenting.NNN;

import java.util.Iterator;

public interface CommentablePlus119 extends Commentable{
    default String inspect119(){
        StringBuilder sb = new StringBuilder();
        while (iterator().hasNext()){
            sb.append(iterator().hasNext());
        }
        return sb.toString();
    }
}
