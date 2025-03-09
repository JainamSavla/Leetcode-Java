//487 . Max Consecutive Ones II
//APPROACH -1
//Brute force NOT OPTIMAL
//TIME COMPLEXITY:-O(n²)
//Space Complexity: O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0; // To store the maximum length of consecutive 1's

        // Outer loop: Start of the window
        for (int i = 0; i < nums.length; i++) {
            int zero = 0; // Count of zeros in the current window

            // Inner loop: End of the window
            for (int j = i; j < nums.length; j++) {
                // If the current element is 0, increment the zero count
                if (nums[j] == 0) {
                    zero++;
                }

                // If there are more than one zero, break the inner loop
                if (zero > 1) {
                    break;
                }

                // Update the maximum length of the window
                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }
}

//SLIDING WINDOW
//Time complexity=O(n)
//space complexity = O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0;
        int max = 0;
        int zeroes = 0;

        while (i < nums.length) {
            if (nums[i] == 0) {
                zeroes++;
            }

            while (zeroes == 2) {
                if (nums[j] == 0) {
                    zeroes--;
                }
                j++;
            }

            max = Math.max(max, i - j + 1);
            i++;
        }

        return max;
    }
}
