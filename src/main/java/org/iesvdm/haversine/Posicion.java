package org.iesvdm.haversine;

import java.math.BigDecimal;

/*
 * Implementa el cálculo de la distancia entre 2 puntos en la tierra mediante la fórmula de Haversine
 * Para ello tienes que portar esta implementación de C# a Java, utiliza BigDecimal para los cálculos
 * en vez de precisión en punto flotante, crea un test de prueba de funcionamiento.
 *
 *          R = radio de la Tierra

            Δlat = lat2− lat1

            Δlong = long2− long1

            a = sin²(Δlat/2) + cos(lat1) · cos(lat2) · sin²(Δlong/2)

            c = 2 · atan2(√a, √(1−a))

            d = R · c

            radio ecuatorial = 6378 km
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

    public static BigDecimal distancia(Posicion destino)
    {
        return null;
    }
}
