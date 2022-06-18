import java.util.Scanner;
import java.util.Stack;

/**
 * @author David (_Esel)
 */
public class Brackets {
    enum Type {
        BASIC('(', ')'),
        ARRAY('[', ']'),
        SHARP('<', '>'),
        BLOCK('{', '}');

        private final char start, end;

        Type(char start, char end) {
            this.start = start;
            this.end = end;
        }
    }

    private static void runTest(String line) {
        int count = 0;
        Stack<Type> stack = new Stack<>();
        main:
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            for (Type type : Type.values()) {
                if (type.start == ch) {
                    stack.push(type);
                    continue main;
                } else if (!stack.empty() && type.end == ch && stack.pop() == type) {
                    if (stack.empty()) {
                        count++;
                    }
                    continue main;
                }
            }
            System.out.println("INVALID");
            return;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for (int test = 0; test < tests; test++) {
            runTest(scanner.nextLine());
        }
    }
}