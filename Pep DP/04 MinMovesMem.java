
import java.util.*;

class MinMovesMem {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        
        int paths = MinMovesMemo(arr,0,n, new int[n+1]);
        System.out.println(paths);
        scn.close();
    }
    
    
    
    public static int MinMovesMemo(int[] arr, int idx, int n,int[] qb){
       int min = Integer.MAX_VALUE; 
       
       
       
        if(idx == n){
            return 0;
        }
        
        if(qb[idx] != 0){
            return qb[idx];
        }
        
        int count = 0;
        for(int jump=1;jump<=arr[idx] && jump+idx<=n;jump++){
            
            if(jump+idx <= n){
                System.out.println("Hello: "+idx);
                count = MinMovesMemo(arr,idx+jump,n,qb);
                // System.out.println("COunt: "+ count);
                if(count<min){
                    min = count;
                    // System.out.println("Min: "+ min);
                }
            }
            
        }
        
       
        
        // int ans = Math.min(count,min);
        if(min == Integer.MAX_VALUE){
            qb[idx] = min;
            return min;
        }
         
        
        int ans = min+1;
        qb[idx] = ans;
        
        return ans;
    }
    
    

}

/**
 * input
 * 10
3
3
0
2
1
2
4
2
0
0
 */

 /**
  * ouptut
  4
  */