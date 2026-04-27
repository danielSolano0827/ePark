/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class parqueos {
    private String nombre;
    private String localidad;
    private sensorDeParqueo[] sensores;
 
    public parqueos(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.sensores = new sensorDeParqueo[0];
    }
 
    // Getters
    public String getNombre() { return nombre; }
    public String getLocalidad() { return localidad; }
    public sensorDeParqueo[] getSensores() { return sensores; }
 
    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }
    public void setSensores(sensorDeParqueo[] sensores) { this.sensores = sensores; }
 
    /**
     * Crea n sensores y los guarda en el arreglo.
     * codigoSensor va de 1 a n, zonaParqueo igual.
     * placa = 0, horaLlegada = null, estado = false por defecto (definido en el constructor de Sensor).
     */
    public void crearParqueo(int n) {
        sensores = new sensorDeParqueo[n];
        for (int i = 0; i < n; i++) {
            sensores[i] = new sensorDeParqueo(i+1,i+1,null,false,null);
        }
    }
 
    /**
     * Muestra en consola el estado actual de todos los sensores.
     */
    public void mostrarEstado() {
        System.out.println("\n--- Estado del parqueo: " + nombre + " (" + localidad + ") ---");
        if (sensores == null || sensores.length == 0) {
            System.out.println("No hay sensores configurados.");
            return;
        }
        for (sensorDeParqueo s : sensores) {
            String estado = s.isEstado() ? s.getVehiculo().getPlaca() : "Libre";
            System.out.println("Zona " + s.getZonaParqueo() + " -> " + estado);
        }
    }
    
    /**
     * Muestra un menu con las opciones:
     * 1. Parquear un auto
     * - Pregunta por un espacio del parqueo
     * - Llama a la funcion sensor.detectar para que el sensor registre a el vehiculo
     * 2. Ver el parqueo
     * - Llama a mostrarEstado()
     * 3. Salir
     */
    public static void parquear(gestorParqueo gestorDelParqueo, parqueos parqueoTec, usuarios usuarioPrueba) {
        
    Scanner input = new Scanner(System.in);

    boolean activo = true;

    while (activo) {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Parquear");
        System.out.println("2 - Retirar un vehiculo");
        System.out.println("3 - Ver parqueo");
        System.out.println("4 - Salir");
        System.out.print("Opcion: ");
        int opcion = input.nextInt();

        switch (opcion) {

            case 1:
                System.out.println("Buenos dias " + usuarioPrueba.getNombre() + ".\n");
                System.out.print("En que espacio desea parquear? (1 - " + parqueoTec.getSensores().length + "): ");
                int espacio = input.nextInt();

                if (espacio < 1 || espacio > parqueoTec.getSensores().length) {
                    System.out.println("Espacio invalido.");
                    break;
                }

                sensorDeParqueo sensor = parqueoTec.getSensores()[espacio - 1];
                sensor.detectar(gestorDelParqueo, usuarioPrueba);
                break;
                
            case 2:
                int contador = 0;
                sensorDeParqueo sensorRetirar = null;
                
                ArrayList<vehiculos> vehiculos = usuarioPrueba.getVehiculosUsuario();
                for (int i = 0; i < vehiculos.size(); i++) {
                    if (vehiculos.get(i).isEstado() == true){
                        contador++;
                    }
                }
                
                if (contador == 0){
                    System.out.println("No hay vehiculos por retirar.\n");
                    break;
                }
                
                // Mostrar los vehículos del usuario por retirar
                System.out.println("Seleccione el vehiculo a estacionar: ");
                for (int i = 0; i < vehiculos.size(); i++) {
                    if (vehiculos.get(i).isEstado() == true){
                        contador++;
                        System.out.println(i + ". " + vehiculos.get(i).getPlaca() 
                                         + " - " + vehiculos.get(i).getModelo()
                                         + " - " + vehiculos.get(i).getColor()
                                         + " - " + vehiculos.get(i).getTipo().getDescripcion());
                    }
                }
                
                int seleccion = input.nextInt();
                //Proceso logico para validar opciones
                if (seleccion < 0 || seleccion >= vehiculos.size()) {
                    System.out.println("Seleccion invalida.");
                    break;
                }

                vehiculos vehiculoARetirar = vehiculos.get(seleccion);
                
                sensorDeParqueo[] sensores2 = parqueoTec.getSensores();
                for (sensorDeParqueo s : sensores2){
                    if (s.getVehiculo()!= null && s.getVehiculo().getPlaca().equals(vehiculoARetirar.getPlaca())){
                        sensorRetirar = s;
                    }
                }
                
                if (sensorRetirar != null) {
                    sensorRetirar.detectarSalida(gestorDelParqueo);
                } else {
                    System.out.println("No se encontró el vehículo en ningún sensor.");
                }
                break;


            case 3:
                parqueoTec.mostrarEstado();
                break;

            case 4:
                System.out.println("Saliendo...");
                activo = false;
                break;

            default:
                System.out.println("Opcion no valida.");
        }
    }

    input.close();
    }
}
