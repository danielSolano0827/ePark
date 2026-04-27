/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enum;

/**
 *
 * @author Daniel
 */

//Enum de tipos de vehiculos con descripcion y factor tarifa
public enum tipoVehiculo {
    AUTOMOVIL("Automovil", 1.0),
    MOTOCICLETA("Motocicleta", 0.5),
    CAMIONETA("Camioneta", 1.5),
    BUS("Bus", 2.0),
    CAMION("Camion", 2.5);

    private final String descripcion;
    private final double factorTarifa;

    tipoVehiculo(String descripcion, double factorTarifa) {
        this.descripcion = descripcion;
        this.factorTarifa = factorTarifa;
    }

    public String getDescripcion() { return descripcion; }
    public double getFactorTarifa() { return factorTarifa; }
}
