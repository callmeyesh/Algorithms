package array.easy;

public class BuySellStocks {

	public static void main(String[] args) {
		BuySellStocks bss = new BuySellStocks();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(bss.kadaneAlgo(prices));
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		if (prices.length <= 1)
			return maxProfit;

		int buyPrice = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < buyPrice) {
				buyPrice = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
			}
		}
		return maxProfit;
	}

	/**
	 * Create the difference array and then find the max sub array.
	 * 
	 * @param prices
	 * @return
	 */
	public int kadaneAlgo(int[] prices) {
		if (prices.length < 2)
			return 0;

		int diff[] = new int[prices.length - 1];
		for (int i = 1; i < prices.length; i++) {
			diff[i - 1] = prices[i] - prices[i - 1];
		}

		int maxCur = diff[0], maxSoFar = diff[0];
		for (int i = 1; i < diff.length; i++) {
			maxCur = Math.max(diff[i], maxCur + diff[i]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}

		return maxSoFar;
	}

	/**
	 * Compact version of the above.
	 * 
	 * @param prices
	 * @return
	 */

	public int kadaneAlgo2(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}

}
