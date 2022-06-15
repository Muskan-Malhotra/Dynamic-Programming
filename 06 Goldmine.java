
import java.util.*;

class  Goldmine{

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
        
        int fans = Integer.MIN_VALUE;
        
        // int[][] qb = new int[n+1][m+1];
        for(int i=0;i<ar.length;i++){
            
            int ans = goldMine(ar,i,0,0);
            
            System.out.println(ans);
            
            if(ans>fans){
                fans = ans;
            }
        }
        System.out.println(fans);
        
        scn.close();
    }
    
    public static int goldMine(int[][] ar, int i, int j, int ans){
        
        if(j==ar.length-1){
            // System.out.println(i+"-"+(j));
            return ar[i][j];
        }
        
        int gold1 = Integer.MIN_VALUE;
        int gold2 = Integer.MIN_VALUE;
        int gold3 = Integer.MIN_VALUE;
        
        
        if(i-1>=0){
            
            gold1 = goldMine(ar,i-1,j+1,ans);
        }
        if(j+1<ar[0].length){
            
            gold2 = goldMine(ar,i,j+1,ans);
        } 
        if(i+1<ar.length && j+1<ar[0].length){
            
            gold3 = goldMine(ar,i+1,j+1,ans);
        } 
        
        //  System.out.println(ans+"_"+i); 
        ans = ar[i][j]+Math.max(gold1,Math.max(gold2,gold3));

        //even if ans += ... then also same ans coz everywhere the ans will be marked 0 for every tree like traversal
        
        // System.out.println(ans+"_"+i);
        
        return ans;
    }
    
    

}