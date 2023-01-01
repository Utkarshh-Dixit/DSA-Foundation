import java.io.*;

import java.util.*;

public class infixconversion {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                ops.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                postfix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                    char op = ops.pop();

                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    postfix.push(postv1 + postv2 + op);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    prefix.push(op + prev1 + prev2);
                }

                ops.push(ch);
            } else if (ch == ')') {
                while (ops.size() > 0 && ops.peek() != '(') {
                    char op = ops.pop();

                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    postfix.push(postv1 + postv2 + op);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    prefix.push(op + prev1 + prev2);
                }

                if (ops.size() > 0) {
                    ops.pop();
                }
            }
        }

        while (ops.size() > 0) {
            char op = ops.pop();

            String postv2 = postfix.pop();
            String postv1 = postfix.pop();
            postfix.push(postv1 + postv2 + op);

            String prev2 = prefix.pop();
            String prev1 = prefix.pop();
            prefix.push(op + prev1 + prev2);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }

    public static int precedence(char op) {
        if (op == '+') {
            return 1;
        } else if (op == '-') {
            return 1;
        } else if (op == '*') {
            return 2;
        } else {
            return 2;
        }
    }
}