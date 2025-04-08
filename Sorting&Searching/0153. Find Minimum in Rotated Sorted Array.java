//time complexity:O(nlogn)
//Space Complexity:O(logn)
class Solution {
    public int findMin(int[] nums) {
       Arrays.sort(nums);
       return nums[0];
    }
}
