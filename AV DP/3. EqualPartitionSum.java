
/**
 * Time Complexity: O(sum*n) 
*  Auxiliary Space: O(sum*n) 
 */

class EqualSUmPartition {

  public boolean canPartition(int[] nums) {
      int sum  = 0;
      
      for(int i=0;i<nums.length;i++){
          sum += nums[i];
      }
      
      if(sum%2 == 0){
          return subsetSum(nums,sum/2,nums.length);
      }
      
      return false;
      
  }
  
  public static boolean subsetSum(int[] arr, int sum,int n){
      
      
      boolean[][] dp = new boolean[n+1][sum+1];
      
      for(int i=0;i<dp.length; i++){
          for(int j=0;j<dp[0].length;j++){
              
              if(i==0 && j == 0){
                  dp[i][j] = true;
              }
              else if(i==0){
                  dp[i][j] = false;
              }
              else if(j==0){
                  dp[i][j] = true;
              }
              else{
                 if(arr[i-1]<=j){
                     dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                 } 
                  else{
                      dp[i][j] = dp[i-1][j];
                  }
              }
              
          }
      }
      
      return dp[n][sum];
  }
  }

  /**
   * arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.
   */