class Solution {
    public int[] twoSum(int[] nums, int target) {
        return twoSumWithHashMapOnePass(nums, target);
    }

    int[] twoSumWithHashMapOnePass(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            Integer j = map.get(b);
            if (j != null) {
                return new int[]{Math.min(i, j), Math.max(i, j)};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("unexpected input without solution");
    }
}
