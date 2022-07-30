
import java.util.*;

class GoldMine {

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
        
        int fans = 0;
        
        int[][] qb = new int[n+1][m+1];
        for(int i=0;i<ar.length;i++){
            
            
            int ans = goldM(ar,i,0,qb);
            
            // System.out.println(ans);
            
            if(ans>fans){
                fans = ans;
            }
        }
        System.out.println(fans);
        
        scn.close();
    }
    
    public static int goldM(int[][] ar, int i, int j, int[][] qb){


      if(i<0 || i == ar.length || j == ar[0].length){
        return 0;
      }
          
        
      if(qb[i][j] != 0){
          return qb[i][j];
      }
      
      
      int i1 = goldM(ar,i-1,j+1,qb);
      int i2 = goldM(ar,i,j+1,qb);
      int i3= goldM(ar,i+1,j+1,qb); 
      
      //  System.out.println(ans+"_"+i); 
      int ans = ar[i][j]+Math.max(i1,Math.max(i2,i3));
      
      // System.out.println(ans+"_"+i);
      qb[i][j] = ans;
      
      // System.out.println(ans+"_"+i+"-"+j);
      
      return ans;
    }
    
    

}