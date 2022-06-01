import java.io.*;

/**
 * In fibonacci
 * Memoization approach stores the ans of the questions whose value have already been calculated
 * A question bank qb[n+1](cox need to store values till n) is captured.
 * then check is qb[n] !=0 then return
 * else call the function fiboMem
 * save in qb[n] - fibn for next iteration and return fibn
 * Time: O(n) 
 * W/o qb Time: O(2^n exponential time)
 * Space: O(n)  
 */


class Fibonacci{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] qb = new int[n+1];
    int ans = fiboMem(n, qb);
    // int ans = fibo(n);
    System.out.println(ans);
  }

  static int count = 0;
  public static int fibo(int n){
    if(n == 0 || n == 1){
      return n;
    }
    //can try Sys.ln("Hello" + n);
    int fibn = fibo(n-1)+fibo(n-2);

    return fibn;
  }
///Memoisation
  public static int fiboMem(int n, int[] qb){
    if(n == 0 || n == 1){
      return n;
    }

    if(qb[n] != 0){
      return qb[n];
    }
    

    //reduces the number of time the call have been made
    System.out.println("Hello: "+n);

    int fibn1 = fiboMem(n-1,qb);
    int fibn2 = fiboMem(n-2,qb);
    int fibn = fibn1 + fibn2;

    qb[n] = fibn;

    return fibn;
  }


}