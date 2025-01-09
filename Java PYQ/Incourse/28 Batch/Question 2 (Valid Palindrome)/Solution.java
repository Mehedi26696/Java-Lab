// You will be given a string S containing only capital letters.YOu can select any number of letters from S in any order to construct a palindrome string.
// You need to return the length of the longest palindrome that can be constructed from S.
// There can be multiple string possible of maximum length, you need to return any one of them.

// Input
// A string S containing only capital letters.
// 1<=|S|<=10^5
// Output
// Return the length of the longest palindrome that can be constructed from S.

// Example
// S="AABBC"
// Output="AABCBA" or "ABACBA"

// S="AABB"
// Output="ABBA"

import java.util.*;

public class Solution {
    public static String longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        StringBuilder leftHalf = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        
        for (int i = 0; i < 128; i++) {
            if (count[i] % 2 == 1) {
                middle.append((char) i);
            }
            for (int j = 0; j < count[i] / 2; j++) {
                leftHalf.append((char) i);
            }
        }
        
        String rightHalf = new StringBuilder(leftHalf).reverse().toString();
        if (middle.length() > 0) {
            leftHalf.append(middle.charAt(0));
        }
        leftHalf.append(rightHalf);
        
        return leftHalf.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestPalindrome(s));
        sc.close();
    }
}
