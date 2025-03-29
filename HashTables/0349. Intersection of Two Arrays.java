//Runtime 3 ms Beats 55.79%//Time Complexity: O(n log n + m log m)
//Memory 43.13 MB Beats 82.47% // Space Complexity:O(N)


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1=0,
            p2=0;
        
        Set<Integer>set=new HashSet<>();

        while(p1<nums1.length && p2<nums2.length)
        {
            if(nums1[p1]==nums2[p2]){
                  set.add(nums1[p1]);
                  p1++;
                  p2++;
            }
            else if(nums1[p1]<nums2[p2]){
                p1++;// nums1 is sorted, the next number might match
            }
            else{
                p2++;//
            }
        }     
        int[] res=new int[set.size()];
        int i=0;
        for(int num:set){
            res[i]=num;
            i++;
        }
        return res;
    }
}

//Approach -2
//Runtime 3 ms Beats 55.79% // Time Complexity:O(n+m)
//Memory 43.58 MB Beats 35.13% // Space Complexity:O(n+m)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set1=new HashSet<>();
         Set<Integer>set2=new HashSet<>();

         for(int n:nums1){
             set1.add(n);
         }
         for(int n:nums2){
            set2.add(n);
         }
         set1.retainAll(set2);
         int[] res=new int[set1.size()];
         int i=0;
         for(int num:set1){
            res[i]=num;
            i++;
         }
         return res;
    }
}

//Approach-3
//Runtime 3 ms Beats 55.79% Time Complexity	O(n + m)
//Memory 43.32 MB Beats 62.63%  Space Complexity	O(min(n, m))

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums1){
             map.put(n,1);
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) == 1) {
                map.put(n, 0);
                set.add(n);  
            }
        }
        int[] res=new int[set.size()];
         int i=0;
         for(int num:set){
            res[i]=num;
            i++;
         }
         return res;
    }
}
