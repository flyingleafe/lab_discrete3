/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 07.11.13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 07.11.13
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.io.*;

public class J {
    FastScanner in;
    PrintWriter out;

    int n, k;
    long[][] d;
    int[] a;

    public long getNum() {
        long r = 0;
        int sum = 0;
        for(int i=0; i<k; ++i) {
            for(int j=(i > 0)? a[i-1] : 1; j < a[i]; j++) {
                r += d[n-sum-j][j];
            }
            sum += a[i];
        }
        return r;
    }

    public void solve() throws IOException {
        n = 0;
        String s = in.next();
        a = new int[100];
        k = 0;
        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if((c > 47) && (c < 58)) {              // if a number
                a[k] = 10*a[k] + (c - '0');
            } else {
                n += a[k];
                k++;
            }
        }
        n += a[k];
        k++;
        d = new long[n+1][n+1];
        for(int i=1; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                if((i == 0) || (i == j)) {
                    d[i][j] = 1;
                } else {
                    d[i][j] = 1;
                    for(int k=j; k<=i; ++k) {
                        d[i][j] += d[i-k][k];
                    }
                }
            }
        }
        for(int j=0; j<=n; ++j) {
            d[0][j] = 1;
        }
        out.printf("%d", getNum());
    }

    public void run() {
        try {
            in = new FastScanner(new File("part2num.in"));
            out = new PrintWriter(new File("part2num.out"));

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
        new J().run();
    }
}

