package model;

import apis.NotificationService;

import java.util.List;

public class TormentaObserver implements IAlertasObserver{
    ControlUsuaries controlUsuaries;

    public TormentaObserver(ControlUsuaries controlUsuaries) {
        this.controlUsuaries = controlUsuaries;
    }

    private boolean hayTormenta(List<Alerta> alertas){
        return alertas.contains(Alerta.TORMENTA);
    }

    @Override
    public void actuarSegunAlertas(List<Alerta> alertas) {
        if(hayTormenta(alertas)){
            controlUsuaries.enviarNotificacionGlobal("Esta tormentoso, llevate un paraguas.");
        }
    }
}