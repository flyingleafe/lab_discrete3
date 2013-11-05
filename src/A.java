/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 03.11.13
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;
import java.io.*;

public class A {
    FastScanner in;
    PrintWriter out;

    int n;
    long k;
    int[] a;
    long[] fc;
    boolean[] used;

    public void output() {
        for (int i = 0; i < n; ++i) {
            out.printf("%d ", a[i]);
        }
    }

    public void getPerm() {
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (!used[j - 1]) {
                    if (k >= fc[n - i - 1]) {
                        k -= fc[n - i - 1];
                    } else {
                        a[i] = j;
                        used[j - 1] = true;
                        break;
                    }
                }
            }
        }
    }

    public void solve() throws IOException {
        fc = new long[18];
        fc[0] = 1;
        for (int i = 1; i < 18; ++i) {
            fc[i] = fc[i - 1] * i;
        }
        n = in.nextInt();
        k = Long.parseLong(in.next());
        a = new int[n];
        used = new boolean[n];
        getPerm();
        output();
    }

    public void run() {
        try {
            in = new FastScanner(new File("num2perm.in"));
            out = new PrintWriter(new File("num2perm.out"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new A().run();
    }
}
