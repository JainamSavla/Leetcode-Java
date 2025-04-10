//Time Complexity:O(n log n)
//Space Complexity:O(n)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
          List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }
}
//Approach-2
//Time Complexity:O(n)
//Space Complexity:O(1)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanTarget = 0;  // Count of numbers less than target
        int count = 0;  // Count of occurrences of target

        // Count elements < target and occurrences of target
        for (int n : nums) {
            if (n == target) {
                count++;
            } else if (n < target) {
                lessThanTarget++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        // Add indices starting from lessThanTarget and continuing count times
        for (int i = 0; i < count; i++) {
            ans.add(lessThanTarget + i);
        }

        return ans;
    }
}
