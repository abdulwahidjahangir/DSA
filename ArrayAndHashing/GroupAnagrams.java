package ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            String temp = new String(sChars);

            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
