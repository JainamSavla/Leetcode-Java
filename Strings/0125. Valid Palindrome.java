//TC:	O(n)
//Sc:	O(n)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        StringBuilder sb = new StringBuilder();

        // Normalize string: remove non-alphanumerics and convert to lowercase
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        int start = 0;
        int end = sb.length() - 1;

        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
