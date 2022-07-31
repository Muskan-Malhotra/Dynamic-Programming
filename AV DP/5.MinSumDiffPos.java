/**
Sum package AV DP;

public class 5.MinSumDiffPos {
  
}* Expected Time Complexity: O(N*|sum of array elements|)
*  Expected Auxiliary Space: O(N*|sum of array elements|)
 */
import java.util.*;
class MinimumSumDiffernce
{

	public int minDifference(int nums[], int n) 
	{ 
	   
        int range = 0;
        
        // if(nums.length<2){
        //     return nums[0];
        // }
        // if(nums.length == 2){
        //     if(nums[0] <0){
        //         nums[0] = Math.abs(nums[0]);
        //     }
        //     else if(nums[1]<0){
        //          nums[1] = Math.abs(nums[1]);
        //     }
        //     return nums[0]+nums[1];
        // }
        
        
        for(int ele:nums){
            range += ele;
        }
        
        // if(range<0){
        //     return 0;
        // }
        
        // int n = nums.length;
        
        
        
        boolean[][] dp = new boolean[n+1][range+1];
        
        subsetSum(nums,range,n,dp);
        ArrayList<Integer> al = new ArrayList<>();
        for(int j=0;j<dp[0].length;j++){
            if(dp[n][j] == true){
                al.add(j);
            }
        }
        // System.out.print(al);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<=al.size()/2;i++){
            
            int ele = range-al.get(i);
            // System.out.print(range+"-"+al.get(i)+"="+ele+" ");
            if(al.get(i)-ele < min){
                min = Math.abs(ele-al.get(i));
            }
        }
        
        return min;
        
    }
    
    public static void subsetSum(int[] ar,int range, int n,boolean[][] dp){
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                else if(j==0){
                    dp[i][j] = true;
                }
                else{
                    if(ar[i-1]<=j){
                        dp[i][j] = dp[i-1][j-ar[i-1]] || dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        
        return;
    }
}

/**
 * Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4
*/