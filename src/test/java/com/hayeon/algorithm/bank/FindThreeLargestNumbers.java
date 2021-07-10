package com.hayeon.algorithm.bank;

import java.util.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindThreeLargestNumbers {
    @Test
    void test() {
        int[] input = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] result = findThreeLargestNumbers(input);

        Assertions.assertThat(result[0]).isEqualTo(18);
        Assertions.assertThat(result[1]).isEqualTo(141);
        Assertions.assertThat(result[2]).isEqualTo(541);
    }

    public int[] findThreeLargestNumbers(int[] input) {
        int max, mid, min;
        max = mid = min = Integer.MIN_VALUE;

        for (int j : input) {
            if (j > max) {
                min = mid;
                mid = max;
                max = j;
            } else if (j > mid) {
                min = mid;
                mid = j;
            } else if (j > min) {
                min = j;
            }
        }
        return new int[] { min, mid, max };
    }
}
