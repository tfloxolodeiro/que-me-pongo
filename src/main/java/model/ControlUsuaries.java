package model;

import apis.MailSender;
import apis.NotificationService;

import java.util.List;

public class ControlUsuaries {
    List<Usuarie> usuaries;
    IServicioMeteorologico servicioMeteorologico;
    MailSender mailSender;
    NotificationService notificationService;

    public void calcularSugerenciasDiarias(){
        usuaries.forEach(usuarie -> usuarie.actualizarSugerenciaDiaria(servicioMeteorologico));
    }

    public void enviarMailGlobal(String textoDeMail){
        usuaries.forEach(usuarie -> usuarie.recibirMail(textoDeMail,mailSender));
    }

    public void enviarNotificacionGlobal(String textoNotificacion){
        usuaries.forEach(usuarie -> usuarie.recibirNotificacion(textoNotificacion,notificationService));
    }
}
