//0026 Remove Duplicates from Sorted Array
//Runtime 0 ms Beats 100.00%
class Solution {
    public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0; // Handle empty case

    int k = 1; // Start from index 1 (nums[0] is always unique)

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) { 
            nums[k] = nums[i];
            k++;
        }
    }

    return k;
  }
}
