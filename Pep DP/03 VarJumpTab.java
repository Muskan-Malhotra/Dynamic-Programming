import java.util.*;
/**
 * 
 * 
 * Time Complexity :
O(n2)

Here we are running to loops. Outerloop runs n times and the inner loop can run n times in the worst case. And within the inner loop, we are just adding hence we will get constant time. So it's O(n*n) = O(n2).

SPACE COMPLEXITY :
O(n)

Here we are just using one dp[] array of length n+1, to store the results. Thus the space complexity will be O(n+1) = O(n)
 */

class VarJumpTab {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int paths = countPathsTab(arr,n);
    System.out.println(paths);
    scn.close();
  }  

  public static int countPathsTab(int[] ar,int n){


    int[] dp = new int[n+1];
    dp[n] = 1;

    //loop from end of the array
    for(int i=n-1;i>=0;i--){
      //inner loop till the ar[i] element
      for(int jump=1;jump<=ar[i];jump++){

        //check if not outside the array
        if(jump+i<=n){
          // dp[i] += dp[i+1];
          dp[i] += dp[i+jump]; //correct one
        }
      }
    }

  //   for(int ele: dp){
  //     System.out.print(ele+" ");
  // }
    return dp[0];
  }
}