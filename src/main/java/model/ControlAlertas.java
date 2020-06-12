package model;

import java.util.List;

public class ControlAlertas {
    IServicioMeteorologico servicioMeteorologico;
    List<List<Alerta>> ultimasAlertas;
    List<IAlertasObserver> alertasObservers;

    public ControlAlertas(IServicioMeteorologico servicioMeteorologico, List<List<Alerta>> ultimasAlertas, List<IAlertasObserver> alertasObservers) {
        this.servicioMeteorologico = servicioMeteorologico;
        this.ultimasAlertas = ultimasAlertas;
        this.alertasObservers = alertasObservers;
    }


    public void actualizarAlertas(String direccion){ //La direccion tal vez podria ser atributo de la clase, de forma tal que haya un solo control por lugar.
        List<Alerta> nuevasAlertas = servicioMeteorologico.alertasActuales(direccion);
        ultimasAlertas.add(nuevasAlertas);
        alertasObservers.forEach(alertaObserver -> alertaObserver.actuarSegunAlertas(nuevasAlertas));
    }

    public List<List<Alerta>> getUltimasAlertas() {
        return ultimasAlertas;
    }
}
