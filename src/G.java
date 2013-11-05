/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 05.11.13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class G {
    Scanner in;
    PrintWriter out;

    int n;
    BigInteger m;
    char[] a;
    BigInteger[][] _d;
    char[] brackets = {'(', ')', '[', ']'};

    public BigInteger d(int i, int j) {
        if (j < 0) return BigInteger.ZERO;
        return _d[i][j];
    }

    public void getObj() {
        int b = 0;
        for (int i = 0; i < 2 * n; ++i) {
            BigInteger cd = d(n * 2 - i - 1, b + 1);
            for(int)
                if (m.compareTo(cd) < 0) {
                    a[i] = '(';
                    b++;
                } else {
                    m = m.subtract(cd);
                    a[i] = ')';
                    b--;
                }
        }
    }

    public void solve() throws IOException {
        n = in.nextInt();
        m = in.nextBigInteger();
        a = new char[n * 2];

        _d = new BigInteger[2 * n][n+2];
        _d[0][0] = BigInteger.ONE;
        for (int i = 1; i < 2 * n; ++i) {
            for (int j = 0; j <= n; ++j) {
                _d[i][j] = d(i - 1, j - 1).add(d(i - 1, j + 1));
            }
        }

        getObj();
        out.write(a);
    }

    public void run() {
        try {
            in = new Scanner(new File("num2brackets.in"));
            out = new PrintWriter(new File("num2brackets.out"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        new G().run();
    }
}

