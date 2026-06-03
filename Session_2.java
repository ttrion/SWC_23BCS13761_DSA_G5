//Kth smallest Instructions
public class Session_2 {
    public String kthSmallestPath(int[] destination, int k) {
        int v = destination[0];
        int h = destination[1];
        StringBuilder sb = new StringBuilder();
        int totalSteps = v + h;
        for (int i = 0; i < totalSteps; i++) {
            if (h > 0) {
                int count = combination(h + v - 1, h - 1);
                if (k <= count) {
                    sb.append('H');
                    h--;
                } else {
                    sb.append('V');
                    k -= count;
                    v--;
                }
            } else {
                sb.append('V');
                v--;
            }
        }
        return sb.toString();
    }
    private int combination(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
        }
        return (int) res;
    }
}
