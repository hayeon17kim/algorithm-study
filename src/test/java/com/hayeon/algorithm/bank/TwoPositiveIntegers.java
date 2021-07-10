package com.hayeon.algorithm.bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoPositiveIntegers {
    @Test
    void test() {
        Assertions.assertThat(solution(2, 3)).isEqualTo(10);
    }

    public static int solution(int width, int height) {
        int[][] matrix = new int[height + 1][width + 1];
        for (int w = 0; w <= width; w++) {
            for (int h = 0; h <= height; h++) {
                if (w == 0 || h == 0) matrix[h][w] = 1;
                else matrix[h][w] =  matrix[h - 1][w] + matrix[h][w - 1];
                System.out.println("matrix[" + h + "][" + w + "] = " + matrix[h][w]);
            }
        }
        return matrix[height][width];
    }

}
