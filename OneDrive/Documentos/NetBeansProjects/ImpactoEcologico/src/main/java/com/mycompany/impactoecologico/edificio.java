/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.impactoecologico;

/**
 *
 * @author damian
 */
class edificio implements interfazImpactoEcologico{
     private String nombre;
    private double energiaIluminacion; // en kilovatios por hora
    private int numVentanas;
    private int fechaConstruccion;

    public edificio(String nombre, double energiaIluminacion, int numVentanas, int fechaConstruccion) {
        this.nombre = nombre;
        this.energiaIluminacion = energiaIluminacion;
        this.numVentanas = numVentanas;
        this.fechaConstruccion = fechaConstruccion;
    }

    
    @Override
    public double obtenerImpactoEcologico() {
        // Fórmula simplificada del cálculo de la huella de carbono
        double factorEmision = 0.5; // Factor de emisión de ejemplo (debería ajustarse según la fuente de energía utilizada)
        return energiaIluminacion * factorEmision;
    }

     @Override
    public String toString() {
        return "Edificio: " + nombre;
    }
  
}