//APPROACH-1
//Runtime 2 ms Beats 18.88% Time Complexity	O(log n)
//Memory 40.89 MB Beats 49.91% Space Complexity:O(log n)
class Solution {
public int sumofsquareofdigit(int n){
    int sum=0;
    while(n !=0){
        int digit=n%10;
        n=n/10;
        sum=sum+(digit*digit);
    }
    return sum;
}
public boolean isHappy(int n) {
      Set<Integer>set=new HashSet<>();
      while(n!=1)  {
        if(set.contains(n)){
            return false;
        }
        set.add(n);
        n=sumofsquareofdigit(n);
      }
      return true;

    }
}

//APPROACH-2
//Runtime 0 ms Beats 100.00% Time Complexity: O(log n)
//Memory 41.18 MB Beats 20.60% Space Complexity: O(1)
class Solution {
    public int sumOfSquareOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = n;

        while (fast != 1 && sumOfSquareOfDigits(fast) != 1) {
            slow = sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));

            if (slow == fast) {
                return false;
            }
        }

        return true; 
    }
}
