//Approach-1
//Time Complexity: O(n log n)
//Space Complexity: O(1)
class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);double avg=0,count=0;
        for(int i=1;i<salary.length-1;i++){
            avg+=salary[i];
            count++;
        }
        return avg/count;
    }
}

//Approach-2
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public double average(int[] salary) {
        int min= salary[0];
        int max = salary[0];
        int sum = salary[0];
        for(int s=1;s<salary.length;s++){
            min=Math.min(min,salary[s]);
            max=Math.max(max,salary[s]);
            sum=sum+salary[s];
        }
         return (double)(sum - min - max) / (salary.length - 2);

    }
}
