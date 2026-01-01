package ArrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (set.contains(currChar)) {
                while (set.contains(currChar)) {
                    set.remove(s.charAt(j++));
                }
            }

            max = Math.max(max, i - j + 1);
            set.add(currChar);
        }

        return max;
    }
}
