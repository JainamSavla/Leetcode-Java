//1299. Replace Elements with Greatest Element on Right Side

//APPROACH 1
//Runtime 937ms Beats 15.13% TIME COMPLEXITY :Brute Force Approach (O(n²))
//Memory 46.76 MB beats 49.10%

/*
1.Iterate through the array from the first element to the second-last element.
2.For each element at index i, find the maximum element among all the elements to its right (from index i+1 to the last index).
3.Replace arr[i] with this maximum value.
4.Finally, replace the last element (arr[n-1]) with -1 because there are no elements to its right.
*/
class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int maxright=Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                if(arr[j]>maxright){
                    maxright=arr[j];
                }
            }
            arr[i]=maxright;
         }
         arr[n-1]=-1;
         return arr;
    }
}

//APPROACH-2
//3ms Beats 57.85% Time Complexity: O(n)
// Memory 46.94MB Beats 19.55%Space Complexity: O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length; // Get the length of the array
        int max = -1; // Initially, there are no elements to the right
        
        // Loop from rightmost element to the left
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i]; // Store the current element before modifying it
            arr[i] = max; // Replace the current element with the max element to its right
            max = Math.max(max, temp); // Update max to be the largest seen so far
        }
        
        return arr; // Return the modified array
    }
}
