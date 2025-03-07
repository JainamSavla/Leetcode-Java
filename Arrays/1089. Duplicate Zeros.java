//1089. Duplicate Zeros
//Approach-1
//Runtime 1ms beats 98.42%
//But space complexity will be O(n) as a seperate temp array is used  
class Solution {
    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length]; // Temporary array
        int s = 0;
        int d = 0;
        
        while (s < arr.length) {
            if (arr[s] == 0) {
                temp[d] = 0;
                d++;
               if(d<arr.length){
                 temp[d]=0;
              }
            } else {
                temp[d] = arr[s];
            }
            d++;
            s++;
            if(d>=arr.length)break;
        }
            for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
//Approach 2
//The space complexity is O(1) since the array itself is modified instead of taking another array
class Solution {
    public void duplicateZeros(int[] arr) {
        // Step 1: Count the number of zeros in the array
        int zero = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zero++;
            }
        }

        // Step 2: Calculate the new index where elements will be placed
        // j starts from the end of the extended array (original array length + number of zeros)
        int j = n + zero - 1;

        // Step 3: Iterate from the end of the original array to the beginning
        for (int i = n - 1; i >= 0; i--) {
            // If the current index j is within the bounds of the original array, copy the element
            if (j < n) {
                arr[j] = arr[i];
            }
            j--; // Move j one step back

            // If the current element is zero, duplicate it
            if (arr[i] == 0) {
                if (j < n) {
                    arr[j] = 0; // Duplicate the zero
                }
                j--; // Move j one more step back to accommodate the duplicated zero
            }
        }
    }
}
