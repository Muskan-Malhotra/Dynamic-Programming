

class MaxSumSubarray {
	
	public static long maxSubarraySum(int[] nums, int n) {
		// write your code here
        long curSum = 0;
        long maxSum = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            curSum = curSum+nums[i];
            
            
//             System.out.println(maxSum);
            if(curSum<0){
                curSum = 0;
            }
            maxSum = Math.max(curSum,maxSum);//will work for negatives as well
        }
        
        return maxSum;
    
	}

}
