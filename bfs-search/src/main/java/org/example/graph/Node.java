package org.example.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Node<T>{

		private T value;
		private Set<Node<T>> neighbors;

		public Node(T value){
				this.value = value;
				this.neighbors = new HashSet<>();
		}

		public T getValue(){
				return this.value;
		}

		public Set<Node<T>> getNeighbors(){
				return Collections.unmodifiableSet(neighbors);
		}

		public void connect(Node<T> node){
				if (this == node) throw new IllegalArgumentException("The node cannot reference itself");
				this.neighbors.add(node);
				node.neighbors.add(this);
				
		}
}
