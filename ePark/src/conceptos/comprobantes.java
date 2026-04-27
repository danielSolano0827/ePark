/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.time.LocalDate;

/**
 *
 * @author kenni
 */
public class comprobantes {
    String codigoComprobante;
    String tipoDePago; 
    int usuario; 
    LocalDate fechaEmision;
    LocalDate fechaDeUso; // Fecha en la cual fue usado el parquimetro
    double montoEmitido;
    boolean impuesto;
    

    public comprobantes(String codigoComprobante, String tipoDePago, int usuario, LocalDate fechaEmision, LocalDate fechaDeUso, double montoEmitido, boolean impuesto) {
        this.codigoComprobante = codigoComprobante;
        this.tipoDePago = tipoDePago;
        this.usuario = usuario;
        this.fechaEmision = fechaEmision;
        this.fechaDeUso = fechaDeUso;
        this.montoEmitido = montoEmitido;
        this.impuesto = impuesto;
    }
    
    public comprobantes() {
        this.codigoComprobante = "";
        this.fechaEmision = null;
        this.usuario = 0;
        this.fechaDeUso = null;
        this.montoEmitido = 0;
        this.impuesto = false;
    }

    public String getCodigoComprobante() {
        return codigoComprobante;
    }

    public void setCodigoComprobante(String codigoComprobante) {
        this.codigoComprobante = codigoComprobante;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaDeUso() {
        return fechaDeUso;
    }

    public void setFechaDeUso(LocalDate fechaDeUso) {
        this.fechaDeUso = fechaDeUso;
    }

    public double getMontoEmitido() {
        return montoEmitido;
    }

    public void setMontoEmitido(double montoEmitido) {
        this.montoEmitido = montoEmitido;
    }

    public boolean isImpuesto() {
        return impuesto;
    }

    public void setImpuesto(boolean impuesto) {
        this.impuesto = impuesto;
    }
    
}
