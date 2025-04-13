import java.util.*;

class Solution {

    // 🔢 Calculates factorial of a number (used for permutation counts)
    public long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;  // Multiply all numbers from 1 to num
        }
        return result;
    }

    // 🌀 Recursively generates all palindromic numbers of length 'n'
    public void generatePalindromes(char[] currentNumber, int index, List<String> validPalindromes, int k) {
        // Base case: full palindrome is built
        if (index >= (currentNumber.length + 1) / 2) {
            String palindrome = new String(currentNumber);  // Convert char[] to String
            // ✅ Keep only if divisible by k
            if (Long.parseLong(palindrome) % k == 0) {
                validPalindromes.add(palindrome);
            }
            return;
        }

        // ⚠️ Place '0' only if it's not the first digit (to avoid leading zeros)
        if (index != 0) {
            currentNumber[index] = '0';
            currentNumber[currentNumber.length - 1 - index] = '0';  // Mirror it
            generatePalindromes(currentNumber, index + 1, validPalindromes, k);
        }

        // 🔁 Try digits '1' to '9' at mirrored positions
        for (char c = '1'; c <= '9'; c++) {
            currentNumber[index] = c;
            currentNumber[currentNumber.length - 1 - index] = c;
            generatePalindromes(currentNumber, index + 1, validPalindromes, k);
        }
    }

    // 🎯 Main function: count number of good integers with n digits that are k-palindromic
    public long countGoodIntegers(int n, int k) {
        List<String> validPalindromes = new ArrayList<>(); // Stores palindromes divisible by k

        // Create an empty char array of length n to build palindromes
        char[] basePalindrome = new char[n];
        Arrays.fill(basePalindrome, '0'); // Initialize with zeroes

        // 🛠️ Generate all palindromes of length n that are divisible by k
        generatePalindromes(basePalindrome, 0, validPalindromes, k);

        Set<String> uniquePatterns = new HashSet<>(); // To avoid counting duplicate digit patterns

        // 🔍 Extract unique digit frequency patterns from valid palindromes
        for (String palindrome : validPalindromes) {
            int[] freq = new int[10]; // Count of digits 0–9
            for (char ch : palindrome.toCharArray()) {
                freq[ch - '0']++; // Increment frequency for each digit
            }

            // 🔑 Convert frequency array to a pattern string (used as a hash)
            StringBuilder pattern = new StringBuilder();
            for (int f : freq) {
                pattern.append((char) ('a' + f)); // Encode counts as characters to build pattern
            }

            uniquePatterns.add(pattern.toString()); // Store only unique digit sets
        }

        long totalPermutations = factorial(n); // Total permutations of n digits
        long totalValidPermutations = 0; // Counter for final result

        // 📦 For each unique pattern, compute valid permutations that do not start with 0
        for (String pattern : uniquePatterns) {
            long permutations = totalPermutations;

            // 🧩 Adjust for repeated digits using multinomial division
            for (char ch : pattern.toCharArray()) {
                permutations /= factorial(ch - 'a'); // Convert back to frequency from encoded char
            }

            // ⚠️ Check if any of the permutations would have a leading 0
            if (pattern.charAt(0) != 'a') { // 'a' means 0 zeros. If not 'a', there are some zeros
                int zeroCount = pattern.charAt(0) - 'a' - 1; // Account for one zero being in front
                long invalidPerms = factorial(n - 1); // Fix one non-zero in front

                // 🔁 Again, divide by factorials of the remaining frequencies (excluding leading 0)
                for (int j = 1; j < pattern.length(); j++) {
                    invalidPerms /= factorial(pattern.charAt(j) - 'a');
                }

                // 🔁 Also divide by number of remaining zeros (excluding the one we fixed)
                invalidPerms /= factorial(zeroCount);

                // 🧹 Remove permutations that start with 0
                permutations -= invalidPerms;
            }

            // ✅ Accumulate the number of valid permutations
            totalValidPermutations += permutations;
        }

        return totalValidPermutations; // Return final count of good integers
    }
}
