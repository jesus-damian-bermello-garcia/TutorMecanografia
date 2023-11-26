/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.impactoecologico;

/**
 *
 * @author damian
 */
class auto implements interfazImpactoEcologico {
    private String marca;
    private String modelo;
    private int año;
    private String tipoCombustible;
    private double cantidadCombustible; // en litros

    public auto(String marca, String modelo, int año, String tipoCombustible, double cantidadCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.tipoCombustible = tipoCombustible;
        this.cantidadCombustible = cantidadCombustible;
    }

   @Override
    public double obtenerImpactoEcologico() {
        // Fórmula simplificada del cálculo de la huella de carbono
        double factorEmision = 2.3; // Factor de emisión de ejemplo (debería ajustarse según el tipo de combustible)
        return cantidadCombustible * factorEmision;
    }

   @Override
    public String toString() {
        return "Auto: " + marca + " " + modelo;
    }
  
}

