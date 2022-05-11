package com.boolck.dsa;

/*
       Implement Collatz conjecture problem (also known as 3n+1 problem)
        Consider the following operation on an arbitrary positive integer:
            1.If the number is even, divide it by two.
            2.If the number is odd, triple it and add one.
            3. keep repeating above 2 steps till the number becomes 1
        return final number of steps required to make a positive integer become 1 .
*/

public class CollatzConjecture {

    public static void main(String[] args) {
        int num=Integer.MAX_VALUE;
       // int steps = getCollatzConjecture_Recursive(num);
       // int steps = getCollatzConjecture_RecursiveMemo(num,new java.util.HashMap<>());
        int steps = getCollatzConjecture_Iterative(num);
        System.out.printf("Collatz conjecture length for number %d is %d %n",num,steps);
    }

    private  static int getCollatzConjecture_Recursive(long n){
        if(n<1){
            return 0;
        }
        if(n==1){
            return 0;
        }
        if(n%2==0){
            return getCollatzConjecture_Recursive(n/2)+1;
        }
        return getCollatzConjecture_Recursive(3*n+1)+1;
    }

    private  static int getCollatzConjecture_RecursiveMemo(long n, java.util.Map<Long,Integer> memo){
        if(n<1){
            return 0;
        }
        if(n==1){
            return 0;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int steps ;
        if(n%2==0){
            steps = getCollatzConjecture_Recursive(n/2)+1;
        }
        else{
            steps = getCollatzConjecture_Recursive(3*n+1)+1;
        }
        memo.put(n,steps);
        return steps;
    }

    private  static int getCollatzConjecture_Iterative(long n){
        int steps=0;
        while(n>1){
            if(n%2==0){
                n=n/2;
            }
            else{
                n=3*n+1;
            }
            steps++;
        }
        return steps;
    }
}
