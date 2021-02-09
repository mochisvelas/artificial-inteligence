package org.example.graph;

import java.util.*;

public class DFS {

    // method to find goal node
    public static<T> Stack<Node<T>> search(T value, Node<T> start){
        Stack<Node<T>> fringe = new Stack<>();
        fringe.add(start);
        Set<Node<T>> closed = new HashSet<>();
        Node<T> currentNode;
        Stack<Node<T>> visitedNodes = new Stack<>();

        while(!fringe.isEmpty()){ // if there's still nodes to explore
            currentNode = fringe.pop();
            System.out.println("Current node is "+ currentNode.getValue());

            if(!visitedNodes.contains(currentNode)){
                visitedNodes.add(currentNode);
            }

            if(currentNode.getValue().equals(value)){ // if current node is goal, break while
                break; 

            }else{ // if not expand fringe and ignore already visited
                closed.add(currentNode);
                fringe.addAll(currentNode.getNeighbors());
                fringe.removeAll(closed);

            } 
        }

        // stack to store route
        Stack<Node<T>> route = new Stack<>();
        // push goal node
        route.push(visitedNodes.pop());

        while(!visitedNodes.isEmpty()){
            currentNode = visitedNodes.pop();

            // if last node pushed into route is neighbor to currentNode push currentNode
            if(route.peek().getNeighbors().contains(currentNode)){

                if(!route.contains(currentNode)){
                    route.push(currentNode);
                }
            }
        }

        // return stack with route
        return route;
    }

}
