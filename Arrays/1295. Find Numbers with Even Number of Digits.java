//1295. Find Numbers with Even Number of Digits
class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int temp = nums[i];

            while (temp != 0) {
                temp = temp / 10;
                count++;
            }
            
            if (count % 2 == 0) {
                even++;
            }
        }
        
        return even;
    }
}
