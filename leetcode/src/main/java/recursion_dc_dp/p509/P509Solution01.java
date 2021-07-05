package recursion_dc_dp.p509;

import org.junit.Test;

public class P509Solution01 {

    public int fib(int n) {
        int[] arr = new int[n];
        if (n <= 1) {
            return n;
        }
        return dp(n - 1, arr) + dp(n - 2, arr);
    }


    public int dp(int i, int[] arr) {
        if (i <= 1) {
            arr[i] = i;
            return i;
        }

        if (arr[i] != 0) {
            return arr[i];
        }

        arr[i] = dp(i - 1, arr) + dp(i - 2, arr);
        return arr[i] ;
    }

    @Test
    public void test() {
        System.out.println(fib(1));
    }

}
