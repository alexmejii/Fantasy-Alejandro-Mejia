/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fantasy1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mañana
 */
public class FANTASY2 {

    static File ficheroJug= new File("Jugadores.obj");
    static ArrayList<Jugador> jugadores=new ArrayList<>();

    public static void main(String[] args) {

        // Mensaje de bienvenida con el presupuesto inicial
        System.out.println("¡Bienvenido al Fantasy!");

        // Menú del programa
        Scanner scanner = new Scanner(System.in);
        int opcion;

        if (!ficheroJug.exists()) {
            Instalacion.añadirJugadoresArrayInicial();
            Instalacion.guardarJugadores();
        }
        leerArchivos();

        do {
            // Imprimir el menú
            System.out.println("=====================================");
            System.out.println("1. Ver lista de jugadores completa");
            System.out.println("2. Añadir jugador");
            System.out.println("3. Guardar");
            System.out.print("Ingrese el número de la opción deseada: ");

            try {
                // Obtener la opción del usuario
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el carácter de nueva línea restante en el búfer

                switch (opcion) {
                    case 1:
                        // Ver jugadores disponibles
                        verJugadores();
                        break;
                    case 2:
                        añadirJugadores();
                        break;
                    case 3:
                        guardar();
                        System.out.println("¡Gracias por jugar!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido.");
                opcion = 0; // Reiniciar la opción para evitar un bucle infinito
                scanner.nextLine(); // Consumir entrada incorrecta
            }
        } while (opcion != 3);

        // Cierra el scanner al finalizar el programa
        scanner.close();
    }

    private static void leerArchivos() {
        Jugador ju;
        if (ficheroJug != null) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroJug));
                ju = (Jugador) ois.readObject();
                jugadores.add(ju);
                while (ju != null) {
                    ju = (Jugador) ois.readObject();
                    jugadores.add(ju);
                }
                ois.close();
            } catch (EOFException e1) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    // Función para imprimir la lista de jugadores disponibles
    public static void verJugadores() {
        for (Jugador j: jugadores) {
            j.imprimir();
        }
    }

    private static void añadirJugadores() {
        String nombre;
        int precio;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce nombre: ");
        nombre=sc.nextLine();
        System.out.print("Introduce el precio: ");
        precio=sc.nextInt();
        sc.nextLine();
        Jugador j=new Jugador(nombre,precio);
        jugadores.add(j);
    }

    private static void guardar() {
        try (FileOutputStream ff = new FileOutputStream(ficheroJug)) {
            ObjectOutputStream oos = new ObjectOutputStream(ff);
            for (Object ju : jugadores) {
                oos.writeObject(ju);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FANTASY2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FANTASY2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
