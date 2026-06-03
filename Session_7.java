//Minimum Window Substring
import java.util.*;
public class Session_7 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int required = targetMap.size();
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    formed++;
                }
            }
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).equals(targetMap.get(leftChar))) {
                        formed--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}