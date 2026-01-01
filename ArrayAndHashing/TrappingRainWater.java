package ArrayAndHashing;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(height[i], max);
            leftMax[i] = max;
        }

        max = -1;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            rightMax[i] = max;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return sum;
    }
}
