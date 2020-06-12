package model;

import java.util.List;

public interface IServicioMeteorologico {

    float temperaturaCelsius(String direccion);
    float temperaturaFahrenheit(String direccion);
    float probabilidadesDePrecipitacion(String direccion);
    boolean esDeDia(String direccion);
    List<Alerta> alertasActuales(String direccion);


}
