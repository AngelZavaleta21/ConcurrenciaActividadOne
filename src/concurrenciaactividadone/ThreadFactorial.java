
package concurrenciaactividadone;

import java.math.BigInteger;

/**
 *
 * @author Angel Zavaleta
 */
public class ThreadFactorial implements Runnable {
    int n1;
    int n2;
    BigInteger result[];
   
    int pos;
    
    public ThreadFactorial(int n1, int n2, BigInteger result[], int pos) {
        this.n1 = n1;
       this.n2 = n2;
        this.result = result;
        this.pos = pos;
    }

    @Override
    public void run() {
        BigInteger r = BigInteger.ONE;
        for (int i = n1; i <= n2; i++) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        result[pos] = r;
    }
}
