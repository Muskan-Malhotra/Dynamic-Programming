
import java.util.*;


class MinCostPathTab {

    public static void main(String[] args) throws Exception {
        // write your code here
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int m = Integer.parseInt(br.readLine());
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] ar = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ar[i][j] = scn.nextInt();
            }
        }
        
        
        
        int ans = MazePath(ar);
        System.out.println(ans);
    }
    
    public static int MazePath(int[][] ar){
        
        int dp[][] = new int[ar.length][ar[0].length];
        
        for(int i=ar.length-1;i>=0;i--){
            for(int j=ar[0].length-1;j>=0;j--){
                
                //4 cases
                
                // 1 case if i and j are at dest
                if(i == ar.length-1 && j == ar[0].length-1){
                 dp[i][j]= ar[i][j];   
                }
                //when the i in last row
                else if(i==ar.length-1){
                    dp[i][j] = dp[i][j+1]+ar[i][j];

                    //dp[][] values should be taken care of here!!
                }
                // when j in last column
                else if(j == ar[0].length-1){
                    dp[i][j] = dp[i+1][j]+ar[i][j];
                }
                //the remaining matrix
                else{
                    dp[i][j] =  Math.min(dp[i][j+1],dp[i+1][j])+ar[i][j];
                }
            }
        }
        
        // System.out.println(dp[0][0]);
        
        // for(int i=0;i<ar.length;i++){
        //     for(int j=0;j<ar[0].length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        
        return dp[0][0];
    }
    
   
    

}

// 4
// 4
// 2 3 0 2
// 1 4 5 2
// 3 1 3 1
// 4 2 2 0

