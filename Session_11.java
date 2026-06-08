//Factory Machines
import java.util.*;
class Solution {
    public long factoryMachines(int[] machines, long t) {
        long low = 1;
        long high = 1_000_000_000_000_000_000L;
        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canProduce(machines, t, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canProduce(int[] machines, long t, long time) {
        long products = 0;
        for (int machine : machines) {
            products += time / machine;
            if (products >= t) {
                return true;
            }
        }
        return false;
    }
}