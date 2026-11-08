class Solution {
    int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            throw new IllegalArgumentException("invalid array");
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[] {i + 1, j + 1};
            } else if (nums[i] + nums[j] < target) {
                i += 1;
            } else {
                j -= 1;
            }
        }

        // NOTE: there will always be at least one solution
        throw new IllegalArgumentException("no solution");
    }
}
