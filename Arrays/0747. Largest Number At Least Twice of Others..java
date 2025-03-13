//0747. Largest Number At Least Twice of Others
//Runtime 0 ms Beats 100.00% TIME COMPLEXITY:O(n)
//Memory 41.52 MB Beats 56.86% SPACE COMPLEXITY:O(1)
class Solution {
    public int dominantIndex(int[] nums) {
        int idx=-1;
        int max1=-1;
        int max2=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>max1){
                max2=max1;
                max1=nums[i];
                idx=i;
            }
            else if(nums[i]>max2){
                max2=nums[i];
            }
        }
        return max1>=(2*max2)? idx:-1;
    }
}
