/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea1;



import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author damian_bermello
 */
public class Tarea1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom secureRandom = new SecureRandom();
        Random random = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        
        int totalestudiantes;
        totalestudiantes = 0;
        
        do {
            int respuestascorrectas = 0;
            int totalpreguntas = 10;
            int respuestasincorrectas = 0;
            
            String[] respuestapositiva = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
            String[] respuestanegativa = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "¡No te rindas!", "No. Sigue intentando."};
            
            System.out.println("Bienvenido al Programa de Instrucción Asistida por Computadora (CAI) de Matemáticas.");
            System.out.println("Elige el nivel de dificultad: 1 (números de un dígito), 2 (números de dos dígitos):");
            int dificultad = scanner.nextInt();
            
            System.out.println("Elige el tipo de problema aritmético a estudiar:");
            System.out.println("1 - Suma");
            System.out.println("2 - Resta");
            System.out.println("3 - Multiplicación");
            System.out.println("4 - División");
            System.out.println("5 - Mezcla aleatoria");
            int problemType = scanner.nextInt();
            
            while (respuestascorrectas + respuestasincorrectas < totalpreguntas) {
                int num1 = getRandomNumber(dificultad, secureRandom);
                int num2 = getRandomNumber(dificultad, secureRandom);
                double respuestacorrecta = 0;
                
                switch (problemType) {
                    case 1 -> {
                        // Suma
                        respuestacorrecta = num1 + num2;
                        System.out.println("¿Cuánto es " + num1 + " + " + num2 + "?");
                    }
                    case 2 -> {
                        // Resta
                        respuestacorrecta = num1 - num2;
                        System.out.println("¿Cuánto es " + num1 + " - " + num2 + "?");
                    }
                    case 3 -> {
                        // Multiplicación
                        respuestacorrecta = num1 * num2;
                        System.out.println("¿Cuánto es " + num1 + " por " + num2 + "?");
                    }
                    case 4 -> {
                        // División
                        num2 = getRandomNonZeroNumber(dificultad, secureRandom);
                        respuestacorrecta = (double) num1 / num2;
                        System.out.println("¿Cuánto es " + num1 + " dividido por " + num2 + "? (Redondea a dos decimales separados por coma)");
                    }
                    case 5 -> {
                        // Mezcla aleatoria
                        int operation = secureRandom.nextInt(4) + 1;
                    switch (operation) {
                        case 1 -> {
                            respuestacorrecta = num1 + num2;
                            System.out.println("¿Cuánto es " + num1 + " + " + num2 + "?");
                        }
                        case 2 -> {
                            respuestacorrecta = num1 - num2;
                            System.out.println("¿Cuánto es " + num1 + " - " + num2 + "?");
                        }
                        case 3 -> {
                            respuestacorrecta = num1 * num2;
                            System.out.println("¿Cuánto es " + num1 + " por " + num2 + "?");
                         }
                        default -> {
                            num2 = getRandomNonZeroNumber(dificultad, secureRandom);
                            respuestacorrecta = (double) num1 / num2;
                            System.out.println("¿Cuánto es " + num1 + " dividido por " + num2 + "? (Redondea a dos decimales separados por coma)");
                        }
                    }
                    }
                }
                
                double respuestausuario = scanner.nextDouble();
                
                if (Math.abs(respuestausuario - respuestacorrecta) < 0.01) {
                    int feedbackIndex = random.nextInt(respuestapositiva.length);
                    System.out.println(respuestapositiva[feedbackIndex]);
                    respuestascorrectas++;
                } else {
                    while (Math.abs(respuestausuario - respuestacorrecta) >= 0.01) {
                        int respuestaIndex = random.nextInt(respuestanegativa.length);
                        System.out.println(respuestanegativa[respuestaIndex]);
                        respuestausuario = scanner.nextDouble();
                        respuestasincorrectas++;
                    }
                }
            }
            
            double percentajeCorrecto = (double) respuestascorrectas / totalpreguntas * 100;
            System.out.println("Has respondido correctamente al " + decimalFormat.format(percentajeCorrecto) + "% de las preguntas.");
            
           
        } while (true);
    }
    
    private static int getRandomNumber(int dificultad, SecureRandom secureRandom) {
        if (dificultad == 1) {
            return secureRandom.nextInt(10); // Números de un dígito
        } else {
            return secureRandom.nextInt(90) + 10; // Números de dos dígitos
        }
    }
    
    private static int getRandomNonZeroNumber(int dificultad, SecureRandom secureRandom) {
        int num;
        do {
            num = getRandomNumber(dificultad, secureRandom);
        } while (num == 0);
        return num;
    }
}
