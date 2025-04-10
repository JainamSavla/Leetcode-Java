//Approach-1
//Time Complexity: O(n log n)
//Space Complexity: O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
     Arrays.sort(nums);
      k=nums.length-k;
     return nums[k];
    }
}

//Approach-2
//Time Complexity: O(n log k) Inserting & removing from a heap is O(log k), and we do it n times
//Space Complexity: O(k)	Heap stores at most k elements.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(pq.size()<k){
            pq.add(nums[i]);
            }else if(pq.peek()<nums[i]){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}

//Approach-3
//Time Complexity: O(n log n) + O(n) ≈ O(n log n) Sorting takes O(n log n), pushing takes O(n), and popping k elements takes O(k). Sorting dominates.
//Space Complexity: O(n)	The stack stores n elements.
class Solution {
    public int findKthLargest(int[] nums, int k) {
         Arrays.sort(nums);
        ArrayDeque<Integer> s=new ArrayDeque<>();
        for(int i:nums){
            s.push(i);
        }
        for(int i=1;i<k;i++){
            s.pop();
        }
        return s.peek();
    }
}
