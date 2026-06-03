//closest subsequence sum
import java.util.*;
public class Session_4 {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();
        generateSums(nums, 0, n / 2, 0, leftSums);
        generateSums(nums, n / 2, n, 0, rightSums);
        Collections.sort(rightSums);
        int minDiff = Integer.MAX_VALUE;
        for (int leftSum : leftSums) {
            int target = goal - leftSum;
            int idx = Collections.binarySearch(rightSums, target);
            if (idx >= 0) {
                return 0;
            }
            int insertionPoint = -idx - 1;
            if (insertionPoint < rightSums.size()) {
                minDiff = Math.min(minDiff, Math.abs(leftSum + rightSums.get(insertionPoint) - goal));
            }
            if (insertionPoint > 0) {
                minDiff = Math.min(minDiff, Math.abs(leftSum + rightSums.get(insertionPoint - 1) - goal));
            }
        }
        return minDiff;
    }
    private void generateSums(int[] nums, int start, int end, int currentSum, List<Integer> sums) {
        if (start == end) {
            sums.add(currentSum);
            return;
        }
        generateSums(nums, start + 1, end, currentSum, sums);
        generateSums(nums, start + 1, end, currentSum + nums[start], sums);
    }
}