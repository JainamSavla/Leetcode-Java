//941. Valid Mountain Array
//2ms Beats 72.20% Time Complexity: O(n) 
//Memory 45.65MB Beats 22.38% Space Complexity:O(1)

/*Find the Peak
Step 1
Start from index = 0 and keep moving forward as long as arr[i] < arr[i+1].
Stop when you can’t go up anymore (this is the peak).
Check if it's a Valid Peak

Step 2
The peak cannot be the first (index 0) or the last (index n-1) element.
If the peak is at the start or end, return False.
Verify the Descending Part

Step3
Continue moving forward, ensuring arr[i] > arr[i+1] (strictly decreasing).
If we successfully reach the end of the array, return True.
*/
class Solution {
    public boolean validMountainArray(int[] arr) {
        int i=0;
        while(i + 1 < arr.length && arr[i]<arr[i+1]){
            i++;
        }
        if(i==0 || i==arr.length-1){
            return false;
        }
        while(i + 1 < arr.length && arr[i]>arr[i+1]){
            i++;
        }
        return i==arr.length-1;    //If i has reached the last index, the condition is true, so the function returns true.Otherwise, it returns false.
    }
}
