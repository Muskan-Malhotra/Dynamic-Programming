import java.util.*;

/**
 * 
 */

class MinMoves {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        
        int paths = MinMovesRec(arr,0,n);
        System.out.println(paths);
        scn.close();
    }
    
    
    
    public static int MinMovesRec(int[] arr, int idx, int n){

      //variable inside function so every level has its own fresh variable
       int min = Integer.MAX_VALUE; 
       
        if(idx == n){
            return 0;
        }
        
        int count = 0;
        for(int jump=1;jump<=arr[idx] && jump+idx<=n;jump++){
            
            if(jump+idx <= n){
                count = MinMovesRec(arr,idx+jump,n);
                // count += MinMoves(arr,idx+jump,n);
                //count should not be added coz at parent node we are not adding but finding the minimum of the chidlrens.
                
                if(count<min){
                    min = count;
                    // System.out.println("Min: "+ min);
                }
            }
            
        }
        
       
        
        // int ans = Math.min(count,min);
        if(min == Integer.MAX_VALUE){
            // qb[idx] = min;
            // min = 0; is wrong as the min value should refresh to infinety
            return min;
        }
         
        
        return min+1;
    }
    
    

}