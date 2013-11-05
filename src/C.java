
/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 05.11.13
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;
import java.io.*;

public class C {
    FastScanner in;
    PrintWriter out;

    int n, k;
    long m;
    int[] a;
    long[][] C;

    public void getPerm() {
        for (int i = 0; i < k; ++i) {
            for (int j = (i > 0) ? a[i - 1] + 1 : 1; j <= n + i + 1 - k; ++j) {
                if (m >= C[k - i - 1][n - j]) {
                    m -= C[k - i - 1][n - j];
                } else {
                    a[i] = j;
                    break;
                }
            }
        }
    }

    public void solve() throws IOException {
        C = new long[30][30];
        for (int i = 0; i < 30; ++i) {
            C[0][i] = 1;
            C[i][i] = 1;
        }
        for (int i = 1; i < 30; ++i) {
            for (int j = 1; j < i; ++j) {
                C[j][i] = C[j - 1][i - 1] + C[j][i - 1];
            }
        }

        n = in.nextInt();
        k = in.nextInt();
        m = Long.parseLong(in.next());
        a = new int[k];
        getPerm();
        for (int i = 0; i < k; ++i)
            out.printf("%d ", a[i]);
    }

    public void run() {
        try {
            in = new FastScanner(new File("num2choose.in"));
            out = new PrintWriter(new File("num2choose.out"));

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
        new C().run();
    }
}