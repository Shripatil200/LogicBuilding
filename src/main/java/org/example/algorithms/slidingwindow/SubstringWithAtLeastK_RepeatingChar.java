package org.example.algorithms.slidingwindow;

/*
395. Longest Substring with At Least K Repeating Characters
Medium

https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

if no such substring exists, return 0.
 */

public class SubstringWithAtLeastK_RepeatingChar {

    private static int longestSubstring(String s, int k){
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    private static int helper(char[] ch, int start, int end, int k){

        if(ch.length < k) return 0;
        int[] freq = new int[26];

        for(int i = start; i < end; i++){
            freq[ch[i] - 'a']++;
        }

        for(int i = start; i < end; i++){
            if(freq[ch[i] - 'a'] < k){
                int j = i + 1;

                while(j < end && freq[ch[j] - 'a'] < k){
                    j++;
                }

                return Math.max(helper(ch, start, i, k), helper(ch, j, end, k));
            }
        }

        return end - start;
    }


    public static void main(String[] args) {
        System.out.println("Longest Substring: "+ longestSubstring("ababbc", 2));
    }
}
