
import java.util.*;

public class mergetwosortedarrays {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
    int l = a.length + b.length;
    int c[] = new int[l];
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        c[k] = a[i];
        i++;
        k++;
      } else {
        c[k] = b[j];
        j++;
        k++;
      }
    }

    while (i < a.length) {
      c[k] = a[i];
      i++;
      k++;
    }
    while (j < b.length) {
      c[k] = b[j];
      j++;
      k++;
    }
    return c;

  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a, b);
    print(mergedArray);
    scn.close();
  }

}