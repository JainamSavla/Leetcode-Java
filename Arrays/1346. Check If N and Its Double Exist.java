//1346. Check If N and Its Double Exist
//APPROACH 1
//Brute Force NOT OPTIMAL
//Runtime 3ms
//Memory 43.16
//The solution has O(n²) complexity due to the two nested loops.
//The space complexity of your corrected solution is O(1)
class Solution {
    public boolean checkIfExist(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if((i!=j)&&(arr[j]==2*arr[i]||arr[i]==2*arr[j])){
                    return true;
                }
            }
            
        }
        return false;
    }
}
