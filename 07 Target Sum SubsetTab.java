
import java.util.*;

class Target {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(br.readLine());
        }
        
        int tar = Integer.parseInt(br.readLine());
        
        boolean ans = tarSS(ar,tar);
        System.out.println(ans);

    }
    
    public static boolean tarSS(int[] ar,int tar){
        
        
        int n = ar.length+1;
        int m = tar+1;
        boolean[][] dp = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    dp[i][j] = false;
                }
                else if(j==0){
                    
                    dp[i][j] = true;
                }
                else{
                    //batting is no
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }
                    else{
                        int val = ar[i-1];
                        //now batting == yes
                        if(j>=val){
                            if(dp[i-1][j-val] == true){
                                //baaki ki team ne baaki ke run score kar diye
                                dp[i][j] = true;
                            }
                            else{
                                dp[i][j] = false;
                            }
                        }
                        
                    }
                }
            }
        }
        
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        return dp[n-1][m-1];
        
    } 
        
        
        
        
        
        
        
}