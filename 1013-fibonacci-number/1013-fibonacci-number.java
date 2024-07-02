class Solution {
    private int findFib(int n){
        if (n==0 || n==1)
            return n;
        
        int a = findFib(n-1);
        int b = findFib(n-2);

        return a+b;
    }
    public int fib(int n) {
        return findFib(n);
    }
}