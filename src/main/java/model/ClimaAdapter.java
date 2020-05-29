package model;

import apis.AccuWeatherAPI;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClimaAdapter implements ICondicionesClimaticas {
    private static final AccuWeatherAPI apiClima = new AccuWeatherAPI();
    private static List<Map<String, Object>> ultimasCondicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
    //Se llama a la API y se guarda una lista de condiciones climaticas que se usa hasta que sea necesaria actualizarla, para evitar llamar excesivamente a la API y generar costos innecesarios.
    //Al ser los atributos static, todas las instancias de model.ClimaAdapter comparten la misma lista de ultimasCondicionesClimaticas.
    //Esto solo funciona si la aplicacion se usa solo en Buenos Aires, por lo que si a futuro se quiere extender a otros lugares, habria que cambiar todo esto, junto a la interfaz.

    @Override
    public float temperaturaCelsius() {
        return (temperaturaFahrenheit()-32)*5/9;
    }

    @Override
    public float temperaturaFahrenheit() {
        return (float) ((HashMap) elementoDelClimaActual("Temperature")).get("Value");
    }

    @Override
    public float probabilidadesDePrecipitacion() {
        return (float) elementoDelClimaActual("PrecipitationProbability");
    }

    @Override
    public boolean esDeDia() {
        return (boolean) elementoDelClimaActual("IsDaylight");
    }



    private Object elementoDelClimaActual(String elementoBuscado){
        return climaActual().get(elementoBuscado);
    }

    private Map<String, Object> climaActual(){
        return (Map<String, Object>) getUltimasCondicionesClimaticas().stream().filter(clima -> (long) clima.get("EpochDateTime") == LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    } //La implementacion puede no estar correcta pero se quiere buscar de la lista las condiciones climaticas especificas del tiempo actual.

    private List<Map<String, Object>> getUltimasCondicionesClimaticas(){
        if(!lasCondicionesEstanActualizadas()){
            actualizarCondicionesClimaticas();
        }
        return ultimasCondicionesClimaticas;
    }

    private void actualizarCondicionesClimaticas() {
        ultimasCondicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
    } //Solo se llama a la api cuando se necesita actualizar las condiciones climaticas.

    private boolean lasCondicionesEstanActualizadas() {
         return horasDesdeLaUltimaActualizacion() < 12;
    }

    private long horasDesdeLaUltimaActualizacion(){
        return Duration.between(tiempoUltimaActualizacion(), LocalDateTime.now()).toHours();
    }

    private LocalDateTime tiempoUltimaActualizacion(){
        return LocalDateTime.parse((String) ultimasCondicionesClimaticas.get(0).get("Datetime"));
    }
}
