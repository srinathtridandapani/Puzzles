package solutions;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorialBigInteger {

    /**
     * Calculate and print the factorial of a given integer.
     *
     * Note: Factorials of  can't be stored even in a  long long variable. Big integers must be used for such calculations.
     *
     * We recommend solving this challenge using BigIntegers.
     * @param n
     */
    static void extraLongFactorials(int n) {
        BigInteger result = new BigInteger("1");

        for(int i=2; i<=n ; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
