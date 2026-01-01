package ArrayAndHashing;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int l = j - i;
            max = Math.max(max, Math.min(height[i], height[j]) * l);

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }
}
