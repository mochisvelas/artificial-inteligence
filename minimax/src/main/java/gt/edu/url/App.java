package gt.edu.url;

import gt.edu.url.minimax.*;

public class App
{
    public static void main( String[] args )
    {
        GameTree<Integer> gameTree = new GameTree<>("max");
        gameTree.root.addChild(new Node<>("min"));
        gameTree.root.addChild(new Node<>("min"));
        gameTree.root.addChild(new Node<>("min"));

        for (Node<Integer> node: gameTree.root.getChildren()){
            node.addChild(new Node<>("max"));
            node.addChild(new Node<>("max"));
        }

        gameTree.root.getChildren().get(0).getChildren().get(0).addChild(new Node<>(4));
        gameTree.root.getChildren().get(0).getChildren().get(0).addChild(new Node<>(6));

        gameTree.root.getChildren().get(0).getChildren().get(1).addChild(new Node<>(7));
        gameTree.root.getChildren().get(0).getChildren().get(1).addChild(new Node<>(9));

        gameTree.root.getChildren().get(1).getChildren().get(0).addChild(new Node<>(1));
        gameTree.root.getChildren().get(1).getChildren().get(0).addChild(new Node<>(2));

        gameTree.root.getChildren().get(1).getChildren().get(1).addChild(new Node<>(0));
        gameTree.root.getChildren().get(1).getChildren().get(1).addChild(new Node<>(1));

        gameTree.root.getChildren().get(2).getChildren().get(0).addChild(new Node<>(8));
        gameTree.root.getChildren().get(2).getChildren().get(0).addChild(new Node<>(1));

        gameTree.root.getChildren().get(2).getChildren().get(1).addChild(new Node<>(9));
        gameTree.root.getChildren().get(2).getChildren().get(1).addChild(new Node<>(2));

        var finalValue = AlphaBeta.finalValue(gameTree);
        System.out.println(finalValue);
    }
}
