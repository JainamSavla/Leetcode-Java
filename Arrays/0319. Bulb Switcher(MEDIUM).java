// time complexity : O(√n).
//Space complexity : O(1)
class Solution {
    public int bulbSwitch(int n) {
        int count=0;

        int i=1;

        while(i*i<=n){
            count++;
            i++;
        }
        return count;
    }
}
