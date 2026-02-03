package org.example.algorithms.slidingwindow;

/*
3. Longest Substring Without Repeating Characters
(Medium)

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string s, find the length of the longest substring without duplicate characters.

 */

import java.util.HashMap;
import java.util.Map;

public class SubStringWithDistinctCharacters {

    private static int lengthOfTheLongestSubstring(String s){

        int maxLength = 0;
        Map<Character, Integer> frequency = new HashMap<>();
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){

            char ch = s.charAt(windowEnd);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);

            while(frequency.get(ch) > 1){
                char c = s.charAt(windowStart);
                frequency.put(c, frequency.get(c) -1);
                windowStart ++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart +1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(SubStringWithDistinctCharacters.lengthOfTheLongestSubstring("abcabcbb"));
        System.out.println(SubStringWithDistinctCharacters.lengthOfTheLongestSubstring("bbbbb"));
        System.out.println(SubStringWithDistinctCharacters.lengthOfTheLongestSubstring("pwwkew"));
    }

}
