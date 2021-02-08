package org.example;

import org.example.graph.Node;

public class App 
{
    public static void main( String[] args )
    {

        Node<String> node1 = new Node<>("First node");

        Node<Boolean> node2 = new Node<>(true);

        var node3 = new Node<Integer>(7);
        
        System.out.println(node3);

    }
}
