package gt.edu.url.minimax;

public class GameTree<T> {

    public Node<T> root;

    public GameTree(boolean type){
        root = new Node<>(type);
    }
}
