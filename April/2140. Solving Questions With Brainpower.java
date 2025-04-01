//Runtime 5 ms Beats 96.96%  Time Complexity:O(n)
//Memory 108.05 MB Beats 79.64% Space Complexity	O(n)
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length; // Number of questions
        long[] dp = new long[n + 1]; // dp[i] stores the max points possible starting from index i
        
        // Traverse the questions in reverse order (bottom-up DP)
        for (int i = n - 1; i >= 0; i--) {  
            int points = questions[i][0];  // Points earned for solving the current question
            int brainpower = questions[i][1];  // Number of questions to skip after solving this one
            int nextIndex = i + brainpower + 1;  // The next question we can attempt after skipping

            // If we take this question, add its points and jump to the next available question
            long take = points + (nextIndex < n ? dp[nextIndex] : 0);  
            
            // If we skip this question, we just take the best result from the next question
            long skip = dp[i + 1];  
            
            // Store the maximum points possible at this index
            dp[i] = Math.max(take, skip);  
        }

        return dp[0]; // The maximum points possible starting from index 0
    }
}
