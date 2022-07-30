// import java.io.*;
import java.util.*;

class Mem {

  public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
    Integer[][] dp = new Integer[profits.length][capacity + 1];
    return knapsackRecursive(dp, profits, weights, capacity, 0);
  }

  private static int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity,
      int currentIndex) {

    // base checks
    if (capacity <= 0 || currentIndex >= profits.length)
      return 0;

    // if we have already solved a similar problem, return the result from memory
    if(dp[currentIndex][capacity] != null)
      return dp[currentIndex][capacity];

    // recursive call after choosing the element at the currentIndex
    // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
    int profit1 = 0;
    if( weights[currentIndex] <= capacity )
        profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                capacity - weights[currentIndex], currentIndex + 1);

    // recursive call after excluding the element at the currentIndex
    int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

    dp[currentIndex][capacity] = Math.max(profit1, profit2);
    return dp[currentIndex][capacity];
  }

  public static void main(String[] args) {
    // Knapsack ks = new Knapsack();
    Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] weights = new int[n];
        int[] profits = new int[n];
        
        for(int i=0;i<n;i++){
            profits[i] = scn.nextInt();
            
        }
        for(int i=0;i<n;i++){
            weights[i] = scn.nextInt();
            
        }
        
        
        int capacity = scn.nextInt();
    Integer[][] dp = new Integer[profits.length][capacity + 1];
    System.out.println(knapsackRecursive(dp, profits, weights, capacity, 0));
    scn.close();
  }
}
