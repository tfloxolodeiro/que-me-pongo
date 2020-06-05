package model;

public interface IServicioMeteorologico {

    float temperaturaCelsius(String direccion);
    float temperaturaFahrenheit(String direccion);
    float probabilidadesDePrecipitacion(String direccion);
    boolean esDeDia(String direccion);

}
