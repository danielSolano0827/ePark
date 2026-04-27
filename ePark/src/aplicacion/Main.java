/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacion;

/**
 *
 * Tarea #5
 * Hecho por : Kenni Gonzalez Blandon
 * Carne     : 2024201088
 * Hecho por : Daniel Solano Cordero
 * Carne     : 2025069629
 * Hecho por : Mathias Viquez Leiva
 * Carne     : 2025088534
 * 
 */

import Enum.tipoVehiculo;
import conceptos.GestorNotificaciones;
import conceptos.GestorTiempo;
import conceptos.app;
import conceptos.comprobantes;
import conceptos.gestorDeCobros;
import conceptos.gestorParqueo;
import conceptos.parqueos;
import conceptos.repositorioPagos;
import conceptos.sensorDeParqueo;
import conceptos.sesiones;
import conceptos.usuarios;
import conceptos.vehiculos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //estacionarAuto();
        //visualizarPagos();
        notificarProximoVencimiento();
    }
    
    public static void estacionarAuto(){
        
        usuarios usuarioPrueba;
        vehiculos vehiculo1;
        vehiculos vehiculo2;
        vehiculos vehiculo3;
        parqueos parqueoTec;
        gestorParqueo gestorDelParqueo;
        gestorDeCobros gestorCobros;
        app aplicacion;
        
        //Se crea el usuario
        usuarioPrueba = new usuarios(303450125, "Enrique", "Castillo", "Hernandez", "prueba@gmail.com", "42356475");
        //Se crean los vehiculos
        vehiculo1 = new vehiculos("ABC123", "Toyota Corolla", "Rojo", false, tipoVehiculo.AUTOMOVIL);
        vehiculo2 = new vehiculos("MTO456", "Honda CBR", "Negro", false, tipoVehiculo.MOTOCICLETA);
        vehiculo3 = new vehiculos("CAM789", "Ford F-150", "Blanco", false, tipoVehiculo.CAMIONETA);
        //Se inserta los vehiculos al usuarios
        usuarioPrueba.setVehiculos(vehiculo1);
        usuarioPrueba.setVehiculos(vehiculo2);
        usuarioPrueba.setVehiculos(vehiculo3);
        //Se crea el parqueo con los sensores
        parqueoTec = new parqueos("Instituto Tecnologico de Costa Rica", "Cartago");
        parqueoTec.crearParqueo(40);
        //Se crea el gestorDelParqueo(gestiona sesiones) y de cobro
        gestorCobros = new gestorDeCobros(16.66, 0, 0.10, null);
        aplicacion = new app(1);
        gestorDelParqueo = new gestorParqueo(aplicacion, gestorCobros);
        //Prints de informacion
        System.out.println("Se crea un usuario simulado llamado " + usuarioPrueba.getNombre());
        System.out.println("Se crean 3 vehiculos y se asignan al usuarioPrueba");
        System.out.println("Se crea un parque simulado con " + parqueoTec.getSensores().length + " espacios.");
        
        parqueoTec.parquear(gestorDelParqueo, parqueoTec, usuarioPrueba);
    }
    
    
    // HU2
    public static void notificarProximoVencimiento(){

        app aplicacion = new app(1);
        GestorNotificaciones notificador = new GestorNotificaciones(aplicacion);

        // Crear vehículo 
        vehiculos vehiculo = new vehiculos("ABC123", "Toyota", "Rojo", false, tipoVehiculo.AUTOMOVIL);

        LocalDateTime horaInicio = LocalDateTime.now().minusDays(3).plusMinutes(4);

        sesiones sesion1 = new sesiones(
                10.0, // tarifa
                5,    // zona
                horaInicio,
                vehiculo
        );

        ArrayList<sesiones> listaSesiones = new ArrayList<>();
        listaSesiones.add(sesion1);

        GestorTiempo gestorTiempo = new GestorTiempo();
        gestorTiempo.setSesionesActivas(listaSesiones);
        gestorTiempo.setNotificador(notificador);

        System.out.println("Simulando sesión próxima a vencer...");
        gestorTiempo.verificarSesiones();
    }
    
    // HU3
    public static ArrayList<comprobantes> visualizarPagos(){
        
        usuarios usuarioPrueba1;
        usuarios usuarioPrueba2;
        comprobantes comprobante1;
        comprobantes comprobante2;
        comprobantes comprobante3;
        comprobantes comprobante4;
        comprobantes comprobante5;
        comprobantes comprobante6;
        comprobantes comprobante7;
        vehiculos vehiculo1;
        vehiculos vehiculo2;
        vehiculos vehiculo3;
        vehiculos vehiculo4;
        app aplicacion;
        
        repositorioPagos repositorio = new repositorioPagos();
        
        usuarioPrueba1 = new usuarios(303450125, "Enrique", "Castillo", "Hernandez", "prueba@gmail.com", "42356475");
        usuarioPrueba2 = new usuarios(702160419, "Juan", "Mora", "Porras", "juanM@gmail.com", "78234673");
        
        // vehiculo1 = new vehiculos("ABC123", "Toyota Corolla", "Rojo", false, tipoVehiculo.AUTOMOVIL);
        // vehiculo2 = new vehiculos("MTO456", "Honda CBR", "Negro", false, tipoVehiculo.MOTOCICLETA);
        // vehiculo3 = new vehiculos("CAM789", "Ford F-150", "Blanco", false, tipoVehiculo.CAMIONETA);
        // vehiculo3 = new vehiculos("VSE136", "BMW Serie-Y", "Azul", false, tipoVehiculo.AUTOMOVIL);
        
        comprobante1 = new comprobantes("ABC009832", "TARJETA", usuarioPrueba1.getIdentificacion(), LocalDate.parse("2026-03-12"), LocalDate.parse("2026-03-11"), 30.34, false);
        comprobante2 = new comprobantes("MTO123365", "EFECTIVO", usuarioPrueba2.getIdentificacion(),LocalDate.parse("2026-02-26"), LocalDate.parse("2026-02-26"), 32.00, false);
        comprobante3 = new comprobantes("CAM378842", "TARJETA", usuarioPrueba1.getIdentificacion(), LocalDate.parse("2026-04-09"), LocalDate.parse("2026-04-08"), 29.09, false);
        comprobante4 = new comprobantes("VSE567432", "TARJETA", usuarioPrueba2.getIdentificacion(),LocalDate.parse("2026-04-21"), LocalDate.parse("2026-04-20"), 31.54, false);
        comprobante5 = new comprobantes("VSE112908", "TARJETA", usuarioPrueba2.getIdentificacion(),LocalDate.parse("2026-04-21"), LocalDate.parse("2026-04-21"), 27.23, false);
        comprobante6 = new comprobantes("CAM378842", "TARJETA", usuarioPrueba1.getIdentificacion(), LocalDate.parse("2026-04-09"), LocalDate.parse("2026-04-09"), 33.56, false);
        comprobante7 = new comprobantes("CAM560105", "TARJETA", usuarioPrueba1.getIdentificacion(), LocalDate.parse("2026-04-09"), LocalDate.parse("2026-04-07"), 28.45, false);
        
        repositorio.setComprobantesUsuario(comprobante1); repositorio.setComprobantesUsuario(comprobante2);
        repositorio.setComprobantesUsuario(comprobante3); repositorio.setComprobantesUsuario(comprobante4);
        repositorio.setComprobantesUsuario(comprobante5); repositorio.setComprobantesUsuario(comprobante6);
        repositorio.setComprobantesUsuario(comprobante7);
        
        System.out.println("Se crean unos usuarios simulados llamados: " + usuarioPrueba1.getNombre() + " y " + usuarioPrueba2.getNombre());
        System.out.println("Se crean unos comprobantes simulados con para los usuarios y autos creados");
        System.out.println("Se crea un repositorio para guardar los comprobantes");
        
        // repositorio.consultar();
        aplicacion = new app(1);
        ArrayList<comprobantes> listaPagos = aplicacion.solicitarPagos(LocalDate.parse("2026-04-21"), usuarioPrueba2.getIdentificacion(), repositorio);
        aplicacion.mostrarPagos(listaPagos);
        return listaPagos;
    } 
}
