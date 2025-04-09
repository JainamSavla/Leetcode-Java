//Time complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            
            if(mid%2==0){
                if(mid + 1 < nums.length && nums[mid] == nums[mid + 1]){
                low=mid+2;
                }else{
                    high=mid-2;
                }
            }
            else{
                if(nums[mid]==nums[mid-1]){
                 low=mid+1;
                }
                else{
                  high = mid - 1;
                }
            }
        }
        return nums[low];
    }
}
