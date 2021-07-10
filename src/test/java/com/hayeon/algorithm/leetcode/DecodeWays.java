package com.hayeon.algorithm.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecodeWays {
    @Test
    void test() {
        Assertions.assertThat(numDecodings("11")).isEqualTo(2);
        Assertions.assertThat(numDecodings("226")).isEqualTo(3);
    }

    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        int [] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = isValid(s.substring(0, 1)) ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            // i번째 수가 0이 아닌 경우
            // 한 자리 수를 통해 디코딩이 가능한 경우
            // i - 1 번째까지의 디코딩 방식을 더한다.
            if (isValid(s.substring(i - 1, i))) ways[i] += ways[i - 1];

            // i번째 수가 10과 26 사이의 숫자인 경우
            // 두 자리 수로 문자를 만들 수 있는 경우
            // 한 자리 수를 통한 디코딩과 두 자리 수를 통한 디코딩이 가능
            // i - 1 번째까지의 디코딩 방식과,
            // i - 1 번째까지의 한 자리 수를 통한 디코딩 방식으로 나타낼 수 있다.
            if (isValidTens(s.substring(i - 2, i))) ways[i] += ways[i - 2];
        }
        return ways[n];
    }

    /// 검증
    public boolean isValid(String s) {
        // 0으로 시작하지 않는다.
        return s.charAt(0) != '0';
    }

    public boolean isValidTens(String s) {
        if (!isValid(s)) return false;
        int sNum = Integer.parseInt(s);
        // 1부터 26까지의 숫자 중 하나이다.
        return sNum >= 10 && sNum <= 26;
    }
}

