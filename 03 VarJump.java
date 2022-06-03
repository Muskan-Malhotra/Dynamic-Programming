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

  //path is curated when the index goes to n+1. That path is counted
  public static int countPaths(int[] ar, int idx, int n, String psf){

    if(idx == n){
      return 1;
    }
    int count = 0;
    for(int jump = 1; jump <= ar[idx]; jump++){
      if((jump+idx)<n){
        count += countPaths(ar, idx+jump, n, psf+idx);
      }
      else{
        break; // if the jump is outside the array then break from loop for that index
      }
    }

      return count;


  }

  
}


