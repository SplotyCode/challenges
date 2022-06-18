import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author David (_Esel)
 */
public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            String[] first = scanner.nextLine().split(" ");
            int sum = Integer.parseInt(first[0]);
            int m = Integer.parseInt(first[1]);
            String[] numbers = scanner.nextLine().split(" ");
            if (numbers.length != m) throw new IllegalStateException();
            int[] sumCount = new int[sum + 1];
            sumCount[0] = 1;
            for (String numberStr : numbers) {
                int number = Integer.parseInt(numberStr);
                int idx = 0;
                for (int k = number; k <= sum; k++) {
                    sumCount[k] += sumCount[idx++];
                }
            }
            //System.out.println(Arrays.toString(sumCount));
            System.out.println(sumCount[sum]);
        }
    }
}