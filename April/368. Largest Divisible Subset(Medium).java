//Time Complexity: O(n²)
//Space Complexity:O(n)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Step 1: Sort the array in ascending order
        // Sorting helps ensure that for any pair (nums[i], nums[j]), nums[i] >= nums[j]
        Arrays.sort(nums);

        // Step 2: Create DP and previous index tracking arrays
        int[] dp = new int[nums.length]; // dp[i] stores the length of the largest divisible subset ending at index i
        int[] prev = new int[nums.length]; // prev[i] stores the previous index of nums[i] in the subset sequence

        // Step 3: Initialize the DP array to 1 (every number alone is a subset of size 1)
        Arrays.fill(dp, 1);
        
        // Initialize prev array to -1 (indicating no previous element for now)
        Arrays.fill(prev, -1);

        // Variable to track the index of the largest subset found
        int maxi = 0;

        // Step 4: Build the DP table to find the largest divisible subset
        for (int i = 1; i < nums.length; i++) { // Iterate over each element
            for (int j = 0; j < i; j++) { // Compare nums[i] with all previous elements
                // If nums[i] is divisible by nums[j] and the subset size increases
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;  // Update the largest subset size ending at i
                    prev[i] = j;  // Store the index of the previous element in the subset
                }
            }
            // Update maxi if the current subset size is the largest found so far
            if (dp[i] > dp[maxi]) maxi = i;
        }

        // Step 5: Reconstruct the largest divisible subset using the prev array
        List<Integer> res = new ArrayList<>();
        for (int i = maxi; i >= 0; i = prev[i]) {  
            // Start from the maximum subset index and backtrack using the prev array
            res.add(nums[i]);
            if (prev[i] == -1) break; // Stop when there is no previous element
        }

        return res; // Return the final subset
    }
}
