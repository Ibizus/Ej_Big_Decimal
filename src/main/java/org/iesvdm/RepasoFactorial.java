package org.iesvdm;

import org.junit.jupiter.api.function.Executable;

import java.math.BigInteger;

public class RepasoFactorial{

    private long num;
    private BigInteger factorial;

    public RepasoFactorial(long num){
        this.num = num;
        calculaFactorial();
    }

    private void calculaFactorial() {
        BigInteger acum = BigInteger.valueOf(this.num);

        if(this.num >= 0){

            if(this.num == 0){
                acum = new BigInteger("1");
            }
            else{
                for (int i = 1; i < this.num; i++) {
                    acum = acum.multiply(BigInteger.valueOf(i));
                }
            }
            setFactorial(acum);

        }else{
            setFactorial(null);
            //throw new RuntimeException("Valor " + this.num + " no permitido.");
        }
    }

    public void setFactorial(BigInteger factorial) {
        this.factorial = factorial;
    }

    public long getNum() {
        return num;
    }

    public BigInteger getFactorial() {
        return factorial;
    }

}
