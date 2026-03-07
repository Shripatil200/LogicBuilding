package org.example.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOnString {


    public static String longestString(List<String> str) {
        return str.stream().max(Comparator.comparingInt(String::length)).orElse("");
    }

    public static int longestStringLength(List<String> str) {
        return str.stream().map(String::length).max(Integer::compare).orElse(0);
    }

    private static String smallestString(List<String> str) {
        return str.stream().min(Comparator.comparingInt(String::length)).orElse("");
    }

    public static int smallestStringLength(List<String> str) {
        return str.stream().map(String::length).min(Integer::compare).orElse(0);
    }

    public static List<String> convertToUpperCase(List<String> str) {
        return str.stream().map(String::toUpperCase).toList();
    }

    public static List<String> convertToLowerCase(List<String> str) {
        return str.stream().map(String::toLowerCase).toList();
    }

    public static String concatinateString(List<String> str) {
        return str.stream().collect(Collectors.joining());
    }

    public static String concatenateWithCamelcase(List<String> str) {
        return str.stream()
                .map(String::toLowerCase)
                .reduce((a, b) -> a + Character.toUpperCase(b.charAt(0)) + b.substring(1))
                .orElse("");
    }

    public static List<Integer> getLength(List<String> str) {
        return str.stream()
                .map(String::length)
                .toList();
    }

    public static List<String> sortAscendingWithLength(List<String> str) {
        return str.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> sortAscendingWithAlphabet(List<String> str) {
        return str.stream()
                .sorted()
                .toList();
    }

    public static List<String> sortAscendingWithAlphabetAndLength(List<String> str) {
        return str.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .toList();
    }

    public static List<String> oddLengthStrings(List<String> str) {
        return str.stream()
                .filter(s -> s.length() % 2 != 0)
                .toList();
    }

    public static List<String> evenLengthStrings(List<String> str) {
        return str.stream()
                .filter(s -> s.length() % 2 == 0)
                .toList();
    }

    public static List<String> palindromeString(List<String> str) {
        return str.stream()
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .toList();
    }

    public static List<String> separateCamelcaseString(String str) {
        return Arrays.stream(str.split("(?=[A-Z])"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .toList();
    }


    public static void main(String[] args) {

        List<String> str = Arrays.asList("Shri", "Banana", "Apple", "Toyota", "Pune", "Mumbai", "Internal", "lol");

        System.out.println("Longest String: " + longestString(str));
        System.out.println("Longest String Length: " + longestStringLength(str));
        System.out.println("Smallest String: " + smallestString(str));
        System.out.println("Smallest String Length: " + smallestStringLength(str));
        System.out.println("Converted to Uppercase: " + convertToUpperCase(str));
        System.out.println("Converted to Lowercase: " + convertToLowerCase(str));
        System.out.println("Concatenate String: " + concatinateString(str));
        System.out.println("Concatenate String with Camelcase: " + concatenateWithCamelcase(str));
        System.out.println("Get Length of Each Word: " + getLength(str));
        System.out.println("Sort List ascendingly According to Length : " + sortAscendingWithLength(str));
        System.out.println("Sort List ascendingly According to Alphabets : " + sortAscendingWithAlphabet(str));
        System.out.println("Sort List ascendingly According to Alphabets and length : " + sortAscendingWithAlphabetAndLength(str));
        System.out.println("Odd Length Strings: " + oddLengthStrings(str));
        System.out.println("Even Length Strings: " + evenLengthStrings(str));
        System.out.println("Palindrome String: " + palindromeString(str));
        System.out.println("Separate Words From Camelcase: " + separateCamelcaseString(concatenateWithCamelcase(str)));
    }

}
