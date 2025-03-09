//1051. Height Checker
//Runtime 2 ms Beats 88.71% TIME COMPLEXITY:O(NLog(N)) because	Uses sorting and an additional array.
//Memory 41.72MB Beats 25.07%  SPACE COMPLEXITY:O(N)
class Solution {
    public int heightChecker(int[] heights) {
        int[] res=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            res[i]=heights[i];
        }
        Arrays.sort(heights);
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(res[i]!=heights[i]){
                  count++;
            }
        }
        return count;
    }
}
