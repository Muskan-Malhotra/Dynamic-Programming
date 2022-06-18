class testrec {

  public static void main(String[] args) {
    int n = 3;
    int ans = fact(0,0,n);
    System.out.println(ans);
  }

  public static int fact(int i, int ans, int n){

    if(i==n-1){
      System.out.println("ptt:"+ ans+" "+i);
      return ans;
    }
    System.out.println(ans+" "+i);
    int ans2 = fact(i+1,ans+i,n);
    System.out.println("ptt2:"+ ans2+" "+i);
    int ans3 = fact(i+1,ans,n);
    System.out.println("ptt3:"+ ans3+" "+i);
    // ans += fact(i+1,ans+i,n);
    // ans += fact(i+1,ans,n);
    

    return ans2+ans3;
  }
}