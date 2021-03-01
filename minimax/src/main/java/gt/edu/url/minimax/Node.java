package gt.edu.url.minimax;

import java.util.List;
import java.util.ArrayList;

public class Node<T>{

		private T value;
        private T alpha;
        private T beta;
        private boolean isMax;
		private List<Node<T>> children;
        // private Node<T> parent;

		// public Node(T value, T alpha, T beta, T type){
            // this.value = value;
            // this.alpha = alpha;
            // this.beta = beta;
            // this.type = type;
            // this.children = new HashSet<>();
            // // this.parent = parent;
		// }

        public Node(boolean isMax){
            this.isMax = isMax;
            this.value = null;
            this.alpha = null;
            this.beta = null;
            this.children = new ArrayList<>();
        }

        public Node(T value){
            this.value = value;
        }

        // public Node(){
        //     this.value = null;
        //     this.alpha = null;
        //     this.beta = null;
        //     this.children = new HashSet<>();
        // }

		public T getValue(){
				return this.value;
		}

		public T getAlpha(){
				return this.alpha;
		}

		public T getBeta(){
				return this.beta;
		}

        public boolean getType(){
            return this.isMax;
        }

		// public Node<T> getParent(){
		// 		return this.parent;
		// }

		public List<Node<T>> getChildren(){
				return children;
		}

		public void addChild(Node<T> node){
				if (this == node) throw new IllegalArgumentException("The node cannot reference itself");
                if (!this.children.contains(node)){
				    this.children.add(node);
                }
                // node.parent = this;
		}
}

