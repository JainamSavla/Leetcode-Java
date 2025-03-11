
//Runtime 20ms Beats 32.34% Time Complexity = O(n)
//Memory 57.36 MB Beats 34.06% Space Complexity = O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // Create a HashSet to store unique numbers from the input array
        Set<Integer> set = new HashSet<>();
      
        for (int num : nums) {
            set.add(num);
        }
      // Create a LinkedList to store the missing numbers
        List<Integer> res = new LinkedList<>();
        
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res.add(i); 
            }
        }
        return res;
    }
}
//Runtime 7ms Beats 51.17%
//Memory 65.29 MB Beats 5.78% 
//Time Complexity: O(n)
//Space Complexity:
//O(1) (if we ignore the output list)
//O(n) (including the output list)
//Approach 2
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       for(int i = 0; i < nums.length; i++) {
    int current = Math.abs(nums[i]); // Get the absolute value to handle already-marked negatives
    int idx = current - 1;           // Convert number to corresponding index (0-based)

    // If the number at index 'idx' is already negative, it means it's already been visited.
    if (nums[idx] < 0) {
        continue; // Skip if already marked
    }

    // Mark the number at index 'idx' as visited by making it negative
    nums[idx] = -1 * nums[idx];
}

       List<Integer> res = new LinkedList<>();

for (int i = 0; i < nums.length; i++) {
    if (nums[i] > 0) {
        res.add(i + 1); // If the value is positive, it means the number (i + 1) was missing
    }
}
     return res;
    }
}
