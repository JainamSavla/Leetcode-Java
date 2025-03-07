//88. Merge Sorted Array
//Approach 1
//Runtime 1ms
//Memory 42.98MB
//Time complexity O(m+n)
//Space complexity depends on which sorting algo is used in java quick sort is used so the O(log(n))
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}

//APPROACH 2
//Runtime 1ms
//Memory 41.98MB
//Time complexity O(n) for array copy and O((m + n) log(m + n)) for sort
//Space complexity depends on which sorting algo is used in java quick sort is used so the O(log(n))
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);//System.arraycopy(sourceArray, sourceStartIndex, destinationArray, destinationStartIndex, numberOfElementsToCopy);
        Arrays.sort(nums1);
    }
}

//Approach 3
//0 ms Beats 100.00%
//Memory 42.35MB Beats 41.87%
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Create a temporary array to store the first 'm' elements of nums1
        int[] temp = new int[m];  

        // Copy the first 'm' elements of nums1 into the temporary array
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }

        int i = 0;  // Pointer for the temporary array (temp)
        int j = 0;  // Pointer for nums2
        int k = 0;  // Pointer for nums1 (where we will store the merged result)

        // Merge the two arrays into nums1
        while (i < m && j < n) {
            if (temp[i] < nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        // If there are remaining elements in temp, copy them to nums1
        while (i < m) {
            nums1[k] = temp[i];
            i++;
            k++;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }
}
//Approach 4
