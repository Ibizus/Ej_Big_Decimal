package org.iesvdm.haversine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PosicionTest {


    @Test
    public void distanciaEntreDosPuntos()
    {
        double lat1 = 41.57879d;
        double long1 = 1.617221d;
        double lat2 = 37.176487;
        double long2 = -3.597929;
        BigDecimal expected = new BigDecimal(664);
        Posicion Igualada = new Posicion(BigDecimal.valueOf(lat1), BigDecimal.valueOf(long1));
        Posicion Granada = new Posicion(BigDecimal.valueOf(lat2), BigDecimal.valueOf(long2));

        BigDecimal distanciaEntrePosiciones = Igualada.distancia(Granada);

        Assertions.assertEquals(expected, distanciaEntrePosiciones);
    }

}
