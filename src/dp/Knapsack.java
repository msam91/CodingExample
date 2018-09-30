package dp;

public class Knapsack {

    public static void main(String args[]) {

        Knapsack k = new Knapsack();
        int val[] = { 1, 4, 5, 7 };
        int wt[] = { 1, 3, 4, 5 };
        int totalWeight = 7;

        System.out.print(k.getMaxvalue(wt, val, totalWeight));

    }

    private int getMaxvalue(int[] wt, int[] val, int totalWeight) {

        int table[][] = new int[wt.length + 1][totalWeight + 1];

        for (int i = 0; i <= wt.length; i++) {

            for (int j = 0; j <= totalWeight; j++) {

                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                }            
                else if (wt[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                }
                else {
                    table[i][j] = Math.max(table[i - 1][j], val[i - 1] + table[i - 1][totalWeight - j]);
                }
            }

        }
        return table[wt.length][totalWeight];
    }
}
