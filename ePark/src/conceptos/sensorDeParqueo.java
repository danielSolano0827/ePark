/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kenni
 */
public class sensorDeParqueo {
    int codigoSensor;
    int zonaParqueo;
    vehiculos vehiculo;
    LocalDateTime horaLlegada;
    boolean estado;
    // Metodos

    
    public sensorDeParqueo(int codigoSensor, int zonaParqueo, vehiculos vehiculo, boolean estado, LocalDateTime horaLlegada) {
        this.codigoSensor = codigoSensor;
        this.zonaParqueo = zonaParqueo;
        this.vehiculo = vehiculo;
        this.estado = estado;
        this.horaLlegada = horaLlegada;
    }
    
    public sensorDeParqueo() {
        this.codigoSensor = 0;
        this.zonaParqueo = 0;
        this.vehiculo = null;
        this.estado = true;
    }
    
    public int getCodigoSensor() {
        return codigoSensor;
    }

    public void setCodigoSensor(int codigoSensor) {
        this.codigoSensor = codigoSensor;
    }

    public vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getZonaParqueo() {
        return zonaParqueo;
    }

    public void setZonaParqueo(int zonaParqueo) {
        this.zonaParqueo = zonaParqueo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    /**
     * Guarda la informacion del vehiculo que se estaciono dentro del sensor y llama a
     * getorDelParqueo.ocupacionDetectada para registrar una sesion (Estas son las que calculan la tarifa total)
     */
    public void detectar(gestorParqueo gestorDelParqueo, usuarios usuarioPrueba){
        if (this.isEstado() == false){
            // Verificar que el usuario tenga vehículos registrados
            if (usuarioPrueba.getVehiculosUsuario().isEmpty()) {
                System.out.println("El usuario no tiene vehículos registrados.");
                return;
            }
            
            int contador = 0;
            
            ArrayList<vehiculos> vehiculos = usuarioPrueba.getVehiculosUsuario();
            for (int i = 0; i < vehiculos.size(); i++) {
                if (vehiculos.get(i).isEstado() == false){
                    contador++;
                }
            }

            if (contador == 0){
                System.out.println("No hay vehiculos por parquear.\n");
                return;
            }
                
            // Mostrar los vehículos del usuario
            System.out.println("Seleccione el vehiculo a estacionar:");
            for (int i = 0; i < vehiculos.size(); i++) {
                if (vehiculos.get(i).isEstado() == false){
                    System.out.println(i + ". " + vehiculos.get(i).getPlaca() 
                                     + " - " + vehiculos.get(i).getModelo()
                                     + " - " + vehiculos.get(i).getColor()
                                     + " - " + vehiculos.get(i).getTipo().getDescripcion());
                }
            }

            // Leer selección
            Scanner scanner = new Scanner(System.in);
            int seleccion = scanner.nextInt();

            if (seleccion < 0 || seleccion >= vehiculos.size()) {
                System.out.println("Seleccion invalida.");
                return;
            }

            // Estacionar el vehículo seleccionado
            vehiculos vehiculoAParquear = vehiculos.get(seleccion);
            this.setEstado(true);
            this.setVehiculo(vehiculoAParquear);
            this.setHoraLlegada(LocalDateTime.now());
            vehiculoAParquear.setEstado(true);
            System.out.println("Vehiculo " + vehiculoAParquear.getPlaca() 
                             + " parqueado en la zona: " + this.getZonaParqueo());
            
            gestorDelParqueo.ocupacionDetectada(zonaParqueo, horaLlegada, vehiculo);
        }
        else{
            System.out.println("Este espacio se encuentra ocupado por: " + vehiculo.getPlaca());
        }
    }
    
    public void detectarSalida(gestorParqueo gestorDelParqueo){
        gestorDelParqueo.liberarEspacio(zonaParqueo, vehiculo);
        this.setEstado(false);
        this.setVehiculo(null);
        this.setHoraLlegada(null);
    }
}