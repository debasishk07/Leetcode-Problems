// 1400. Construct K Palindrome Strings
// Medium
// Topics
// Companies
// Hint
// Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

 

// Example 1:

// Input: s = "annabelle", k = 2
// Output: true
// Explanation: You can construct two palindromes using all characters in s.
// Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
// Example 2:

// Input: s = "leetcode", k = 3
// Output: false
// Explanation: It is impossible to construct 3 palindromes using all the characters of s.
// Example 3:

// Input: s = "true", k = 4
// Output: true
// Explanation: The only possible solution is to put each character in a separate string.
 

// Constraints:

// 1 <= s.length <= 105
// s consists of lowercase English letters.
// 1 <= k <= 105

import java.util.*;

class ConstructKPalindrome {
    public static boolean canConstruct(String s, int k) {
        if(s.length() < k ) return false;

        HashMap<Character,Integer> charCount = new HashMap<>();
        for(char c :s.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c,0)+1);
        }

        int oddCount = 0;
        for(int freq: charCount.values()){
            if(freq%2 !=0) oddCount++;
        }

        return oddCount <=k;
    }
    public static void main(String args[]){
        String s = "anabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));

    }
}