//Minimize Max distance to Gas Station
import java.io.*;
import java.util.*;
public class Session_13 {
    static boolean possible(int[] stations, int k, double dist) {
        int required = 0;
        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            required += (int) Math.ceil(gap / dist) - 1;
            if (required > k) {
                return false;
            }
        }
        return required <= k;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stations = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stations[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        double low = 0.0;
        double high = stations[n - 1] - stations[0];
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            if (possible(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.printf("%.6f%n", high);
    }
}