//Runtime 3 ms Beats 61.29%
//Memory 62.67 MB Beats 19.89% 
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;  // No valid triplet exists

        // Step 1: Compute prefix maxBefore[i]
        int[] maxBefore = new int[n];
        maxBefore[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxBefore[i] = Math.max(maxBefore[i - 1], nums[i]);
        }

        // Step 2: Compute suffix maxAfter[k]
        int[] maxAfter = new int[n];
        maxAfter[n - 1] = nums[n - 1];
        for (int k = n - 2; k >= 0; k--) {
            maxAfter[k] = Math.max(maxAfter[k + 1], nums[k]);
        }

        // Step 3: Find the maximum triplet value
        long result = 0;
        for (int j = 1; j < n - 1; j++) {
            long maxI = maxBefore[j - 1]; // Maximum value before j
            long maxK = maxAfter[j + 1];  // Maximum value after j
            long value = (maxI - nums[j]) * maxK;
            result = Math.max(result, value);
        }

        return result;
    }
}
