package org.example.algorithms.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/*
567. Permutation in String
Medium

https://leetcode.com/problems/permutation-in-string/description/

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

A permutation is a rearrangement of all the characters of a string.
 */
public class PermutationString {

        public static boolean checkInclusion(String s1, String s2) {

            if (s1.length() > s2.length())
                return false;

            Map<Character, Integer> patternFreq = new HashMap<>();
            Map<Character, Integer> stringFreq = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {

                patternFreq.put(s1.charAt(i), patternFreq.getOrDefault(s1.charAt(i), 0) + 1);
                stringFreq.put(s2.charAt(i), stringFreq.getOrDefault(s2.charAt(i), 0) + 1);
            }

            int windowStart = 0;
            if (patternFreq.equals(stringFreq)) {
                return true;
            }

            for (int windowEnd = s1.length(); windowEnd < s2.length(); windowEnd++) {

                char rightChar = s2.charAt(windowEnd);
                stringFreq.put(rightChar, stringFreq.getOrDefault(rightChar, 0) + 1);

                char leftChar = s2.charAt(windowStart);
                stringFreq.put(leftChar, stringFreq.get(leftChar) - 1);
                if (stringFreq.get(leftChar) <= 0) {
                    stringFreq.remove(leftChar);
                }

                windowStart++;

                if (patternFreq.equals(stringFreq)) {
                    return true;
                }
            }
            return false;

        }


    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "vbcvasddfagfh"));
    }

}
