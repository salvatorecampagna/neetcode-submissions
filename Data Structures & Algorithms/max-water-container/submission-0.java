class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxWater = -1;

        while (i < j) {
            int water = Math.min(heights[i], heights[j]) * (j - i);
            maxWater = Math.max(water, maxWater);
            if (heights[i] < heights[j]) {
                i++;
            } else if (heights[i] > heights[j]) {
                j--;
            } else {
                i++; j--;
            }
        }

        return maxWater;
    }
}
