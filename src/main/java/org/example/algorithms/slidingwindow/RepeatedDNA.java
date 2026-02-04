package org.example.algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
187. Repeated DNA Sequences
Medium

https://leetcode.com/problems/repeated-dna-sequences/description/

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 */
public class RepeatedDNA {

    private static List<String> findRepeatedDnaSequences(String s){
        Set<String> ans = new HashSet<>();
        Set<String> stored = new HashSet<>();

        for(int i = 0; i < s.length() - 9; i++){
            String sub = s.substring(i, i + 10);
            if(!stored.add(sub))
                ans.add(sub);
        }

        return new ArrayList<>(ans);
    }


    public static void main(String[] args) {
        System.out.println("Repeated Pattern: "+ RepeatedDNA.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
