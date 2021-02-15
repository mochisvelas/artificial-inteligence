package org.example;

import java.util.*;
import java.util.stream.*;
import java.math.BigInteger;

public class Streams 
{
    public static BigInteger getFibonacci(int n){
        BigInteger first = BigInteger.valueOf(1);
        BigInteger second = BigInteger.valueOf(1);
        BigInteger number = BigInteger.valueOf(0);

        if(n == 0){
            return number;
        }

        if(n == 1){
            return first;
        }

        for(int i=2; i<=n; i++){
            number = first.add(second);
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

        System.out.println("Calculating primeList...\n");
        var primeList = createRandomList(Integer.valueOf(args[0])).parallelStream()
            .filter(n -> isPrimeNumber(n))
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Calculating fibonacciList...\n");
        var fibonacciList = primeList.parallelStream()
            .map(n -> getFibonacci(n))
            .collect(Collectors.toList());


        System.out.println("Calculation completed");
        System.out.println("17th prime " + primeList.get(16));
        System.out.println("17th fibonacci " + fibonacciList.get(16));
        // System.out.println(fibonacciList);
    }
}
