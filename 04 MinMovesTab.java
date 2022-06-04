
import java.util.*;

/**
 * Time Complexity :
O(n2)

Here we are running to loops. Outerloop runs n times and the inner loop can run n times in the worst case. And within the inner loop, we are just adding hence we will get constant time. So it's O(n*n) = O(n2).
SPACE COMPLEXITY :
O(n)

Here we are just using one dp[] array of length n+1, to store the results. Thus the space complexity will be O(n+1) = O(n)

 */

class MinMovesTab{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        
        int paths = MinMovestab(arr,n);
        System.out.println(paths);
        scn.close();
    }
    
    
    
    public static int MinMovestab(int[] arr,int n){
      
      int dp[] = new int[n+1];
      dp[n]=0;
      
      for(int i=n-1;i>=0;i--){
          int min = Integer.MAX_VALUE;
          for(int jump = 1;jump<=arr[i] && jump+i<=n;jump++){
             
             int it = jump+i;
             //this is the intermediate step for 1,2 and 3 from src 0
             if(dp[it]<min){
                 min=dp[it];
             }
              
          }
          if(min != Integer.MAX_VALUE){
              dp[i] = min+1;
          }
          else{
              dp[i] = Integer.MAX_VALUE;
          }
      }
      
    //   for(int ele:dp){
    //       System.out.print(ele+" ");
    //   }
      
      return dp[0];
    
    }

}