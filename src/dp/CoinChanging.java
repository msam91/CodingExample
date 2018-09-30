package dp;

public class CoinChanging {
	public static void main(String args[]) {

		CoinChanging cc = new CoinChanging();

		int coin[] = { 2, 5, 6, 8 };
		System.out.println(cc.coinChange(coin, 8));
		System.out.print(cc.coinChangeNumberOfWays(coin, 11));
	}

	private int coinChange(int[] coin, int sum) {
		int table[][] = new int[coin.length + 1][sum + 1];

		for (int i = 0; i <= coin.length; i++) {
			for (int j = 0; j <= sum; j++) {

				if (i == 0 && j == 0) {
					table[i][j] = 0;
				} else if (i == 0 && j != 0) {

					table[i][j] = Integer.MAX_VALUE;
				} else {
					if (coin[i - 1] > j) {
						table[i][j] = table[i - 1][j];
					} else {
						if (table[i][j - coin[i - 1]] == Integer.MAX_VALUE) {
							table[i][j] = Math.min(table[i - 1][j], Integer.MAX_VALUE);
						} else {
							table[i][j] = Math.min(table[i - 1][j], 1 + table[i][j - coin[i - 1]]);
						}
					}
				}

			}
		}

		return table[coin.length][sum];

	}

	private int coinChangeNumberOfWays(int[] coin, int sum) {
		int table[][] = new int[coin.length + 1][sum + 1];

		for (int i = 0; i <= coin.length; i++) {
			for (int j = 0; j <= sum; j++) {

				if (i == 0 && j == 0) {
					table[i][j] = 1;
				} else if (i == 0 && j != 0) {
					table[i][j] = 0;
				} else {
					if (coin[i - 1] > j) {
						table[i][j] = table[i - 1][j];
					} else {
						table[i][j] = table[i - 1][j] + table[i][j - coin[i - 1]];
					}
				}

			}
		}

		return table[coin.length][sum];

	}
}
