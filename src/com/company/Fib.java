package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fib {

    public Fib() {
    }



    public int fib(int N) {
        if(N<1) return 0;

        List<Integer> memo = new ArrayList<Integer>(Collections.nCopies(N+1, 0));

        return helper(memo,N);
    }
// 用recursion自顶向下
    public int helper(List<Integer> memo, int n){
        //base case:
        if (n == 1 || n == 2) return 1;

        if (memo.get(n) != 0) return memo.get(n);
        memo.set(n, helper(memo, n - 1) + helper(memo, n - 2));
        return memo.get(n);
    }
// 升级版：自底向上；从basecase开始算；
    public int dp(int N){
        List<Integer> dp_table = new ArrayList<Integer>(Collections.nCopies(N+1, 0));

        dp_table.set(1, 1);
        dp_table.set(2,1);
        for(int i  = 3; i<=N; i++){
            dp_table.set(i, dp_table.get(i-1)+ dp_table.get(i-2));
        }
        return dp_table.get(N);

    }
//节省空间升级版：空间复杂度降为O（1）；
    public int O1(int n){
        if (n == 2 || n==1) return 1;

        int prev, curr;
        prev = 1;
        curr = 1;
        for (int i = 3; i<=n; i++){
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;

    }

    public static void main(String[] args) {
        Fib obj = new Fib();
        int ans = obj.O1(15);
        System.out.println(ans);

    }
}
