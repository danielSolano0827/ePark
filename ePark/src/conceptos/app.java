/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import static java.lang.Math.random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class app {
    double identificador;

    public app(double identificador) {
        this.identificador = identificador;
    }

    public app() {
        this.identificador = random();
    }
    
    // Notifica cuando inicia una sesion (Un vehiculo se parquea)
    public void notificarInicio(sesiones sesion) {
        System.out.println("=== Sesion Iniciada ===");
        System.out.println("Vehiculo: " + sesion.getVehiculo().getPlaca());
        System.out.println("Zona: " + sesion.getZona());
        System.out.println("Hora inicio: " + sesion.getHoraInicio());
        System.out.println("Tarifa por minuto: " + sesion.getTarifaPorMinuto());
    }
    
    // Notifica cuando se finaliza una sesion (Un vehiculo se retira)
    public void notificarFin(sesiones sesion, LocalDateTime horaFin) {
        System.out.println("=== Sesion Finalizada ===");
        System.out.println("Vehiculo: " + sesion.getVehiculo().getPlaca());
        System.out.println("Hora inicio: " + sesion.getHoraInicio());
        System.out.println("Hora fin: " + horaFin);
        System.out.println("Total a cobrar: " + sesion.getTotalActual());
    }
    
    
    public ArrayList<comprobantes> solicitarPagos(LocalDate fecha, int idCliente, repositorioPagos repositorio) {
        gestorDeCobros gestor = new gestorDeCobros();
        return gestor.obtenerPagos(fecha, idCliente, repositorio);
    }
    
    
    public void mostrarPagos(ArrayList<comprobantes> listaPagos) {
        for(comprobantes comprobante : listaPagos){
            System.out.println("======= Comprobante # " + comprobante.getCodigoComprobante() + " =======");
            System.out.println();
            System.out.println("Ientificacion      : " + comprobante.getUsuario());
            System.out.println("Metodo de Pago     : " + comprobante.getTipoDePago());
            System.out.println("Monto emitido      : " + comprobante.getMontoEmitido() + "$");
            System.out.println("Fecha de ocupación : " + comprobante.getFechaDeUso());
            System.out.println("Fecha de emisión   : " + comprobante.getFechaEmision() );
            System.out.println();
        }
    }
    
    public void mostrarNotificacion(String mensaje) {
        System.out.println("NOTIFICACIÓN: " + mensaje);
    }
}
