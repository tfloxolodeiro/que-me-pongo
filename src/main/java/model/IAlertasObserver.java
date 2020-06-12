package model;

import java.util.List;

public interface IAlertasObserver {
    void actuarSegunAlertas(List<Alerta> alertas);
}
