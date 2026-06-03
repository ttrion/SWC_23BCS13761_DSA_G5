//find the power of k-size subarrays 2
public class Session_5 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        if (k == 1) {
            return nums;
        }
        int consecutiveCount = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }
            if (i >= k - 1) {
                if (consecutiveCount >= k) {
                    results[i - k + 1] = nums[i];
                } else {
                    results[i - k + 1] = -1;
                }
            }
        }
        return results;
    }
}
