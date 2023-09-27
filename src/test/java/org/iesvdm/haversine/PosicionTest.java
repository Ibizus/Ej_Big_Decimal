package org.iesvdm.haversine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PosicionTest {


    @Test
    public void distanciaEntreDosPuntos()
    {
        double lat1 = 41.57879d; // 72568.678449 rad
        double long1 = 1.617221d; // 28225.831182 rad
        double lat2 = 37.176487d; // 648852.102473 rad
        double long2 = -3.597929d; // -62795.707303 rad
        BigDecimal expected = new BigDecimal("664.20");
        Posicion Igualada = new Posicion(BigDecimal.valueOf(lat1), BigDecimal.valueOf(long1));
        Posicion Granada = new Posicion(BigDecimal.valueOf(lat2), BigDecimal.valueOf(long2));

        BigDecimal distanciaEntrePosiciones = Igualada.distancia(Granada);
        distanciaEntrePosiciones = distanciaEntrePosiciones.setScale(2, RoundingMode.HALF_UP);

        Assertions.assertEquals(expected, distanciaEntrePosiciones);
    }

}
