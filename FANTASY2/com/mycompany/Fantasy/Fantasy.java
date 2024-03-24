package com.mycompany.Fantasy;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fantasy {

    static final int PRESUPUESTO_MAX=200;
    static int dineroGastado=0;
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
            System.out.println("3. Ver jugadores fichados");
            System.out.println("4. Fichar  a un jugador");
            System.out.println("5. Vender un jugador");
            System.out.println("6. Guardar");
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
                        verJugadoresFichados();
                        break;
                    case 4:
                        ficharJugador();
                        break;
                    case 5:
                        venderJugador();
                        break;
                    case 6:
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
        } while (opcion != 6);

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

    public static void añadirJugadores (){
        String nombre;
        int Precio;
        Scanner sc = new Scanner(System.in);
        System.out.print("Añade el nombre del jugador que quieres añadir: ");
        nombre = sc.nextLine();
 
        System.out.print("Añade el precio del jugador: ");
        Precio = sc.nextInt();
 
        Jugador players = new Jugador (nombre,Precio);
        jugadores.add(players);
    }

    private static void ficharJugador() {
        String nombre;
        int dineroDisponible=PRESUPUESTO_MAX-dineroGastado;
        verJugadores();
        Scanner sc= new Scanner(System.in);
        System.out.print("Introduce el nombre del jugador a fichar: ");
        nombre=sc.nextLine();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals(nombre)) {
                    if (jugadores.get(i).getPrecio()<=dineroDisponible) {
                        jugadores.get(i).setFichado(true);
                        dineroGastado+=jugadores.get(i).getPrecio();
                    } else {
                        System.out.println("No tienes dinero suficiente para ficharlo");
                    }
            }
        }
        System.out.println("Has fichado al jugador");
    }

    private static void venderJugador() {
        String vendido;
        Scanner sc= new Scanner(System.in);
        for (Jugador players:jugadores){
            if (!players.isFichado()){
            }else{
            verJugadoresFichados();
            System.out.print("Introduce el nombre del jugador que deseas vender: ");
            vendido = sc.nextLine();
            players.setFichado(false);
            System.out.println("El jugador ha sido vendido con exito");
            } 
        }
    }

    private static void verJugadoresFichados() {
        for (Jugador j: jugadores) {
            if (j.isFichado())
                j.imprimir();
        }
    }

    private static void guardar() {
        try (FileOutputStream ff = new FileOutputStream(ficheroJug)) {
            ObjectOutputStream oos = new ObjectOutputStream(ff);
            for (Object ju : jugadores) {
                oos.writeObject(ju);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fantasy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fantasy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}