package org.example.algorithms.slidingwindow;

/*
424. Longest Repeating Character Replacement
Medium

https://leetcode.com/problems/longest-repeating-character-replacement/description

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestRepetingCharReplace {

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int maxFreq = 0;
        int start = 0;
        int result = 0;

        for(int end = 0; end < s.length(); end++){
            freq[s.charAt(end) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(end) - 'A']);

            while((end - start + 1) - maxFreq > k){
                freq[s.charAt(start) - 'A']--;
                start++;
            }

            result = Math.max(result, end - start + 1);

        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println("Longest Substring: "+ characterReplacement("AABABBA", 1));
    }
}
