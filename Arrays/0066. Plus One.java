class Solution {
    public int[] plusOne(int[] digits) {
        // Iterate through the array from the last digit to the first
        for (int i = digits.length - 1; i >= 0; i--) {
            
            // If the current digit is less than 9, simply increment it by 1
            if (digits[i] < 9) {
                digits[i]++;  // Increment the digit
                return digits;  // Return the array since no further changes are needed
            }
            
            // If the current digit is 9, set it to 0 and continue the loop to handle carry-over
            digits[i] = 0;
        }
        
        // If all digits were 9, the loop completes and all digits are now 0
        // In this case, we need a new array with an extra digit to accommodate the carry
        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;  // Set the first digit to 1, the rest are already 0 by default
        return newArray;  // Return the new array
    }
}
