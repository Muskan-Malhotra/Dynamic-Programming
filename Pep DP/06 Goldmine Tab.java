import java.util.*;

/**
 * Meaning of cell : max gold dig so far dp[i][j]
 * Last column has the smallest problem
 * column wise travelling
 * Time Complexity :
O(n2)

This time complexity is quadratic because nested loops are used.

SPACE COMPLEXITY :
O(n2)

Since we use a 2D array for Dynamic Programming, therefore the space used is of complexity n2.

We encourage you to watch the video "Goldmine" for a clearer explanation of this problem.


 */

class GoldmineTab{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] ar = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ar[i][j] = scn.nextInt();
            }
        }
        
        int fans = goldM(ar);
       
        System.out.println(fans);
        
        scn.close();
        
    }
    
    public static int goldM(int[][] ar){
        
        int[][] dp = new int[ar.length][ar[0].length];
        
        for(int j = ar[0].length-1; j>=0;j--){
            for(int i=ar.length-1;i>=0;i--){
                
                
                if(j == ar[0].length-1){
                    dp[i][j] = ar[i][j];
                }
                
                //first row
                else if(i==0){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + ar[i][j];
                }
                //last row
                else if(i == ar.length-1){
                    dp[i][j] = Math.max(dp[i-1][j+1],dp[i][j+1]) + ar[i][j];
                }
                //remaining 
                else{
                    dp[i][j] = Math.max(dp[i-1][j+1],Math.max(dp[i][j+1],dp[i+1][j+1])) + ar[i][j];
                }
            }
        }
        
        int max = dp[0][0];
        
        for(int i=0;i<dp.length;i++){
                
          if(dp[i][0]>max){
              max = dp[i][0];
          }
        
        }
        
        return max;
       
    }
    
    

}