import java.io.*;


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
    
    count += 1;
    int fibn = fibo(n-1)+fibo(n-2);
    qb[n] = fibn;

    return fibn;
  }


}