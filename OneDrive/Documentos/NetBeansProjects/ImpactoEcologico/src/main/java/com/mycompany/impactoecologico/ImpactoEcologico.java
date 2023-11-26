/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.impactoecologico;

import java.util.ArrayList;




/**
 *
 * @author damian
 */
public class ImpactoEcologico {
    public static void main(String[] args) {
     
        ArrayList<interfazImpactoEcologico> objetos =new ArrayList <>();
        edificio edificio = new edificio("Edificio A", 200, 10,  2010);
        objetos.add((interfazImpactoEcologico) edificio);
        auto auto = new auto("Toyota", "Corolla", 2022, "Gasolina", 50);
        objetos.add((interfazImpactoEcologico)auto);
        bicicleta bicicleta = new bicicleta("Trek", "MountainBike", "De montaña");
        objetos.add((interfazImpactoEcologico) bicicleta);
            // Iterar a través de la lista e imprimir el impacto ecológico
        for (interfazImpactoEcologico objeto : objetos) {
            System.out.println(objeto + "  Impacto ecológico: " + objeto.obtenerImpactoEcologico() + " gCO2");
        }
    }

}
   