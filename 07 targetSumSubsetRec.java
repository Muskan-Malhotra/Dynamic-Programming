import java.io.*;


class targetSum {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(br.readLine());
        }
        
        int tar = Integer.parseInt(br.readLine());
        
        boolean ans = tarSS(ar,0,0,tar);
        System.out.println(ans);

    }
    
    public static boolean tarSS(int[] ar, int i, int sum, int tar){
        
        boolean res = false;
        
        if(i == ar.length){
            if(sum == tar ){
                return true;
            }
            return res;
        }
        
        boolean ans = tarSS(ar,i+1,sum+ar[i],tar);
        
        boolean ans1 = tarSS(ar,i+1,sum,tar);
        
        // System.out.println(ans);
        // System.out.println(ans1);
        if(ans1 || ans || res){
            // System.out.println("printing");
            return true;
        }
        
        return res;
    }
}