package org.example.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
340. Longest Substring with K Distinct Characters
(medium)
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/


Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.
 */
public class SubStringK_DistinctChars {

    private static int longestSubstringWithKDistinctCharacters(String str, int k){
        int maxLength = 0;
        char windowStart = 0;
        Map<Character, Integer> frequency = new HashMap<>();

        for(int windowEnd =0; windowEnd < str.length(); windowEnd++ ){
            char ch = str.charAt(windowEnd);
            if(!frequency.containsKey(ch)){
                frequency.put(ch, 0);
            }
            frequency.put(ch, frequency.get(ch) + 1 );

            while(frequency.size() >  k ){
                char c = str.charAt(windowStart);
                frequency.put(c, frequency.get(c) - 1);
                if(frequency.get(c) == 0){
                    frequency.remove(c);
                }
                windowStart ++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }


    public static void main(String[] args){
        System.out.println("Max length: "+ SubStringK_DistinctChars.longestSubstringWithKDistinctCharacters("araaci", 2));
        System.out.println("Max length: "+ SubStringK_DistinctChars.longestSubstringWithKDistinctCharacters("araaci", 1));
        System.out.println("Max length: "+ SubStringK_DistinctChars.longestSubstringWithKDistinctCharacters("cbbebi", 3));

    }
}
