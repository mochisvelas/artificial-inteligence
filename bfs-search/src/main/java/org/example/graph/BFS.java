package org.example.graph;

import java.util.*;

public class BFS {

    // method to find goal node
    public static<T> Stack<Node<T>> search(T value, Node<T> start){
        Queue<Node<T>> fringe = new ArrayDeque<>();
        fringe.add(start);
        Set<Node<T>> closed = new HashSet<>();
        Node<T> currentNode;
        Stack<Node<T>> visitedNodes = new Stack<>();
        Boolean found = false;

        while(!fringe.isEmpty()){ // if there's still nodes to explore
            currentNode = fringe.remove();
            System.out.println("Current node is "+ currentNode.getValue());

            if(!visitedNodes.contains(currentNode)){
                visitedNodes.add(currentNode);
            }

            if(currentNode.getValue().equals(value)){ // if current node is goal, break while
                found = true;
                break; 

            }else{ // if not expand fringe and ignore already visited
                closed.add(currentNode);
                fringe.addAll(currentNode.getNeighbors());
                fringe.removeAll(closed);
            } 
        }

        // stack to store route
        Stack<Node<T>> route = new Stack<>();

        // push goal node if visitedNodes is not empty
        if(found){
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
        }

        // return stack with route
        return route;
    }

}
