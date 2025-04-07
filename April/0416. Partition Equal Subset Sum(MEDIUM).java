//Time Complexity: O(n×target)
//Space Complexity: O(target)
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        // Compute the total sum
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the sum is odd, we cannot partition it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // Base case: sum 0 is always possible
        
        for (int num : nums) {
            for (int i = target; i >= num; i--) {  // Traverse backwards
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        return dp[target];
    }
}
