import java.io.*;
import java.util.*;

public class celebrity {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> sts = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            sts.push(i);
        }

        while (sts.size() >= 2) {
            int i = sts.pop();
            int j = sts.pop();

            if (arr[i][j] == 1) {
                sts.push(j);
            } else {
                sts.push(i);
            }
        }

        int pot = sts.pop();

        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    System.out.print("none");
                    return;
                }
            }
        }
        System.out.print(pot);
    }

}