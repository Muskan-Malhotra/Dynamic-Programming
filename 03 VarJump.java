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


