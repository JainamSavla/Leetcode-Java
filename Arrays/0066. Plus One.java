//0066. Plus One
//Runtime 0 ms Beats 100.00%  O(n)
//Memory 42.07 MB Beats 30.10% O(n)
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // If all digits were 9, we need a bigger array
        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        return newArray;
    }
}
