//724. Find Pivot Index
//Runtime 1ms Beats 93.60% Time Complexity:O(N)
//Memory 45.35MB Beats 76.54% Space Complexity:O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        int rightsum=0;
        for(int i=0;i<nums.length;i++){
            rightsum+=nums[i];
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            if(leftsum==rightsum-nums[i]){
                return i;
            }
            leftsum+=nums[i];
            rightsum-=nums[i];
        }
        return -1;
    }
}
