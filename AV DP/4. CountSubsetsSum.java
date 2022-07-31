
//on gfg its perfect sum
/**
 * Expected Time Complexity: O(N*sum)
Expected Auxiliary Space: O(N*sum)
 */
class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int ans = subsetSum(arr,n,sum);
	   //// System.out.println(ans);
	   // System.out.println(ans%1000000007);
	    return ans;
	    
	} 
	
	public static int subsetSum(int[] arr, int n, int sum){
	    int[][] dp = new int[n+1][sum+1];
	    
	    for(int i=0;i<dp.length;i++){
	        for(int j=0;j<dp[0].length;j++){
	            if(i==0 && j==0){
	                dp[i][j] = 1;
	            }
	            else if(i==0){
	                dp[i][j] = 0;
	            }
	           // else if(j==0){
	           //     dp[i][j] = 1;
	           // }
	            else{
	                if (arr[i - 1] <= j)
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arr[i - 1]])%1000000007;
 
                    else
                    {
                        dp[i][j] = dp[i-1][j];
                    }
	            }
	        }
	    }
	    
	    for(int i=0;i<dp.length;i++){
	        for(int j=0;j<dp[0].length;j++){
	            System.out.print(dp[i][j] + " ");
	        }
	        System.out.println();
	    }
	    return dp[n][sum];
	}
}

/**
 * 10 31  //it has 0
9 7 0 3 9 8 6 5 7 6
*/
//2 3 5 0 8 10
/** with filling j == 0 as 1
 * 1 0 0 0 0 0 0 0 0 0 0 
1 0 1 0 0 0 0 0 0 0 0 
1 0 1 1 0 1 0 0 0 0 0 
1 0 1 1 0 2 0 1 1 0 1 
1 0 2 2 0 4 0 2 2 0 2 
1 0 2 2 0 4 0 2 3 0 4 
1 0 2 2 0 4 0 2 3 0 5 
5
*/
/**
 * without filling j==0 as 1
 * 1 0 0 0 0 0 0 0 0 0 0 
1 0 1 0 0 0 0 0 0 0 0 
1 0 1 1 0 1 0 0 0 0 0 
1 0 1 1 0 2 0 1 1 0 1 
2 0 2 2 0 4 0 2 2 0 2 
2 0 2 2 0 4 0 2 4 0 4 
2 0 2 2 0 4 0 2 4 0 6 
6
 */