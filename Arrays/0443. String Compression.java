//TC: O(n)
//sc: SC: O(1)
class Solution {
    public int compress(char[] chars) {
        int index = 0;  // position to write to
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // count how many times currentChar repeats
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // write the character
            chars[index++] = currentChar;

            // write the count if more than 1
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
