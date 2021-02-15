package org.example;

public class Streams 
{
    public static Integer getFibonacciNumber(int n){


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

    public static void main( String[] args )
    {
        System.out.println(getFibonacciNumber(Integer.valueOf(args[0])));
    }
}
