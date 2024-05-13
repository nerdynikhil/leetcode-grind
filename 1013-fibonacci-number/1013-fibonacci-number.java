class Solution {
    int nthFib(int n) {

        if (n == 0 || n == 1)
            return n;

        int a = nthFib(n - 1);
        int b = nthFib(n - 2);

        return a + b;
    }

    public int fib(int n) {
        return nthFib(n);
    }
}