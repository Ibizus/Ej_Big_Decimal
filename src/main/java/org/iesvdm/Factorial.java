package org.iesvdm;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * Ejercicios Big Decimal
 */
public class Factorial {

    private long n;
    private BigInteger factorial;

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public BigInteger getFactorial() {
        return factorial;
    }

    public void setFactorial(BigInteger factorial) {
        this.factorial = factorial;
    }

    public Factorial(long n) {
        if ( n >= 0)
            this.n = n;
        else
            throw new RuntimeException("Valor " + n + " no permitido.");
    }

    public BigInteger calcula() {
        //TODO
        BigInteger nuevo = BigInteger.valueOf(n);

        for (int i = 1; i < n; i++)
        {
            nuevo = nuevo.multiply(BigInteger.valueOf(i));
        }

        setFactorial(nuevo);
        return nuevo;
    }

}
