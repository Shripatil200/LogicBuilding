package org.example.algorithms.array;


/*
14. Longest Common Prefix
Easy

https://leetcode.com/problems/longest-common-prefix/description
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    /*
        Pros:
            Optimal for early mismatches:
                If the first characters of the strings differ, it stops almost instantly.
            Memory Efficient:
                Uses $O(1)$ extra space.
            Consistent: Performance is very predictable across different types of data.

        Cons:
            Cache Performance:
                Accessing characters at the same index across many different strings can be slightly slower for the CPU
                cache compared to reading one string linearly.
     */

    public static String columnScanning(String[] str){
        if(str == null || str.length == 0) return "";

        for(int i =0; i < str[0].length(); i++){
            char c = str[0].charAt(i);

            for(int j = 1; j < str.length; j++){

                if(i == str[j].length() || str[j].charAt(i) != c){
                    return str[0].substring(0, i);
                }
            }
        }
        return str[0];
    }

/*
Pros:

    Simple Logic:
        Very easy to explain and implement using built-in methods like indexOf().

Cons:

    Wasted Effort:
        If the first two strings are 1,000 characters long and identical,
        but the third string is empty, you spent a lot of time comparing the first two for nothing.
 */

    public static String wordToWordScanning(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Step 1: Assume the first string is the common prefix
        String prefix = strs[0];

        // Step 2: Compare the prefix with each string in the array one by one
        for (int i = 1; i < strs.length; i++) {
            // While the current string doesn't start with the 'prefix'
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, there is no common prefix at all
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }


    public static void main(String[] args) {
        String[] str = {"flower", "flow", "fly"};
        String resultOne = LongestCommonPrefix.columnScanning(str);
        String resultTwo = LongestCommonPrefix.wordToWordScanning(str);

        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

}
