package com.hayeon.algorithm.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BestTimeToBuyAndSellStock {
    @Test
    void test() {
        Assertions.assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4}))
                .isEqualTo(5);
        Assertions.assertThat(maxProfit(new int[]{7, 6, 4, 3, 1}))
                .isEqualTo(0);
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int profit = 0;

        List<Integer> list = trim(prices);

        for (int i = 0; i < list.size(); i++) {

            System.out.print(prices[i]);
            System.out.print(", ");
            for (int j = i + 1; j < list.size(); j++) {
                profit = list.get(j) - list.get(i);
                if (profit > max) max = profit;
            }
        }
        return max;
    }

    public static List<Integer> trim(int[] prices) {
        List<Integer> list = new LinkedList<>();
        list.add(prices[0]);
        for (int i = 1; i< prices.length; i++) {
            if (list.get(list.size() - 1) < prices[i]) {
                list.add(prices[i]);
            }
        }
        return list;
    }

    // 7 1 5 3 6 4
    //
}
