/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.impactoecologico;

/**
 *
 * @author ASUS
 */
public interface interfazImpactoEcologico {   
  double obtenerImpactoEcologico();
    // Método concreto con la fórmula general
    default double calcularHuellaCarbono(double datoActividad, double factorEmision) {
        return datoActividad * factorEmision;
    }
}  
