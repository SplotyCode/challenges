
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author David (_Esel)
 */
public class Roman2 {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String toRoman(int number) {
        int index = map.floorKey(number);
        String current = map.get(index);
        if (index != number) {
            current += toRoman(number - index);
        }
        return current;
    }

    private static void runTest(String line) {
        System.out.println(toRoman(Integer.parseInt(line)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for (int test = 0; test < tests; test++) {
            runTest(scanner.nextLine());
        }
    }
}
