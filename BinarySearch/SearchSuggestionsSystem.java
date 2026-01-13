package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, (a, b) -> a.compareTo(b));

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);

            List<String> temp = new ArrayList<>();
            for (int j = 0; j < products.length; j++) {
                if (products[j].startsWith(prefix)) {
                    temp.add(products[j]);
                }
                if (temp.size() == 3) {
                    break;
                }
            }
            ans.add(temp);
        }

        return ans;
    }
}
