
import java.util.*;

class MinCPMemo {

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
        
        int[][] qb = new int[n+1][m+1];
        
        int ans = MazePath(ar,0,0,0,qb);
        System.out.println(ans);

        scn.close();
    }
    
    public static int MazePath(int[][] ar, int i, int j,int ans,int[][] qb){
        
        if(i==ar.length-1 && j==ar[0].length-1){
            
            // return ans;
            return ar[i][j];
        }
        int h = Integer.MAX_VALUE;
        int v = Integer.MAX_VALUE;
        // int h = 0;
        // int v = 0;
        
        if(qb[i][j] != 0){
            return qb[i][j];
            
        }
        
        //horizontal move
        if(j+1<ar[0].length){
            h = MazePath(ar,i,j+1,ans,qb);
            // System.out.println("h: "+h);
        }
        
        //vartical move
        if(i+1<ar.length){
            v = MazePath(ar,i+1,j,ans,qb);
            // System.out.println("v: "+v);
        }
        
        ans = ar[i][j]+Math.min(h,v);
        // System.out.println(ans);
        
        qb[i][j] = ans;
        
        return ans;
    }

}

// 4
// 4
// 2 3 0 2
// 1 4 5 2
// 3 1 3 1
// 4 2 2 0