/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.util.ArrayList;

/**
 *
 * @author kenni
 */
public class usuarios {
    int identificacion;
    String nombre;
    String apellido1;
    String apellido2;
    String correo;
    String telefono;
    ArrayList<vehiculos> vehiculosUsuario = new ArrayList<>();

    public usuarios(int identificacion, String nombre, String apellido1, String apellido2, String correo, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public usuarios() {
        this.identificacion = 0;
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.correo = "";
        this.telefono = "";
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setVehiculos(vehiculos vehiculo){
        this.vehiculosUsuario.add(vehiculo);
    }

    public ArrayList<vehiculos> getVehiculosUsuario() {
        return vehiculosUsuario;
    }
}
