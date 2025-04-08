//TIME COMPLEXITY:O(n²)
//SPACE COMPLEXITY:O(n)
class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        int operations = 0;
        while (new HashSet<>(list).size() < list.size()) { // While there are duplicates
            int removeCount = Math.min(3, list.size()); // Remove up to 3 elements
            for (int i = 0; i < removeCount; i++) {
                list.remove(0); // Remove the first element
            }
            operations++;
            if (list.isEmpty()) break;
        }
        return operations;

    }
}
