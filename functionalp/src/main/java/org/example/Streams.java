package org.example;

import java.util.*;
import java.util.stream.*;

public class Streams 
{
    public static Integer getFibonacci(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        int first = 1;
        int second = 1;
        int number = 0;

        for(int i=2; i<=n; i++){
            number = first + second;
            first = second;
            second = number;
        }

        return number;
    }

    public static boolean isPrimeNumber(int n){
        if(n <= 1){
            return false;
        }

        var cont = 0;

        for(int i = n -1; i > 1; i--){
            if(n % i == 0){
                cont++;
            }
        }

        return cont <= 0;
    }

    // public static Integer getNthPrimeNumber(int n){

    // }

    public static List<Integer> createRandomList(int qty){
        var random = new Random();
        List<Integer> numbers = new LinkedList<>();

        for(int i=0; i<qty; i++){
            numbers.add(random.nextInt(100));
        }

        return numbers;
    }

    public static void main( String[] args )
    {
        // System.out.println(getFibonacci(Integer.valueOf(args[0])));

        var primeList = createRandomList(Integer.valueOf(args[0])).stream()
            .filter(n -> isPrimeNumber(n))
            .sorted()
            .collect(Collectors.toList());

        var fibonacciList = primeList.stream()
            .map(n -> getFibonacci(n))
            .collect(Collectors.toList());

        System.out.println("Prime list");
        System.out.println(primeList);

        System.out.println("Fibonacci list");
        System.out.println(fibonacciList);
    }
}
