//Deficient Number
import java.util.Scanner;
public class Session_1 {
    public static boolean isDeficient(int x) {
        if (x <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                sum += i;
                if (i != 1 && i * i != x) {
                    sum += x / i;
                }
            }
        }
        sum += x; 
        return sum < (2 * x);
    }
    public static void main(String[] campaigners) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            System.out.println(isDeficient(x));
        }
        scanner.close();
    }
}