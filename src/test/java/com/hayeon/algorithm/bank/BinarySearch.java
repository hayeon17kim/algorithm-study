package com.hayeon.algorithm.bank;

import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearch {

    @Test
    void test() {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        // max = 9
        // min = 0
        // mid = 4
        // array[mid] = 45
        // 작다 => max = 3
        // mid = 1, array[mid] = 1
        // 크다 => min = 2 => array[mid] = 21
        // 크다 => min = 3
        // 같다
        // return
        int target = 33;
        Assertions.assertThat(binarySearch(array, target))
            .isEqualTo(3);
    }

    public static int binarySearch(int[] array, int target) {
        int minIndex = 0;
        int maxIndex = array.length - 1;

        while (minIndex <= maxIndex) {
            final int midIndex = (minIndex + maxIndex) / 2;
            if (array[midIndex] == target) {
                return midIndex;
            } else if (array[midIndex] < target) {
                minIndex = midIndex + 1;
            } else {
                maxIndex = midIndex -1;
            }
        }
        return -1;
    }
}
