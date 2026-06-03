//number of submatrices that sum to target
import java.util.HashMap;
import java.util.Map;
public class Session_6 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int c1 = 0; c1 < cols; c1++) {
            for (int c2 = c1; c2 < cols; c2++) {
                map.clear();
                map.put(0, 1);
                int currentSum = 0;
                for (int r = 0; r < rows; r++) {
                    int colSum = matrix[r][c2] - (c1 > 0 ? matrix[r][c1 - 1] : 0);
                    currentSum += colSum;
                    if (map.containsKey(currentSum - target)) {
                        count += map.get(currentSum - target);
                    }
                    map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
                }
            }
        }
        return count;
    }
}