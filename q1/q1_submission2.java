/**
 * my second submission which has a linear runtime
 *
 * */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement) && seen.get(complement) != i) {
                return new int[] {seen.get(complement), i};
            } else {
                seen.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}