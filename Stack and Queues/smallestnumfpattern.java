import java.io.*;
import java.util.*;

public class smallestnumfpattern {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> st = new Stack<>();
        int s = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'i') {
                st.push(s);
                s++;
                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            } else {
                st.push(s);
                s++;
            }
        }
        st.push(s);
        while (st.size() > 0) {
            System.out.print(st.pop());
        }
        // code
    }
}