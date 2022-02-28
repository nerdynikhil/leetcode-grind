//Way1
class Solution {
public:
    int digitSquareSum(int n){
        int ans=0;
        while(n)
        {
            ans=ans+(n%10)*(n%10);
            n=n/10;
        }
        return ans;
    }
    
    bool isHappy(int n) {
         
        int temp=n;
        while(1)
        {
            if(temp==89)
                return false;
            if(temp==1)
                return true;
            temp=digitSquareSum(temp);
        }
    }
};

//Way2
class Solution {
public:
        
    int fun(int n){
        int ans  = 0;
        while(n>0)
        {
            ans+=(n%10)*(n%10);
            n/=10;
        }
        return ans;
    }
    bool isHappy(int n) {
        int slow =n;
        int fast =n;
        do{
            slow = fun(slow);
            fast = fun(fun(fast));
        }while (slow!=fast);
        
        return slow==1;
    }
};

//Way3
class Solution {
public:
    bool isHappy(int n) {
        while(n / 10 > 0){
            int sum = 0;
            while(n > 0){
                int rem = n % 10;
                sum = rem * rem + sum;
                n = n / 10;
            }
            n = sum;
        }
        if (n==1 or n==7)
            return true;
        else return false;
    }
};