/**
 * Complexity Analysis: The above solution may try all subsets of given set in worst case. Therefore time complexity of the above solution is exponential.
 */

class SubsetSum{


  static Boolean isSubsetSum(int N, int arr[], int sum){
      // code here
      
      boolean[][] dp = new boolean[N+1][sum+1];
      
      for(int i=0;i<dp.length;i++){
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
      
      return dp[N][sum];
  }
}

/**
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
 */