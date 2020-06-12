package model;

import apis.NotificationService;

import java.util.List;

public class GranizoObserver implements IAlertasObserver{
    ControlUsuaries controlUsuaries;

    public GranizoObserver(ControlUsuaries controlUsuaries) {
        this.controlUsuaries = controlUsuaries;
    }

    private boolean estaGranizando(List<Alerta> alertas){
        return alertas.contains(Alerta.GRANIZO);
    }

    @Override
    public void actuarSegunAlertas(List<Alerta> alertas) {
        if(estaGranizando(alertas)){
            controlUsuaries.enviarNotificacionGlobal("Esta granizando, evita salir en auto.");
        }
    }
}
