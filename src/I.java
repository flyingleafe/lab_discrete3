/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 07.11.13
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.io.*;

public class I {
    FastScanner in;
    PrintWriter out;

    int n;
    long r;
    long[][] d;
    int[] a;

    public void genObj() {
        int sum = 0;
        for(int i=0 ;i<n; ++i) {
            for(int j = (i > 0)? a[i-1] : 1; j<=n; ++j) {
                if(r >= d[n-sum-j][j]) {
                    r -= d[n-sum-j][j];
                } else {
                    sum += j;
                    a[i] = j;
                    break;
                }
            }
            if(sum == n)
                break;
        }
    }

    public void solve() throws IOException {
        n = in.nextInt();
        r = Long.parseLong(in.next());
        d = new long[n+1][n+1];
        a = new int[n];
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
        genObj();
        int f = 0;
        while((f < n) && (a[f] != 0)) f++;
        for(int i=0; i<f-1; ++i)
            out.printf("%d+", a[i]);
        out.printf("%d", a[f-1]);
    }

    public void run() {
        try {
            in = new FastScanner(new File("num2part.in"));
            out = new PrintWriter(new File("num2part.out"));

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
        new I().run();
    }
}
