package com.algorithms.leetcode.array.easy;

/**
 * Say you have an array for which the i'th element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e, buy one and sell one share of the stock multiple times). However, you may not engage in
 * multiple transactions at the same time (i.e, you must sell the stock before you buy again).
 *
 * @author yvenkatesh
 *
 */
public class BuySellStock2 {

  public static void main(String[] args) {
    BuySellStock2 bss = new BuySellStock2();
    int[] prices = {1, 4, 3, 7, 9, 3, 2, 1, 4};
    System.out.println(bss.fasterSolution(prices));
  }

  public int maxProfit(int[] prices) {

    if (prices.length < 2)
      return 0;

    int maxProfit = 0;
    int buyPrice = prices[0];
    for (int i = 1; i <= prices.length - 1; i++) {
      if (prices[i] < buyPrice) {
        buyPrice = prices[i];
      } else {
        maxProfit += prices[i] - buyPrice;
        buyPrice = prices[i];
      }
    }

    return maxProfit;
  }

  public int fasterSolution(int[] prices) {
    if (prices.length < 2)
      return 0;

    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        maxProfit = maxProfit + prices[i + 1] - prices[i];
      }
    }

    return maxProfit;
  }
}
