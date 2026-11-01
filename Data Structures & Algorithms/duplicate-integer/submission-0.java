class Solution {
    public boolean hasDuplicate(int[] nums) {
        // NOTE: the set is deliberately not presized to nums.length. Presizing
        // avoids rehashing when there are no duplicates, but allocates a table for
        // every element up front, even when a duplicate appears early and
        // Set#add returning false ends the loop.
        final Set<Integer> set = new HashSet<>();

        for (int n: nums) {
            if (!set.add(n)) {
                return true;
            }
        }

        return false;
    }
}