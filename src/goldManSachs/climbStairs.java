package goldManSachs;

public class climbStairs {

    public static void main(String args[]) {

        System.out.print(getWays(5));

    }

    private static int getWays(int n) {
        // TODO Auto-generated method stub
        if(n==1) {
            return 1;
        }
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
