package com.hayeon.algorithm.bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSubsetSumNoAdjacent {
    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{ 75, 105, 120, 75, 90, 135})).isEqualTo(330);
    }

    public static int solution(int[] array) {
        int sum = 0;
        int sum2 = 0;
        int result = 0;
        if (array.length % 2 == 0) {
            for (int i = 0; i < array.length; i++) {
                if (i % 2 == 0) sum += array[i];
                else sum2 += array[i];
            }

            if (array[array.length - 1] > array[array.length - 2] ) {
                sum = sum - array[array.length - 2] + array[array.length - 1];
            }
            result = Math.max(sum2, sum);
        } else {
            for (int i = 0; i < array.length; i+=2) {
                sum += array[i];
            }
            result = sum;
        }
        return result;
    }
}
