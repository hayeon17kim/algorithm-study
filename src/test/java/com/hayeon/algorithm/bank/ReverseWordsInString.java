package com.hayeon.algorithm.bank;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class ReverseWordsInString {

    @Test
    void test() {
        reverseWords("AlgoExpert is the best!");
    }

    public static String reverseWords(String str) {
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {

            }
        }
        return null;
    }
}
