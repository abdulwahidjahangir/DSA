package BinarySearch;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] < target) {
            return letters[0];
        }

        int st = 0;
        int end = letters.length - 1;
        Character ans = null;

        while (st <= end) {
            int mid = st + ((end - st) / 2);

            char currChar = letters[mid];

            if (currChar <= target) {
                st = mid + 1;
                continue;
            }

            ans = currChar;
            end = mid - 1;
        }

        if (ans == null) {
            return letters[0];
        }

        return ans;
    }
}
