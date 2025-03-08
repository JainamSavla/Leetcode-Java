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

//HashSet
//Runtime 2ms TIME COMPLEXITY: = O(N)
//Memory 43.11MB SPACE COMPLEXITY=O(N) 
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int num:arr){
            if(set.contains(2*num)||(num % 2 == 0 && set.contains(num / 2))){//if it is odd then the division wont work correctly so we placed a condition to check even number 
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
