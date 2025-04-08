//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
//Approach -2 Binary Search
//Time Complexity: O(log n)
//Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Corrected mid calculation

            if (nums[mid] == target) {
                return mid; // Found target
            }

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Search in the left half
                } else {
                    low = mid + 1;  // Search in the right half
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // Search in the right half
                } else {
                    high = mid - 1; // Search in the left half
                }
            }
        }
        return -1; // Target not found
    }
}
