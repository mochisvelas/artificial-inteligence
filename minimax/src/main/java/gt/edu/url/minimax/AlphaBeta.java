
package gt.edu.url.minimax;

public class AlphaBeta {

    public static<T> T finalValue(GameTree<T> gameTree){

        if(gameTree.root.getType() == "max"){
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

