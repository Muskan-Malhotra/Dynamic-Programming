import java.util.*;

class Coin {

  public static void main(String[] args) throws Exception {
        
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] ar = new int[n];
    
    for(int i=0;i<n;i++){
        ar[i] = scn.nextInt();
    }
    
    int tar = scn.nextInt();
    
   int count =  TarSum(ar,tar,0,0,"");
    System.out.println(count);
    scn.close();

}

public static int TarSum(int[] ar,int tar,int j,int count,String psf){
        
  int ans = 0;
  if(j==ar.length)
  {   
  // System.out.println(count);
      return 0;
  }
  if(tar == 0){
      ans++;
      // System.out.println(tar+" "+j+" "+count+" "+psf);
      // System.out.println(ans);
      return ans;
  }
      
  // }
  
  if(tar<0){
      // System.out.println(tar+" "+j+" "+count+" "+psf);
      return 0;
  }
  
  for(int i=j;i<ar.length;i++){
      // System.out.println(tar+" "+j+" "+count+" "+psf);
      ans += TarSum(ar,tar-ar[i],j,count++,psf+ar[i]);
      // System.out.println("post"+tar+" "+j+" "+count+" "+psf);
  }
  
  
  
  return ans;
}

  
}