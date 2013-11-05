/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 05.11.13
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.io.*;

public class F {
    FastScanner in;
    PrintWriter out;

    int n;
    String a;
    long[][] _d;

    public long d(int i, int j) {
        if (j < 0) return 0;
        return _d[i][j];
    }

    public long getNum() {
        long k = 0;
        int b = 0;
        for(int i=0; i<a.length(); ++i) {
            char c = a.charAt(i);
            if(c == '(') {
                b++;
            } else {
                k += d(2*n-i-1, b+1);
                b--;
            }
        }
        return k;
    }

    public void solve() throws IOException {
        a = in.next();
        n = a.length() / 2;

        _d = new long[2 * n][n+2];
        _d[0][0] = 1;
        for (int i = 1; i < 2 * n; ++i) {
            for (int j = 0; j <= n; ++j) {
                _d[i][j] = d(i - 1, j - 1) + d(i - 1, j + 1);
            }
        }

        out.printf("%d ", getNum());
    }

    public void run() {
        try {
            in = new FastScanner(new File("brackets2num.in"));
            out = new PrintWriter(new File("brackets2num.out"));

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
        new F().run();
    }
}

