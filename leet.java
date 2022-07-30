// class Solution {
    
//   public static String compareStr(int j, String a, String[] words){
      
//       String ans = "";
      
//       // String str = "JavaisLove";
//       // System.out.println(str.contains("is"));  //true
      
      
//       for(int i=j+1;i<words.length;i++){
          
//           // if(a.length<words.length-1){
//               // System.out.println(words[i].length()-words[i+1].length() == words[i].lastIndexOf(words[i+1]));
//              // if(a.length()<words[i].length()){
//              //     // if(words[i+1].contains(words[i])){
//              //     //     ans+=words[i+1]+"#";
//              //     // }
//              //     continue;
//              // }
//              if(words[i].contains(words[i+1]) && words[i].length()-words[i+1].length() == words[i].lastIndexOf(words[i+1])){
//                   ans+=words[i]+"#";
//                   i++;
//              } 
//           else{
//               ans+=words[i]+"#";
//            }
//           // }
          
//           else{
//               ans+=words[i]+"#";
//           }
//       }
      
//       return ans;
      
//   }
//   public int minimumLengthEncoding(String[] words) {
//       Arrays.sort(words, Comparator.comparingInt(String::length));
      
//       String res = "";
      
//       for(int i=0;i<words.length-1;i++){
          
//           res = compareStr(i,words[i],words);
//       }
      
//       System.out.println(res);
//       return res.length();
      
//   }
// }


// // ["time","me","bell"]
// // ["t"]
// // ["feipyxx","e"]
// // ["p","grah","qwosp"]
// // ["ctxbhc","c"]


// class Solution {
    
//   public static String compareStr(int j, String a, String[] words,String res){
      
//       String ans = "";
      
//       // String str = "JavaisLove";
//       // System.out.println(str.contains("is"));  //true
      
//       if(words.length == 1){
//           return words[j]+" ";
//       }
//       for(int i=j+1;i<words.length;i++){
          
//           if(words[i].contains(a) && words[i].length()-a.length() == words[i].lastIndexOf(a)){
//                   ans+=words[i]+"#";
//                   // i++;
//              } 
//           else if(!res.contains(words[i])){
//               ans+=words[i]+"#";
//            }
//           else if(res.contains(words[i]) && words[i].length()-a.length() == words[i].lastIndexOf(a)){
//               ans+=words[i]+"#";
//           }
      
//       }
      
//       return ans;
      
//   }
//   public int minimumLengthEncoding(String[] words) {
//       Arrays.sort(words, Comparator.comparingInt(String::length));
      
//       String res = "";
      
//       for(int i=0;i<words.length-1;i++){
          
//           res += compareStr(i,words[i],words,res);
//           System.out.println(res);
//       }
      
//       // System.out.println(res);
//       return res.length();
      
//   }
// }


// // ["time","me","bell"]
// // ["t"]
// // ["feipyxx","e"]
// // ["p","grah","qwosp"]
// // ["ctxbhc","c"]