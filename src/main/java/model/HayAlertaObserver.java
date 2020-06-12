package model;

import apis.MailSender;

import java.util.List;

public class HayAlertaObserver implements IAlertasObserver{
    ControlUsuaries controlUsuaries;

    public HayAlertaObserver(ControlUsuaries controlUsuaries) {
        this.controlUsuaries = controlUsuaries;
    }

    private boolean hayAlerta(List<Alerta> alertas){
        return !alertas.isEmpty();
    }

    @Override
    public void actuarSegunAlertas(List<Alerta> alertas) {
        if(hayAlerta(alertas)){
            controlUsuaries.enviarMailGlobal("Alertas meteorologicas: " + alertas);
            controlUsuaries.calcularSugerenciasDiarias();
        }
    }
}
