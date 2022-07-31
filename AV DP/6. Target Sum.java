/**
 * 
 * Expected Time Complexity: O(N*sum), where sum refers to the range of sum possible.
Expected Auxiliary Space: O(N).
 */

class TargetSum {
  static int findTargetSumWays(int[] nums , int N, int diff) {
      int sum = 0;
      for(int ele:nums){
          sum += ele;
      }
      // System.out.print(sum);
      int s1 = (diff+sum)/2;
      if((sum+diff)%2 != 0){
          return 0;
      }
      return countSubsetSum(nums,s1);
      
  }
  
  public static int countSubsetSum(int[] arr, int sum){
      int n = arr.length;
      int[][]dp = new int[n+1][sum+1];
      
      for(int i=0;i<dp.length;i++){
          for(int j=0;j<dp[0].length;j++){
              
              if(i==0 && j==0){
                  dp[i][j] = 1;
              }
              else if(i==0){
                  dp[i][j] = 0;
              }
              else{
                  if(arr[i-1]<=j){
                      dp[i][j] = dp[i-1][j-arr[i-1]]+dp[i-1][j];
                  }
                  else{
                      dp[i][j] = dp[i-1][j];
                  }
              }
              
          }
      }
      return dp[n][sum];
      
      
  }
};

/**
 * Input:
N = 5
A[] = {1, 1, 1, 1, 1}
target = 3
Output:
5
Explanation:
There are 5 ways to assign symbols to 
make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:

Input:
N = 1
A[] = {1}
target = 1
Output:
1
*/