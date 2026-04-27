/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author kenni
 */
public class repositorioPagos {
    ArrayList<comprobantes> comprobantesUsuario = new ArrayList<>();

    public repositorioPagos() {
    }

    public ArrayList<comprobantes> getComprobantesUsuario() {
        return comprobantesUsuario;
    }

    public void setComprobantesUsuario(comprobantes comprobante) {
        this.comprobantesUsuario.add(comprobante);
    }
    
    
    public ArrayList<comprobantes> buscarPagos(LocalDate fecha, int idCliente) {
        ArrayList<comprobantes> lista = new ArrayList<>();
        for (comprobantes comprobante : this.comprobantesUsuario){
            // System.out.println("Hola " + comprobante.getUsuario() + " " + idCliente);
            // System.out.println("Hola " + comprobante.getFechaEmision() + " " + fecha);
            if(fecha.equals(comprobante.getFechaEmision()) && idCliente == comprobante.getUsuario()) {
                lista.add(comprobante);
                
            }
        }
        
        return lista;
    }
    
}
