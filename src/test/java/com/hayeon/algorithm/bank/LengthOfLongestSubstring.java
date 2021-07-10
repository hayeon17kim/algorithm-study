package com.hayeon.algorithm.bank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LengthOfLongestSubstring {
    @Test
    void test() {
        Assertions.assertThat(lengthOfLongestSubstring("aabccbb")).isEqualTo(3);
        Assertions.assertThat(lengthOfLongestSubstring("abbbb")).isEqualTo(2);
        Assertions.assertThat(lengthOfLongestSubstring("abccde")).isEqualTo(3);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        int result = 0;
        int p1 = 0;
        int p2 = 1;

        Set<Character> set = new HashSet<>();
        while(p1 < s.length() && p2 < s.length()) {
            if (!set.contains(s.charAt(p2)) && s.charAt(p1) != s.charAt(p2)) {
                set.add(s.charAt(p2));
                result = Math.max(result, p2 - p1 + 1);
                p2++;
            } else {
                set.clear();
                p1++;
                p2 = p1 + 1;
            }
        }
        return result;
    }
}
