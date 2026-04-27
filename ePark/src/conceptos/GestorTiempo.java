/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.util.ArrayList;

/**
 *
 * @author mathiasviquez
 */
public class GestorTiempo {
    ArrayList<sesiones> sesionesActivas;
    gestorParqueo gestorParqueo; 
    GestorNotificaciones notificador;
    
    public void verificarSesiones() {
        for (sesiones s : sesionesActivas) {
            if (s.estaPorVencer()) {
                notificador.enviarAviso(s);
            }
        }
    }

    public void setSesionesActivas(ArrayList<sesiones> sesionesActivas) {
        this.sesionesActivas = sesionesActivas;
    }

    public void setNotificador(GestorNotificaciones notificador) {
        this.notificador = notificador;
    }  
    
}
