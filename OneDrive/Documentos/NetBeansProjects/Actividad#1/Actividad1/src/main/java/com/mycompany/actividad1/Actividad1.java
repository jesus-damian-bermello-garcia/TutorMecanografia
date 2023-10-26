/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad1;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

/**
 *
 * @author damian_bermello
 */
public class Actividad1  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom secureRandom = new SecureRandom();
        Random random = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        
        int totalStudents = 0;
        
        do {
            int correctAnswers = 0;
            int totalQuestions = 10;
            int incorrectAnswers = 0;
            
            String[] positiveFeedback = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
            String[] negativeFeedback = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "¡No te rindas!", "No. Sigue intentando."};
            
            System.out.println("Bienvenido al Programa de Instrucción Asistida por Computadora (CAI) de Matemáticas.");
            System.out.println("Elige el nivel de dificultad: 1 (números de un dígito), 2 (números de dos dígitos):");
            int difficulty = scanner.nextInt();
            
            System.out.println("Elige el tipo de problema aritmético a estudiar:");
            System.out.println("1 - Suma");
            System.out.println("2 - Resta");
            System.out.println("3 - Multiplicación");
            System.out.println("4 - División");
            System.out.println("5 - Mezcla aleatoria");
            int problemType = scanner.nextInt();
            
            while (correctAnswers + incorrectAnswers < totalQuestions) {
                int num1 = getRandomNumber(difficulty, secureRandom);
                int num2 = getRandomNumber(difficulty, secureRandom);
                double correctAnswer = 0;
                
                switch (problemType) {
                    case 1 -> {
                        // Suma
                        correctAnswer = num1 + num2;
                        System.out.println("¿Cuánto es " + num1 + " + " + num2 + "?");
                    }
                    case 2 -> {
                        // Resta
                        correctAnswer = num1 - num2;
                        System.out.println("¿Cuánto es " + num1 + " - " + num2 + "?");
                    }
                    case 3 -> {
                        // Multiplicación
                        correctAnswer = num1 * num2;
                        System.out.println("¿Cuánto es " + num1 + " por " + num2 + "?");
                    }
                    case 4 -> {
                        // División
                        num2 = getRandomNonZeroNumber(difficulty, secureRandom);
                        correctAnswer = (double) num1 / num2;
                        System.out.println("¿Cuánto es " + num1 + " dividido por " + num2 + "? (Redondea a dos decimales)");
                    }
                    case 5 -> {
                        // Mezcla aleatoria
                        int operation = secureRandom.nextInt(4) + 1;
                    switch (operation) {
                        case 1 -> {
                            correctAnswer = num1 + num2;
                            System.out.println("¿Cuánto es " + num1 + " + " + num2 + "?");
                        }
                        case 2 -> {
                            correctAnswer = num1 - num2;
                            System.out.println("¿Cuánto es " + num1 + " - " + num2 + "?");
                        }
                        case 3 -> {
                            correctAnswer = num1 * num2;
                            System.out.println("¿Cuánto es " + num1 + " por " + num2 + "?");
                        }
                        default -> {
                            num2 = getRandomNonZeroNumber(difficulty, secureRandom);
                            correctAnswer = (double) num1 / num2;
                            System.out.println("¿Cuánto es " + num1 + " dividido por " + num2 + "? (Redondea a dos decimales)");
                        }
                    }
                    }
                }
                
                double userAnswer = scanner.nextDouble();
                
                if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                    int feedbackIndex = random.nextInt(positiveFeedback.length);
                    System.out.println(positiveFeedback[feedbackIndex]);
                    correctAnswers++;
                } else {
                    while (Math.abs(userAnswer - correctAnswer) >= 0.01) {
                        int feedbackIndex = random.nextInt(negativeFeedback.length);
                        System.out.println(negativeFeedback[feedbackIndex]);
                        userAnswer = scanner.nextDouble();
                        incorrectAnswers++;
                    }
                }
            }
            
            double percentageCorrect = (double) correctAnswers / totalQuestions * 100;
            System.out.println("Has respondido correctamente al " + decimalFormat.format(percentageCorrect) + "% de las preguntas.");
            
            if (percentageCorrect < 75) {
                System.out.println("Por favor pide ayuda adicional a tu instructor.");
            } else {
                System.out.println("Felicidades, estás listo para pasar al siguiente nivel!");
            }
            
            totalStudents++;
            
            if (totalStudents < 2) {
                System.out.println("¿Deseas permitir que otro estudiante pruebe el programa? (1 para sí, 2 para no):");
                int anotherStudent = scanner.nextInt();
                if (anotherStudent != 1) {
                    break;
                }
            } else {
                break;
            }
        } while (true);
    }
    
    private static int getRandomNumber(int difficulty, SecureRandom secureRandom) {
        if (difficulty == 1) {
            return secureRandom.nextInt(10); // Números de un dígito
        } else {
            return secureRandom.nextInt(90) + 10; // Números de dos dígitos
        }
    }
    
    private static int getRandomNonZeroNumber(int difficulty, SecureRandom secureRandom) {
        int num;
        do {
            num = getRandomNumber(difficulty, secureRandom);
        } while (num == 0);
        return num;
    }
}

