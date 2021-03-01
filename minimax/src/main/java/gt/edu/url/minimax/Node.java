package gt.edu.url.minimax;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Node<T>{

		private T value;
        private T alpha;
        private T beta;
        private boolean isMax;
		private Set<Node<T>> children;
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
        }

        public Node(){
            this.value = null;
            this.alpha = null;
            this.beta = null;
            this.children = new HashSet<>();
        }

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

		public Set<Node<T>> getChildren(){
				return Collections.unmodifiableSet(children);
		}

		public void addChild(Node<T> node){
				if (this == node) throw new IllegalArgumentException("The node cannot reference itself");
                if (!this.children.contains(node)){
				    this.children.add(node);
                }
                // node.parent = this;
		}
}

