package cp1_StkAndQue.q7_maxSlidingWindow;

public class Solution01 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int tailIdx = k - 1;

        int cnt = size - k;
        int[] window = new int[k];
        int[] maxWin = new int[size - k + 1];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= cnt; i++) {
            System.arraycopy(nums, i, window, 0, k);
            if (i == 0) {
                for (int num : window) {
                    if (num > max) {
                        max = num;
                    }
                }
            } else {
                int inElm = nums[tailIdx + i];
                int outElm = nums[i - 1];
                if (inElm > max) {
                    max = inElm;
                } else if (outElm == max) {
                    max = Integer.MIN_VALUE;
                    for (int num : window) {
                        if (num > max) {
                            max = num;
                        }
                    }
                }
            }
            maxWin[i] = max;
        }
        return maxWin;
    }
}
