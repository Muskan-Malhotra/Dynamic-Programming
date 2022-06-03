import java.util.*;

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

    for(int i=n-1;i>=0;i--){
      for(int jump=1;jump<=ar[i];jump++){

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