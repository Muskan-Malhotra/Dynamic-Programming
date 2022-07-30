// import java.io.*;
import java.util.*;

class Knapsack {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] val = new int[n];
        int[] wgt = new int[n];
        
        for(int i=0;i<val.length;i++){
            val[i] = scn.nextInt();
        }
        for(int j=0;j<wgt.length;j++){
            wgt[j] = scn.nextInt();
        }
        
        int W = scn.nextInt();
        int ans = knapsack(wgt,val,W,n);
        System.out.print(ans);

        scn.close();


    }
    
    public static int knapsack(int[] wgt, int[] val, int W, int n){
        int[][] dp = new int[n+1][W+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(wgt[i-1]<=j){
                dp[i][j] = Math.max((val[i-1]+dp[i-1][j-wgt[i-1]]),dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
            
        }
        return dp[n][W];
    }
}
