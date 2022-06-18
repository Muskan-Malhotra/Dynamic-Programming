import java.util.*;

class VarJump {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int paths = countPaths(arr, 0, n,"");
    System.out.println(paths);
    scn.close();
    
  }
  // static int count = 0;

  //path is curated when the index goes to n+1. That path till n is counted
  public static int countPaths(int[] ar, int idx, int n, String psf){

    if(idx == n){
      return 1;
    }
    int count = 0;
    for(int jump = 1; jump <= ar[idx]; jump++){
      if((jump+idx)<n){
        count += countPaths(ar, idx+jump, n, psf+idx);
        //in this if count is added in the recursion call then count will change every 0 value of count while pre order and in post order will add the post order sum .. every time a post order count is encountered it will change count of the parent will travel to children changing their count and in post again change the parent count!!
      }
      else{
        break; // if the jump is outside the array then break from loop for that index
      }
    }

      return count;


  }

  
}




/**
 * CORRECT VERSION
 * import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = scn.nextInt();
        }
        
        int ans = varJumps(ar,0, n);
        System.out.println(ans);
    }
    
    // public static int count = 0;
    
    public static int varJumps(int[] ar, int idx, int n){
        
        if(idx == n){
            return 1;
        }
        if(idx>n){
            return 0;
        }
        
        int count = 0;
        
        for(int jump=1;jump<=ar[idx];jump++){
            if(jump+idx<=n){
                // System.out.println("Count: "+count);
                count += varJumps(ar,idx+jump,n);
                // System.out.println("Count: "+count+" Index: "+jump);
            }
            else{
                // System.out.println("Count: "+count+" "+jump);
                break;
            }
        }
        
        return count;
    }

    INPUT 4
    3 2 2 1
    OUTPUT 
    6
    
    // Count: 0
// Count: 0
// Count: 0 Index: 1
// Count: 0
// Count: 0
// Count: 1 Index: 1
// Count: 1
// Count: 1 Index: 2
// Count: 1
// Count: 2 Index: 3
// Count: 2 Index: 1
// Count: 2
// Count: 4 Index: 2
// Count: 4
// Count: 4
// Count: 5 Index: 1
// Count: 5
// Count: 9 Index: 3
// 9
    
    

    
    
    
    

}
 */


 /**2.222222222222222
  * Jab global count jo function mein paas hoga toh wo apni value pre time pe hi change kar dega!!!
  Ismein yeh global variable ki tarah kaam kar raha hai!!

  public static int varJumps(int[] ar, int idx, int n,int count){
        
        if(idx == n){
            return 1;
        }
        if(idx>n){
            return 0;
        }
        
       
        
        for(int jump=1;jump<=ar[idx];jump++){
            if(jump+idx<=n){
                // System.out.println("Count: "+count);
                count += varJumps(ar,idx+jump,n,count);
                // System.out.println("Count: "+count+" Index: "+jump);
            }
            else{
                // System.out.println("Count: "+count+" "+jump);
                break;
            }
        }
        
        return count;
    }

    input 3
    322
    output 6
  */



  /**
   * WHEN THE FUNCTION IS LIKE THIS
   * COUNT KI VALUE WAY UP MEIN CHANGE HI NAHI HUI REMAINS 0 COZ ANS = 0; C=A = 0
   * ANS NE SAME RULE FOLLOW LIYA AS A SIMPLE RECUSRION WITHOUT EXTRA COUNT VARIABLE IN CALL
   * 
   * count ke na hone se bhi will be getting the same ans
   * public static int varJumps(int[] ar, int idx, int n,int count){
        
        if(idx == n){
            return 1;
        }
        if(idx>n){
            return 0;
        }
        
       int ans = 0;
        
        for(int jump=1;jump<=ar[idx];jump++){
            if(jump+idx<=n){
                // System.out.println("Count: "+count);
                ans += varJumps(ar,idx+jump,n,count+ans);
                System.out.println("ans: "+ans+"Count: "+count+" Index: "+jump);
            }
            else{
                // System.out.println("Count: "+count+" "+jump);
                break;
            }
        }
        
        return ans;
    }
   */
