package gt.edu.url;

import gt.edu.url.minimax.*;

public class App
{
    public static void main( String[] args )
    {
        GameTree<Integer> gameTree = new GameTree<Integer>(true);
        var finalValue = AlphaBeta.finalValue(gameTree);
        System.out.println(finalValue);
    }
}
