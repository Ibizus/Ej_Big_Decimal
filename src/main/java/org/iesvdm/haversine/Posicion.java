package org.iesvdm.haversine;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/*
 * Implementa el cálculo de la distancia entre 2 puntos en la tierra mediante la fórmula de Haversine
 * Para ello tienes que portar esta implementación de C# a Java, utiliza BigDecimal para los cálculos
 * en vez de precisión en punto flotante, crea un test de prueba de funcionamiento.
 *
            R = radio de la Tierra (radio ecuatorial = 6378 km)
            Δlat = lat2− lat1
            Δlong = long2− long1
            a = sin²(Δlat/2) + cos(lat1) · cos(lat2) · sin²(Δlong/2)
            c = 2 · atan2(√a, √(1−a))
            d = R · c
 */
public class Posicion {

    private BigDecimal latitud;
    private BigDecimal longitud;

    public Posicion(BigDecimal latitud,BigDecimal longitud)
    {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal distancia(Posicion destino)
    {
        // Δlat = lat2− lat1
        // Δlong = long2− long1
        BigDecimal dif_Lat = enRadianes(destino.getLatitud()).subtract(enRadianes(this.getLatitud()));
        BigDecimal dif_Long = enRadianes(destino.getLongitud()).subtract(enRadianes(this.getLongitud()));

        // a = sin²(Δlat/2) + cos(lat1) · cos(lat2) · sin²(Δlong/2)

        // OPERACIONES EN UNA LÍNEA:
        BigDecimal a = BigDecimal.valueOf((Math.sin(dif_Lat.divide(new BigDecimal("2"), RoundingMode.HALF_UP).doubleValue()))).pow(2)
                .add((BigDecimal.valueOf(Math.cos(enRadianes(this.getLatitud()).doubleValue())))
                .multiply(BigDecimal.valueOf(Math.cos(enRadianes(destino.getLatitud()).doubleValue())))
                .multiply((BigDecimal.valueOf(Math.sin(dif_Long.divide(new BigDecimal("2"), RoundingMode.HALF_UP).doubleValue()))).pow(2)));

        /* TAMBIÉN SE PUEDE DIVIDIR EN VARIABLES PARA HACER LEGIBLE EL CÁLCULO:
        BigDecimal senoCuadradoDifLat = BigDecimal.valueOf(Math.sin(dif_Lat.doubleValue()/2)).pow(2);
        BigDecimal cosenoLat1 = BigDecimal.valueOf(Math.cos(enRadianes(this.getLatitud()).doubleValue()));
        BigDecimal cosenoLat2 = BigDecimal.valueOf(Math.cos(enRadianes(destino.getLatitud()).doubleValue()));
        BigDecimal senoCuadradoDifLong = BigDecimal.valueOf(Math.sin(dif_Long.doubleValue()/2)).pow(2);;

        BigDecimal a = senoCuadradoDifLat.add(cosenoLat1.multiply(cosenoLat2.multiply(senoCuadradoDifLong)));
         */

        // c = 2 · atan2(√a, √(1−a))
        BigDecimal c = new BigDecimal("2").
                multiply(BigDecimal.valueOf(Math.atan2
                (a.sqrt(MathContext.DECIMAL128).doubleValue(),
                (new BigDecimal("1").subtract(a, MathContext.DECIMAL128)).sqrt(MathContext.DECIMAL128).doubleValue())));

        // d = R · c
        BigDecimal radioT = new BigDecimal("6378");
        return radioT.multiply(c, MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal enRadianes(BigDecimal coordenada)
    {
        BigDecimal pi = BigDecimal.valueOf(Math.PI);
        return coordenada.multiply(pi.divide(new BigDecimal("180"), MathContext.DECIMAL128));
    }
}