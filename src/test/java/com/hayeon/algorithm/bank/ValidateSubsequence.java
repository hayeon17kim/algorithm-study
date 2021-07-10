package com.hayeon.algorithm.bank;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateSubsequence {
    @Test
    void test() {
        int[] array = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = new int[]{1, 6, -1, 10};

        Assertions.assertThat(validateSubsequence(array, sequence)).isEqualTo(true);
    }

    public static boolean validateSubsequence(int[] array, int[] sequence) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : array) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        for (int e : sequence) {
            if (map.get(e) != 0 || map.get(e) != null) {
                map.put(e, map.get(e) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
