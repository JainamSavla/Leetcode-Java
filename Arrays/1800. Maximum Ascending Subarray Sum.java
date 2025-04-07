//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=nums[0];
        int currentsum=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                currentsum+=nums[i];
            }else{
                currentsum=nums[i];
            }
            max=Math.max(currentsum,max);
        }
        return max;
    }
}
