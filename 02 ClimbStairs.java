import java.io.*;


class ClimbStairs{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] qb = new int[n+1];
    // int ans = fiboMem(n, qb);
    CStairs(n,0,"");
    // System.out.println(ans);
  }

  // static void count = 0;
  //here, n is the destination
  public static void CStairs(int n, int src,String psf ){
    if(src==n){
      System.out.println(psf);
      return;
    }
    

    for(int jumps = 1; jumps<=n; jumps++){
      CStairs(n,src+jumps,psf+"1");
      CStairs(n,src+jumps+1,psf+"2");
      CStairs(n,src+jumps+2,psf+"3");
    }
    


  }

}