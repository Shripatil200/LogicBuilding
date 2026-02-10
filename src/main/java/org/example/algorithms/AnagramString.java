package org.example.algorithms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
438. Find All Anagrams in a String
Medium

https://leetcode.com/problems/find-all-anagrams-in-a-string/description

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 */
public class AnagramString {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        if (p.length() > s.length()) return list;

        Map<Character, Integer> pattern = new HashMap<>();
        Map<Character, Integer> string = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pattern.put(p.charAt(i), pattern.getOrDefault(p.charAt(i), 0) + 1);
            string.put(s.charAt(i), string.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (pattern.equals(string)) {
            list.add(0);
        }

        int l = 0;

        for (int i = p.length(); i < s.length(); i++) {

            char right = s.charAt(i);
            string.put(right, string.getOrDefault(right, 0) + 1);

            char left = s.charAt(l);
            string.put(left, string.get(left) - 1);

            if (string.get(left) == 0) {
                string.remove(left);
            }

            l++;

            if (pattern.equals(string)) {
                list.add(l);
            }

        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(findAnagrams("abaab", "ab"));
    }
}
