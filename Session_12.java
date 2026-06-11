//Planning Expeditions
import java.io.*;
import java.util.*;
public class Session_12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> freq = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        int low = 0, high = m;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            long people = 0;
            for (int c : freq.values()) {
                people += c / mid;
            }
            if (people >= n) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
    }
}