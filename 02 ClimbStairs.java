import java.io.*;
/**
 * Same as print maze path
 * Time complexity: O(n)
 * Space: O(n)
 */

class ClimbStairs{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] qb = new int[n+1];
    int ans = CStairsMem(n, qb);
    // int ans = CStairs(n);
    System.out.println(ans);
  }

  // static void count = 0;
  //here, n is the destination
  public static int CStairs(int n){

    if(n==0){
      return 1;
    }
    if(n<0){
      return 0;
    }
    
    System.out.println("Hello: "+ n);
    int nm1 = CStairs(n-1);
    int nm2 = CStairs(n-2);
    int nm3 = CStairs(n-3);

    int ans = nm1+nm2+nm3;

    return ans;


  }
  public static int CStairsMem(int n,int[] qb){

    if(n==0){
      return 1;
    }
    if(n<0){
      return 0;
    }
    
    

    if(qb[n] != 0){
      return qb[n];
    }
    System.out.println("Hello: "+ n);
    int nm1 = CStairsMem(n-1,qb);
    int nm2 = CStairsMem(n-2,qb);
    int nm3 = CStairsMem(n-3,qb);

    int ans = nm1+nm2+nm3;

    qb[n] =  ans;

    return ans;


  }

}