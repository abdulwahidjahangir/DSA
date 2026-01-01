package TwoPointersAndSlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            uniqueChars.add(s.charAt(i));
        }

        int maxLength = 0;

        for (char target : uniqueChars) {
            int remainingReplacements = k;
            int left = 0;

            for (int right = 0; right < s.length(); right++) {

                while (s.charAt(right) != target && remainingReplacements == 0) {
                    if (s.charAt(left) != target) {
                        remainingReplacements++;
                    }
                    left++;
                }

                if (s.charAt(right) != target) {
                    remainingReplacements--;
                }

                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
