/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author kenni
 */
public class gestorDeCobros {
    double tarifaBase;
    int totalPagar;
    double impuesto;
    LocalDateTime fechaLimite;
    ArrayList<comprobantes> repo;
    comprobantes Comprobantes;

    public gestorDeCobros(double tarifaBase, int totalPagar, double impuesto, LocalDateTime fechaLimite) {
        this.tarifaBase = tarifaBase;
        this.totalPagar = totalPagar;
        this.impuesto = impuesto;
        this.fechaLimite = fechaLimite;
    }
    
    public gestorDeCobros() {
        this.tarifaBase = 0;
        this.totalPagar = 0;
        this.impuesto = 0;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public LocalDateTime getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDateTime fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public comprobantes getComprobantes() {
        return Comprobantes;
    }

    public void setComprobantes(comprobantes Comprobantes) {
        this.Comprobantes = Comprobantes;
    }
    
    
    /**
     * Calcula la tarifa por minuto por vehiculo (EN ESTA CLASE HAY COSAS SIN USAR, hay que ver si se borran o se usan en algo)
     */
    public double calcularTarifaPorMinuto(vehiculos vehiculo) {
        return (tarifaBase + (tarifaBase*impuesto)) * vehiculo.getTipo().getFactorTarifa();
    }
    
    
    public ArrayList<comprobantes> obtenerPagos(LocalDate fecha, int idCliente, repositorioPagos repositorio) {
        repo = repositorio.buscarPagos(fecha, idCliente);
        return repo;
    }
}
