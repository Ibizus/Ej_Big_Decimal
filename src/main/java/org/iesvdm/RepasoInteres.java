package org.iesvdm;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RepasoInteres {

    private BigDecimal inicial;
    private BigDecimal interes;
    private Integer años;
    private BigDecimal total;


    public RepasoInteres(BigDecimal inicial, BigDecimal interes, Integer años) {
        this.inicial = inicial;
        this.interes = interes.divide(new BigDecimal("100"));
        this.años = años;
        this.total = calculaAcumulado();
    }

    private BigDecimal calculaAcumulado(){

        BigDecimal acum = new BigDecimal("0");
        acum = this.inicial.multiply((new BigDecimal("1").add(this.interes)).pow(this.años));
        return acum;
    }

    public BigDecimal getInicial() {
        return inicial;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public Integer getAños() {
        return años;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
