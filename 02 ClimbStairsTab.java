import java.io.*;
/**
 * Same as print maze path
 * Time complexity: O(n)
 * Space: O(n)
 */

class ClimbStairsTab{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    
    int ans = CStairsTab(n);
    
    System.out.println(ans);
  }

  public static int CStairsTab(int n){

    int dp[] = new int[n+1];
    dp[0] = 1;

    for(int i=1;i<=n;i++){
      if(i==1){
        dp[i] = dp[i-1];
      }
      else if(i==2){
        dp[i] = dp[i-1]+dp[i-2];
      }
      else{
        dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
      }
    }

    return dp[n];
    //ans at the end of the dp

  }
    


}