package org.example;

import org.example.graph.Node;
import org.example.graph.BFS;
import org.example.graph.BFSVersion2;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {

        var zona1 = new Node<>(1);
        var zona2 = new Node<>(2);
        var zona4 = new Node<>(4);
        var zona5 = new Node<>(5);
        var zona9 = new Node<>(9);
        var zona10 = new Node<>(10);
        var zona12 = new Node<>(12);
        var zona13 = new Node<>(13);
        var zona14 = new Node<>(14);
        var zona15 = new Node<>(15);
        var zona16 = new Node<>(16);
        var zona21 = new Node<>(21);

        zona21.connect(zona12);
        zona12.connect(zona13);
        zona13.connect(zona9);
        zona13.connect(zona14);
        zona14.connect(zona10);
        zona10.connect(zona9);
        zona10.connect(zona15);
        zona10.connect(zona16);
        zona9.connect(zona4);
        zona9.connect(zona1);
        zona4.connect(zona5);
        zona4.connect(zona1);
        zona1.connect(zona5);
        zona1.connect(zona2);


        System.out.println("BFS");
        Stack<Node<Integer>> route = BFS.search(21, zona2);
        System.out.println("The route is: ");
        System.out.print(route.pop().getValue());

        while(!route.isEmpty()){
            System.out.print("->");
            System.out.print(route.pop().getValue());
        }

        System.out.println("");

        System.out.println("BFSVersion2");
        route = BFSVersion2.search(21, zona2);
        System.out.println("The route is: ");
        System.out.print(route.pop().getValue());

        while(!route.isEmpty()){
            System.out.print("->");
            System.out.print(route.pop().getValue());
        }

        System.out.println("");

    }

}
