//compress words
import java.io.*;
import java.util.StringTokenizer;
public class Session_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (n == 0) {
            System.out.println("");
            return;
        }
        StringBuilder result = new StringBuilder(st.nextToken());
        for (int i = 1; i < n; i++) {
            String nextWord = st.nextToken();
            int maxOverlap = Math.min(result.length(), nextWord.length());       
            String suffix = result.substring(result.length() - maxOverlap);
            String combined = nextWord + "#" + suffix; 
            int[] lps = computeLPS(combined);
            int overlapLength = lps[combined.length() - 1];
            result.append(nextWord.substring(overlapLength));
        }
        System.out.println(result.toString());
    }
    private static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}