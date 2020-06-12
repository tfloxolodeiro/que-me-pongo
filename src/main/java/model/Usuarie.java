package model;

import apis.MailSender;
import apis.NotificationService;

public class Usuarie {
    String direccionCorreo;
    Sugerencia sugerenciaDiaria;
    boolean admiteActualizacionSugerencias;
    boolean admiteMails;
    boolean admiteActualizaciones;

    public void actualizarSugerenciaDiaria(IServicioMeteorologico servicioMeteorologico){
        if(admiteActualizacionSugerencias){
            sugerenciaDiaria = new Sugerencia(servicioMeteorologico);
        }

    }

    public void recibirMail(String textoDeMail, MailSender mailSender) {
        if(admiteMails){
            mailSender.send(textoDeMail,direccionCorreo);
        }

    }

    public void recibirNotificacion(String textoNotificacion, NotificationService notificationService){
        if(admiteActualizaciones){
            notificationService.notify(textoNotificacion);
        }

    }
}
