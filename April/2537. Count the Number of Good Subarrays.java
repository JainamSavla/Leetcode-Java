//Time Complexity	O(n)
//Space Complexity	O(n)
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long pairs = 0;
        long result = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);

            pairs += count;
            freq.put(val, count + 1);

            // Shrink window from the left while we have enough pairs
            while (pairs >= k) {
                result += nums.length - right;

                int leftVal = nums[left];
                int leftCount = freq.get(leftVal);
                freq.put(leftVal, leftCount - 1);
                pairs -= leftCount - 1;

                left++;
            }
        }

        return result;
    }
}
