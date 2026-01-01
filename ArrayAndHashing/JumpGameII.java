package ArrayAndHashing;

public class JumpGameII {
    public int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int jumps = 0;

        while (end < nums.length - 1) {
            int farthest = 0;

            for (int i = start; i <= end; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            start = end + 1;
            end = farthest;

            jumps++;
        }

        return jumps;
    }
}
