// import java.io.*;
import java.util.*;

class knap01 {
    // static int maxwgt = 0;
    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] wgt = new int[n];
        int[] val = new int[n];
        
        for(int i=0;i<n;i++){
            wgt[i] = scn.nextInt();
            
        }
        for(int i=0;i<n;i++){
            val[i] = scn.nextInt();
            
        }
        
        // for(int ele:val){
        //     System.out.println(ele+" ");
        // }
        
        int cap = scn.nextInt();
        
        int ans = dp(n,wgt,val,0,0,0,cap);
        System.out.print(ans);
        scn.close();
    }
    
    public static int dp(int n, int[] wgt, int[] val, int cap, int i, int sum, int ocap){
        int max = 0;
        if(cap>ocap || i>n){
            // System.out.println("1st if:"+cap+" "+i+" " +sum);
            return 0;
        }
        
        if(cap<=ocap && i==n){
            // System.out.println(cap+" "+i+" "+sum);
            if(max<sum){
                max = sum;
            }
            return max;
        }
        
        int left = dp(n,wgt,val,cap+val[i],i+1, sum+wgt[i], ocap);
        
        int right = dp(n,wgt,val,cap,i+1,sum,ocap);
        
        
        
        int ans = Math.max(left,right);
        
        return ans;
        
        
    }
}