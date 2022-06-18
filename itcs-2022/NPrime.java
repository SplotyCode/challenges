import java.util.Scanner;

/**
 * @author David (_Esel)
 */
public class NPrime {
    private static int[] primes = new int[] {2};
    private static int count = 1;
    private static int number = 3;

    public static int[] primes(int n) {
        if (primes.length < n) {
            int[] copy = new int[n];
            System.arraycopy(primes, 0, copy, 0, primes.length);
            primes = copy;
        }
        while (count < n) {
            if (isOddPrime(number, primes)) {
                primes[count] = number;
                count++;
            }
            number = number + 2;
        }
        return primes;
    }


    private static boolean isOddPrime(int candidate, int[] primes) {
        int largestSmallerFactor = (int) (Math.sqrt(candidate));
        for (int i = 1; primes[i - 1] <= largestSmallerFactor; i++) {
            if (candidate % primes[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int test = 0; test < tests; test++) {
            int n = scanner.nextInt();
            System.out.println(primes(n + 1)[n]);
        }
    }
}
