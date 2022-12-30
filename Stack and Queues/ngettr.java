import java.util.*;

public class ngettr {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] nge = solve(a);
        display(nge);
        sc.close();
    }

    public static int[] solve(int[] arr) {
        int narr[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length - 1]);
        narr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.size() == 0)
                narr[i] = -1;
            else {
                narr[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return narr;
    }

}
