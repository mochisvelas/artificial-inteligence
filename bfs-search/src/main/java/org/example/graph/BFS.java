package org.example.graph;

import java.util.*;

public class BFS {

    public static<T> Optional<Node<T>> search(T value, Node<T> start){
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);
        Set<Node<T>> closed = new HashSet<>();
        Node<T> currentNode;

        while(!queue.isEmpty()){
            currentNode = queue.remove();
            System.out.println("Current node is "+ currentNode.getValue());

            if(currentNode.getValue().equals(value)){
                return Optional.of(currentNode);
            }else{
                closed.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(closed);

            } 
        }

        return Optional.empty();
    }

}
