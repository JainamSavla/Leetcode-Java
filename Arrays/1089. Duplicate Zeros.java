//1089. Duplicate Zeros
//Approach-1
//Runtime 1ms beats 98.42%
//But space complexity will be O(n) as a seperate temp array is used  
class Solution {
    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length]; // Temporary array
        int s = 0;
        int d = 0;
        
        while (s < arr.length) {
            if (arr[s] == 0) {
                temp[d] = 0;
                d++;
               if(d<arr.length){
                 temp[d]=0;
              }
            } else {
                temp[d] = arr[s];
            }
            d++;
            s++;
            if(d>=arr.length)break;
        }
            for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
