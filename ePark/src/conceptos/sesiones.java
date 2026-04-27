/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Daniel
 */
public class sesiones {
    private double tarifaPorMinuto;
    private int zona;
    private LocalDateTime horaInicio;
    private LocalDateTime fechaLimite;
    private vehiculos vehiculo;
    private boolean activa;

    public sesiones(double tarifaPorMinuto, int zona, LocalDateTime horaInicio, vehiculos vehiculo) {
        this.tarifaPorMinuto = tarifaPorMinuto;
        this.fechaLimite = horaInicio.plusDays(3);
        this.zona = zona;
        this.horaInicio = horaInicio;
        this.vehiculo = vehiculo;
        this.activa = true;
    }

    public int getZona() {
        return zona;
    }

    public vehiculos getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public double getTarifaPorMinuto() {
        return tarifaPorMinuto;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    public LocalDateTime getFechaLimite() { 
        return fechaLimite; 
    }
    /**
     * Calcula el total a pagar con la tarifa por minuto segun el tiempo
     */
    public double getTotalActual() {
        LocalDateTime ahora = LocalDateTime.now();

        // Si no ha pasado la fecha límite, cobro normal
        if (ahora.isBefore(fechaLimite)) {
            long minutosTranscurridos = Duration.between(horaInicio, ahora).toMinutes();
            return minutosTranscurridos * tarifaPorMinuto;
        } 
        // Si pasó la fecha límite, los primeros 3 días normal y el resto doble
        else {
            long minutosNormales = Duration.between(horaInicio, fechaLimite).toMinutes();
            long minutosDoble = Duration.between(fechaLimite, ahora).toMinutes();
            return (minutosNormales * tarifaPorMinuto) + (minutosDoble * tarifaPorMinuto * 2);
        }
    }
    
    public double finalizar(){
        double totalAPagar = this.getTotalActual();
        return totalAPagar;
    }
    
    public Duration calcularTiempoRestante() {
        return Duration.between(LocalDateTime.now(), fechaLimite);
    }

    public boolean estaPorVencer() {
        return calcularTiempoRestante().toMinutes() <= 5;
    }
}
