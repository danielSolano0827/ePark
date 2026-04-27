/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class gestorParqueo {
    private ArrayList<sesiones> sesionesActivas;
    private app aplicacion;
    private gestorDeCobros gestorCobros;

    public gestorParqueo(app aplicacion, gestorDeCobros gestorCobros) {
        this.aplicacion = aplicacion;
        this.gestorCobros = gestorCobros;
        this.sesionesActivas = new ArrayList<>();
        //this.app = app;
    }

    /**
     * Llamado por el Sensor cuando detecta un vehículo y crea una sesion, ademas usa aplicacion.notificarInicio
     * para mostrar los datos de la sesion
     */
    public void ocupacionDetectada(int zona, LocalDateTime horaInicio, vehiculos vehiculo) {
        double tarifaPorMinuto = gestorCobros.calcularTarifaPorMinuto(vehiculo);
        sesiones nuevaSesion = new sesiones(tarifaPorMinuto, zona, horaInicio, vehiculo);
        sesionesActivas.add(nuevaSesion);
        aplicacion.notificarInicio(nuevaSesion);
    }

    //Se utiliza para cuando vaya a salir un auto (Aun no se llama en ningun lado)
    public void liberarEspacio(int zona, vehiculos vehiculo) {
    sesiones sesion = buscarSesion(zona, vehiculo);
        if (sesion != null) {
            vehiculo.setEstado(false);
            aplicacion.notificarFin(sesion, LocalDateTime.now()); // muestra el total cobrado
            sesionesActivas.remove(sesion);
        }
    }

    /**
     * Busca una sesion segun la zona y vehiculo que tenga
     */
    private sesiones buscarSesion(int zona, vehiculos vehiculo) {
        for (sesiones s : sesionesActivas) {
            if (s.getZona() == zona && s.getVehiculo().equals(vehiculo)) {
                return s;
            } else {
            }
        }
        return null;
    }

    public ArrayList<sesiones> getSesionesActivas() {
        return sesionesActivas;
    }
}
