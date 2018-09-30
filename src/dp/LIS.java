package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {

    public static void main(String args[]) {

        int a[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

        System.out.print(getLIS(a));
        System.out.print(lengthOfLIS(a));
        
    }

    private static List<Integer> getLIS(int[] a) {

        int dp[] = new int[a.length];
        int track[] = new int[a.length];
        Arrays.fill(track, -1);
        Arrays.fill(dp, 1);
        int max = 1;
        int maxIndex = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    track[i] = j;
                }
                if (dp[i] > max) {
                    max = dp[i];
                    maxIndex = i;
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        int currentIndex = maxIndex;
        while (result.size() != max) {
            result.add(0, a[currentIndex]);
            currentIndex = track[currentIndex];
        }

        return result;
    }
    
    public static int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
