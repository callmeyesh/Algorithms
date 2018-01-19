package com.algorithms.leetcode.array.easy;

/*-
 * Say you have an array for which the i'th element is the price of
 * a given stock on day i. If you were only permitted to complete
 * at most one transaction (i.e, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 *  Example 1:
 *      Input: [7, 1, 5, 3, 6, 4]
 *      Output: 5
 *
 * Max difference = 6-1 = 5
 * (not 7-1 = 6, as selling price needs to be larger than buying price)
 *
 * @author yvenkatesh
 */
public class BuySellStocks {

  public static void main(String[] args) {
    BuySellStocks bss = new BuySellStocks();
    int[] prices = {7, 1, 5, 3, 6, 4};
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

  /*-
   * Create the difference array and then find the max sub array.
   *
   * A more clear explanation on why sum of sub array works.:
   *
   * Suppose we have original array:
   *    [a0, a1, a2, a3, a4, a5, a6]
   *
   * What we are given here (or we calculate ourselves) is:
   *    [b0, b1, b2, b3, b4, b5, b6]
   *
   * where:
   *    b[i] = 0, when i == 0
   *    b[i] = a[i] - a[i - 1], when i != 0
   *
   * Suppose if a2 and a6 are the points that give us the max difference
   * (a2 < a6) then in our given array, we need to find the sum of
   * sub array from b3 to b6.
   *
   *    b3 = a3 - a2
   *    b4 = a4 - a3
   *    b5 = a5 - a4
   *    b6 = a6 - a5
   *
   * adding all these, all the middle terms will cancel out except two i.e.
   *
   *    b3 + b4 + b5 + b6 = a6 - a2
   *
   * so we need to find the largest sub array sum to get the most profit
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
