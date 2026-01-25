package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {
    private List<Integer> prefixSums;
    private int totalWeight;
    private Random random;

    public RandomPickWithWeight(int[] w) {
        prefixSums = new ArrayList<>();
        random = new Random();

        int runningSum = 0;
        for (int weight : w) {
            runningSum += weight;
            prefixSums.add(runningSum);
        }
        this.totalWeight = runningSum;
    }

    public int pickIndex() {
        int target = random.nextInt(totalWeight) + 1;

        int st = 0, end = prefixSums.size() - 1;
        while (st < end) {
            int mid = st + (end - st) / 2;
            if (prefixSums.get(mid) < target) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }
        return st;
    }
}
