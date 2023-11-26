/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.impactoecologico;

/**
 *
 * @author damian
 */
class bicicleta implements interfazImpactoEcologico  {
    private String marca;
    private String modelo;
    private String tipoBicicleta;

    public bicicleta(String marca, String modelo, String tipoBicicleta) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoBicicleta = tipoBicicleta;
    }   

        
    @Override
    public double obtenerImpactoEcologico() {
        // Fórmula simplificada del cálculo de la huella de carbono para bicicletas (considerando calorías quemadas)
        double caloriasQuemadas = 500; // Cantidad de calorías quemadas durante el uso (ejemplo)
        double factorEmision = 0.01; // Factor de emisión de ejemplo (debería ajustarse según el tipo de alimento consumido)
        return caloriasQuemadas * factorEmision;
    }

    @Override
    public String toString() {
        return "Bicicleta: " + marca + " " + modelo;
    }

     
}