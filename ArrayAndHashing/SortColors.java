package ArrayAndHashing;

public class SortColors {
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for (int i : nums) {
            if (i == 0)
                countZero++;
            else if (i == 1)
                countOne++;
            else
                countTwo++;
        }
        int index = 0;

        while (countZero-- > 0)
            nums[index++] = 0;
        while (countOne-- > 0)
            nums[index++] = 1;
        while (countTwo-- > 0)
            nums[index++] = 2;

    }
}
