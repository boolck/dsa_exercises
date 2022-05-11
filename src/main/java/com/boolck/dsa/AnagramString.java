package com.boolck.dsa;

/*
        Please check if two Strings are "Anagram",
        Definition of anagram: If you rearrange the order of the letters / characters in two strings,
        you can get the same string: e.g: cinema, iceman.
*/

public class AnagramString {

    private static  boolean areTwoStringsAnagram(String textA, String textB) {
        if (textA == null || textB == null) {
            return false;
        }

        if (textA.length() != textB.length()) {
            return false;
        }

        int[] checkerArray = new int[256];
        for (char a : textA.toCharArray()) {
            checkerArray[a]++;
        }

        for (char b : textB.toCharArray()) {
            checkerArray[b]--;
        }

        for (int netValue : checkerArray) {
            if (netValue != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args){
        System.out.println(areTwoStringsAnagram("abc","cab"));
        System.out.println(areTwoStringsAnagram("aaa","bbbc"));
    }

}
