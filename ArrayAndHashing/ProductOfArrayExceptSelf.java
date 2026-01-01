package ArrayAndHashing;

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int totalProduct = 1;

        for (int i : nums) {
            if (i == 0) {
                zeroCount++;
                continue;
            }
            totalProduct *= i;
        }

        int[] ans = new int[nums.length];

        if (zeroCount > 1) {
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    ans[i] = totalProduct;
                    break;
                }
            } else {
                ans[i] = totalProduct / nums[i];
            }
        }

        return ans;
    }
}