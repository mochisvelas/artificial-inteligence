package org.example;

import org.example.graph.Node;
import org.example.graph.BFS;
import org.example.graph.BFSVersion2;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {

        Node<Integer> zona1 = new Node<>(1);
        Node<Integer> zona2 = new Node<>(2);
        Node<Integer> zona4 = new Node<>(4);
        Node<Integer> zona5 = new Node<>(5);
        Node<Integer> zona9 = new Node<>(9);
        Node<Integer> zona10 = new Node<>(10);
        Node<Integer> zona12 = new Node<>(12);
        Node<Integer> zona13 = new Node<>(13);
        Node<Integer> zona14 = new Node<>(14);
        Node<Integer> zona15 = new Node<>(15);
        Node<Integer> zona16 = new Node<>(16);
        Node<Integer> zona21 = new Node<>(21);

        zona1.connect(zona2);
        zona1.connect(zona4);
        zona1.connect(zona5);
        zona1.connect(zona9);
        zona4.connect(zona5);
        zona4.connect(zona9);
        zona9.connect(zona10);
        zona9.connect(zona13);
        zona10.connect(zona15);
        zona12.connect(zona13);
        zona12.connect(zona21);
        zona13.connect(zona14);
        zona14.connect(zona10);
        zona16.connect(zona10);

        System.out.println("BFS");
        Stack<Node<Integer>> route = BFS.search(16, zona21);
        System.out.println("The route is: ");
        System.out.print(route.pop().getValue());

        while(!route.isEmpty()){
            System.out.print("->");
            System.out.print(route.pop().getValue());
        }

        System.out.println("");

        System.out.println("BFSVersion2");
        route = BFSVersion2.search(16, zona21);
        System.out.println("The route is: ");
        System.out.print(route.pop().getValue());

        while(!route.isEmpty()){
            System.out.print("->");
            System.out.print(route.pop().getValue());
        }

        System.out.println("");

    }

}
