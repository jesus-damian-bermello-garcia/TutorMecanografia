/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea1;



import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author damian_bermello
 */
public class Tarea1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        
            String[] respuestapositiva = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
            String[] respuestanegativa = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "¡No te rindas!", "No. Sigue intentando."};
            
                System.out.println("Bienvenido al Programa de Instrucción Asistida por Computadora (CAI) de Matemáticas.");
                System.out.println("Elige el nivel de dificultad: 1 (números de un dígito), 2 (números de dos dígitos):");
                
            
                System.out.println("Elige el tipo de problema aritmético a estudiar:");
                System.out.println("1 - Suma");
                System.out.println("2 - Resta");
                System.out.println("3 - Multiplicación");
                System.out.println("4 - División");
                System.out.println("5 - Mezcla aleatoria");
               
    }    
}       

    


   