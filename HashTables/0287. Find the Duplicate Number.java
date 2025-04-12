//TC:O(N)
//SC:O(N)
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num; // This is the duplicate
            }
            set.add(num);
        }
        return -1; // If no duplicate found (though problem guarantees one)
    }
}

//APPROACH-2
//tc:O(n)
//sc:O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            int ele = Math.abs(num);
            if (nums[ele] > 0) {
                nums[ele] = -nums[ele];
            } else {
                ans = ele;
                break;
            }
        }

        // Restore the array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return ans;
    }
}
