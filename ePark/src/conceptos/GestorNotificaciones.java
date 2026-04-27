/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

/**
 *
 * @author mathiasviquez
 */
public class GestorNotificaciones {

    private app aplicacion;

    public GestorNotificaciones(app aplicacion) {
        this.aplicacion = aplicacion; 
    }

    public void enviarAviso(sesiones sesion) {
        String mensaje = "Su parqueo está por vencer en 5 minutos";
        aplicacion.mostrarNotificacion(mensaje);
    }
}
