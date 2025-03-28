//APPROACH 1 -HashMAp
//Runtime 16 ms Beats 9.90% time complexity:O(N)
//Memory 46.03 MB Beats 71.76% Space Complexity:O(N)

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer>map =new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            map.put(num, map.get(num)+1);
        }
        for(int num:nums){
            if(map.get(num)==1){
                return num;
            }
        }
        return -1;
    }
}

//Approach-2
//9 ms Beats 25.14%;TIME COMPLEXITY:o(N);
//45.18 MB Beats 90.54%;space complexity is:O(N)


class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int sum=0;
        int sumSet=0;
        
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
                sumSet+=num;
             }
             sum+=num;
        }
        return 2*sumSet-sum;
    }
}


//APPROACH 3 
//Runtime 1 ms Beats 99.85% O(N)
//Memory 46.04 MB Beats 71.76%  O(1)
class Solution{
public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        result = result ^ num; // XOR operation
    }
    return result;
}
}
