package ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        p = new String(pChars);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= s.length() - p.length(); i++) {
            String temp = s.substring(i, i + p.length());
            char[] tempChars = temp.toCharArray();
            Arrays.sort(tempChars);
            temp = new String(tempChars);
            if (temp.equals(p)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public List<Integer> findAnagramsOptimized(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray())
            pCount[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
