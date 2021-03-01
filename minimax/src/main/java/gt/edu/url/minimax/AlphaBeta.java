
package gt.edu.url.minimax;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AlphaBeta {

    public static<T> T finalValue(GameTree<T> gameTree){

        if(gameTree.root.getType()){
            return maxValue(gameTree);
        }
        else{
            return minValue(gameTree);
        }
    }

    public static<T> T maxValue(GameTree<T> gameTree){
        return null;
    }

    public static<T> T minValue(GameTree<T> gameTree){
        return null;
    }
}

