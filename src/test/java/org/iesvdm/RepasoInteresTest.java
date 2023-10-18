package org.iesvdm;

import org.iesvdm.RepasoInteres;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RepasoInteresTest {

    @Test
    public void cuandoPrincipal1000Interes5porcientoY10peridos() {

        String principal = "1000";
        int interes = 5;
        int periodos = 10;

        RepasoInteres interesCompuesto = new RepasoInteres(new BigDecimal(principal), BigDecimal.valueOf(Long.parseLong("" + interes)), periodos);
        BigDecimal cantidadFinal = interesCompuesto.getTotal();
        // redondeo del resultado para que coincida con el marcado en el test:
        cantidadFinal = cantidadFinal.setScale(2, RoundingMode.HALF_UP);

        Assertions.assertEquals(new BigDecimal("1628.89"), cantidadFinal);
    }

}
