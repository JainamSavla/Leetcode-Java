//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Convert to 1-based index
            } else if (sum < target) {
                left++; // Increase sum
            } else {
                right--; // Decrease sum
            }
        }
        
        return new int[]{-1, -1}; // Should never reach here (problem guarantees a solution)
    }
}
