//4. Median of Two Sorted Arrays(HARD)
//5ms Beats 26.84%
//Memory 46.36MB Beats 25.41%
import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        
        Arrays.sort(merged); 
        
        int n = merged.length;
        if (n % 2 == 1) {
            return merged[n / 2]; //when the size of array is odd so median is middle element
        } else {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0; //when size is even than median is sum of the midle 2 elements divided by 2 
        }
    }
}
