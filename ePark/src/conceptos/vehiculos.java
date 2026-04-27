/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import Enum.tipoVehiculo;

/**
 *
 * @author kenni
 */
public class vehiculos {
    private String placa;
    private String modelo;
    private String color;
    private tipoVehiculo tipo;
    boolean estado;

    public vehiculos(String placa, String modelo, String color, boolean estado, tipoVehiculo tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.estado = estado;
        this.tipo = tipo;
    }
    
    public vehiculos() {
        this.placa = "";
        this.modelo = "";
        this.color = "";
        this.estado = false;
        this.tipo = null;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public tipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(tipoVehiculo tipo) {
        this.tipo = tipo;
    }
}
