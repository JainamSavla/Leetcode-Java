//Tc:O(n) 
//Sc:O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);  // Push opening brackets
            } else if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                st.pop();     // Match closing ) with (
            } else if (!st.isEmpty() && ch == '}' && st.peek() == '{') {
                st.pop();     // Match closing } with {
            } else if (!st.isEmpty() && ch == ']' && st.peek() == '[') {
                st.pop();     // Match closing ] with [
            } else {
                return false; // Mismatch or stack empty
            }
        }
        
        return st.isEmpty(); // Stack should be empty if valid
    }
}
