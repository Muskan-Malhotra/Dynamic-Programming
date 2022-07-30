import java.util.*;

class GoldmineMem {

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


        //base case is not required coz at the last column the ans is returned to main. and at last column it stops on its own!
        
        
        int gold1 = 0;   //0 is important not - infinity coz at ar[n-1][m-1] the golds amount will be -infinity and adding the last index to it, gives -infinity.
        int gold2 = 0;
        int gold3 = 0;
        
        if(qb[i][j] != 0){
            return qb[i][j];
        }
        
        
        if(i-1>=0 && j+1<ar[0].length){
            
            gold1 = goldM(ar,i-1,j+1,qb);
        }
        if(i+1<ar.length && j+1<ar[0].length ){
            
            gold2 = goldM(ar,i,j+1,qb);
        } 
        if(i+1<ar.length && j+1<ar[0].length){
            
            gold3 = goldM(ar,i+1,j+1,qb);
        } 
        
        //  System.out.println(ans+"_"+i); 
        int ans = ar[i][j]+Math.max(gold1,Math.max(gold2,gold3));
        
        // System.out.println(ans+"_"+i);
        qb[i][j] = ans;
        
        // System.out.println(ans+"_"+i+"-"+j);
        
        return ans;
    }
    
    

}