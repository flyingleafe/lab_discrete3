/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 05.11.13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;
import java.io.*;

public class B {
    FastScanner in;
    PrintWriter out;

    int n;
    int[] a;
    long[] fc;
    boolean[] used;

    public long getNum() {
        long k = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < a[i]; ++j) {
                if (!used[j - 1]) {
                    k += fc[n - i - 1];
                }
            }
            used[a[i] - 1] = true;
        }
        return k;
    }

    public void solve() throws IOException {
        fc = new long[18];
        fc[0] = 1;
        for (int i = 1; i < 18; ++i) {
            fc[i] = fc[i - 1] * i;
        }
        n = in.nextInt();
        a = new int[n];
        used = new boolean[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        out.printf("%d", getNum());
    }

    public void run() {
        try {
            in = new FastScanner(new File("perm2num.in"));
            out = new PrintWriter(new File("perm2num.out"));

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
        new B().run();
    }
}
