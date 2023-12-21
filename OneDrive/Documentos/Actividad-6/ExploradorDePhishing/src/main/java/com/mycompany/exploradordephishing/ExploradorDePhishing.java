/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exploradordephishing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Damian Bg
 */
public class ExploradorDePhishing {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Paso 1: Crear la lista de palabras clave y asignar puntos
        Map<String, Integer> palabrasClave = new HashMap<>();
        palabrasClave.put("validar", 1);
        palabrasClave.put("dinero", 3);
        palabrasClave.put("factura", 1);
        palabrasClave.put("Datos", 3);
        palabrasClave.put("correo de verificación", 1);
        palabrasClave.put("expiracion de contraseña",1);
        palabrasClave.put("renovacion de datos", 3);
        palabrasClave.put("inicio de sesión", 3);
        palabrasClave.put("clave", 2);
        palabrasClave.put("gestion de politicas",2);
        palabrasClave.put("Clic aqui",3);
        palabrasClave.put("se requiere verificacion",3);
        palabrasClave.put("Archivo",3);
        palabrasClave.put("enlace de validacion", 3);
        palabrasClave.put("Paypal", 3);
        palabrasClave.put("enlace de validacion durara", 3);
        palabrasClave.put("Advertencia", 2);      
        palabrasClave.put("bloqueo de cuenta", 2);        
        palabrasClave.put("por motivos de seguridad", 1);
        palabrasClave.put("mejoras en las medidas de seguridad", 1);
        palabrasClave.put("obligatorio", 3);      
        palabrasClave.put("clientes", 3);
        palabrasClave.put("mensaje generado automaticamente", 3);       
        palabrasClave.put("reclama tu premio aqui", 3);       
        palabrasClave.put("urgente", 3);      
        palabrasClave.put("importante", 2);       
        palabrasClave.put("haga clic aqui para desbloquear su cuenta", 3);      
        palabrasClave.put("haga clic aqui para instalar la última Version de ", 3);        
        palabrasClave.put("no te pierdas esta oferta unica en la vida", 3);        
        palabrasClave.put("haga clic en el enlace", 3);
        
// Paso 2: Leer el archivo de texto
        String rutaArchivo = "Correos-Phishing.txt";  //ruta del archivo
        int totalPuntos = 0;  
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            // Leer y mostrar cada línea del archivo
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            // Manejar errores de lectura de archivo

        System.out.println("========================================================================");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea ;
            
             
                // Paso 3: Buscar ocurrencias de palabras clave en cada línea
                while ((linea = br.readLine()) != null) {
                for (Map.Entry<String, Integer> entry : palabrasClave.entrySet()) {
                    String palabraClave = entry.getKey().toLowerCase();
                    int puntos = entry.getValue();
                    int ocurrencias = contarOcurrencias(linea.toLowerCase(), palabraClave);

                    // Paso 4: Agregar puntos y mostrar información
                    if (ocurrencias > 0) {
                        totalPuntos += ocurrencias * puntos;
                        System.out.println(palabraClave + ": " + ocurrencias + " ocurrencias - Puntos: " + ocurrencias * puntos);
                    }
                }
            }

        }   
    }
    }

    private static int contarOcurrencias(String toLowerCase, String palabraClave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}