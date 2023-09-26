package org.iesvdm;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
    Ejercicio 2. Interés compuesto con BigDecimal.

    Una persona invierte un ‘monto principal’ en una cuenta de ahorro
    que produce un % de interés dado.
    Suponiendo que el interés se deposita en la cuenta,
    calcula y muestra el monto de dinero en la cuenta al final de cada año,
    durante ‘n’ años. Use la siguiente fórmula para determinar los montos anuales:

    c = p(1 +r)^n  en donde:

    p es el monto que se invirtió originalmente (es decir, el monto principal)
    r es la tasa de interés anual (por ejemplo, use 0.05 para el 5%)
    n es el número de años
    c es la cantidad depositada al final del año enésimo.
 */

public class InteresCompuesto {

    private BigDecimal p;
    private BigDecimal r;
    private int n;
    private BigDecimal c;

    public InteresCompuesto(BigDecimal p, BigDecimal r, int n) {
        this.p = p;
        this.r = r;
        this.n = n;
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getR() {
        return r;
    }

    public void setR(BigDecimal r) {
        this.r = r;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public BigDecimal getC() {
        return c;
    }

    public void setC(BigDecimal c) {
        this.c = c;
    }

    public BigDecimal calculaMontoFinal() {
        //TODO
        // subdivido la operacion para no hacer una linea muy larga:
        // c = p(1+r)^n

        BigDecimal interes = BigDecimal.valueOf(Long.parseLong("1")).add(this.r.multiply(BigDecimal.valueOf(Double.parseDouble("0.01"))));
        BigDecimal interesAcumulado = interes.pow(this.n);
        this.c = this.p.multiply(interesAcumulado);

        return this.c;
    }

}
