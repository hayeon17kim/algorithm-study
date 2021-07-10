package com.hayeon.algorithm.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class FrequencySort {

    @Test
    void test() {

    }

    public static String algo(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charCountMap.get(b) - charCountMap.get(a));


        pq.addAll(charCountMap.keySet());

        StringBuilder sb= new StringBuilder();

        while(!pq.isEmpty()) {
            char c = pq.remove();

            for (int i =0 ; i < charCountMap.get(c); i++) {
                sb.append(c);
            }

        }
        return null;
    }
}
