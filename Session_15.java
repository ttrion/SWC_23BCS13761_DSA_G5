//Max Value of equation
import java.util.*;

public class Session_15 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
            while (!dq.isEmpty() && x - dq.peekFirst()[0] > k) {
                dq.pollFirst();
            }
            if (!dq.isEmpty()) {
                ans = Math.max(ans, x + y + dq.peekFirst()[1]);
            }
            int val = y - x;
            while (!dq.isEmpty() && dq.peekLast()[1] <= val) {
                dq.pollLast();
            }
            dq.offerLast(new int[] { x, val });
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        int k = sc.nextInt();
        Session_15 obj = new Session_15();
        System.out.println(obj.findMaxValueOfEquation(points, k));
        sc.close();
    }
}