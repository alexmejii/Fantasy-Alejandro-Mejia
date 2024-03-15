/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fantasy1;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author Mañana
 */
public class FANTASY1 {

    // Declaración de ArrayLists para almacenar datos de jugadores y equipos
    static ArrayList<Integer> precios;
    static ArrayList<String> nombres;
    static ArrayList<String> posiciones;
    static ArrayList<Double> preciosf;
    static ArrayList<String> nombresf;
    static ArrayList<String> posicionesf;
    static ArrayList<String> jugadoresDisponibles;

    public static void main(String[] args) {
        ArrayList<String> jugadoresFichados = new ArrayList<>();
        int[] presupuesto = {200000000};

        // Inicialización de los ArrayLists
        precios = new ArrayList<>();
        nombres = new ArrayList<>();
        posiciones = new ArrayList<>();
        preciosf = new ArrayList<>();
        nombresf = new ArrayList<>();
        posicionesf = new ArrayList<>();
        jugadoresDisponibles = new ArrayList<>();

        // Rellena los datos de los jugadores
        llenaFichajes(posiciones, nombres, precios);
        jugadoresDisponibles.addAll(nombres);

        // Mensaje de bienvenida con el presupuesto inicial
        System.out.println("¡Bienvenido al Fantasy!");
        System.out.println("Presupuesto inicial: " + formatearPrecio(presupuesto[0]));

        // Menú del programa
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            // Imprimir el menú
            System.out.println("=====================================");
            System.out.println("1. Ver lista de jugadores completa");
            System.out.println("2. Ver lista de jugadores por posición");
            System.out.println("3. Fichar a un jugador");
            System.out.println("4. Devolver un jugador");
            System.out.println("5. Ver mis jugadores fichados");
            System.out.println("6. Salir");
            System.out.print("Ingrese el número de la opción deseada: ");

            try {
                // Obtener la opción del usuario
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el carácter de nueva línea restante en el búfer

                switch (opcion) {
                    case 1:
                        // Ver jugadores disponibles
                        verJugadores(posiciones, nombres, precios, presupuesto[0]);
                        break;
                    case 2:
                        // Ver jugadores por su posición
                        verPosiciones(scanner, posiciones, nombres, precios);
                        break;
                    case 3:
                        // Fichar a un jugador
                        ficharJugador(scanner, posiciones, nombres, precios, presupuesto, jugadoresFichados);
                        break;
                    case 4:
                        // Devolver un jugador
                        devolverJugador(scanner, posiciones, nombres, precios, presupuesto, jugadoresFichados);
                        break;
                    case 5:
                        // Ver mis jugadores fichados
                        verFichados(jugadoresFichados, jugadoresFichados, preciosf);
                        break;
                    case 6:
                        // Salir
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

    public static void llenaFichajes (ArrayList <String> posiciones, ArrayList <String> jugadores, ArrayList <Integer> precios) {
        jugadores.add("Stephen Curry");
        posiciones.add("Base");
        precios.add(50000000);

        jugadores.add("Devin Booker");
        posiciones.add("Base");
        precios.add(30000000);

        jugadores.add("Shai Gilgeous-Alexander");
        posiciones.add("Base");
        precios.add(20000000);

        jugadores.add("D'Aaron-Fox");
        posiciones.add("Base");
        precios.add(10000000);

        jugadores.add("Jalen Brunson");
        posiciones.add("Escolta");
        precios.add(50000000);

        jugadores.add("Klay Thompson");
        posiciones.add("Escolta");
        precios.add(30000000);

        jugadores.add("Austin Reaves");
        posiciones.add("Escolta");
        precios.add(20000000);

        jugadores.add("Kentavious Caldwell-Pope");
        posiciones.add("Escolta");
        precios.add(10000000);

        jugadores.add("Jayson Tatum");
        posiciones.add("Alero");
        precios.add(50000000);

        jugadores.add("Kawhi Leonard");
        posiciones.add("Alero");
        precios.add(30000000);

        jugadores.add("Khris Middleton");
        posiciones.add("Alero");
        precios.add(20000000);

        jugadores.add("OG Anunoby");
        posiciones.add("Alero");
        precios.add(10000000);

        jugadores.add("Giannis Antetokounmpo");
        posiciones.add("Ala Pivot");
        precios.add(50000000);

        jugadores.add("Kevin Durant");
        posiciones.add("Ala Pivot");
        precios.add(30000000);

        jugadores.add("Tobias Harris");
        posiciones.add("Ala Pivot");
        precios.add(20000000);

        jugadores.add("Paolo Banchero");
        posiciones.add("Ala Pivot");
        precios.add(10000000);

        jugadores.add("Nikola Jokic");
        posiciones.add("Pivot");
        precios.add(50000000);

        jugadores.add("Joel Embiid");
        posiciones.add("Pivot");
        precios.add(30000000);

        jugadores.add("Bam Adebayo");
        posiciones.add("Pivot");
        precios.add(20000000);

        jugadores.add("Brook Loper");
        posiciones.add("Pivot");
        precios.add(10000000);
    }

    // Función para imprimir la lista de jugadores disponibles
    public static void verJugadores(ArrayList<String> posiciones, ArrayList<String> nombres, ArrayList<Integer> precios2, double presupuesto) {
        System.out.println("===== Jugadores Disponibles =====");
        for (int i = 0; i < jugadoresDisponibles.size(); i++) {
            String jugadorActual = jugadoresDisponibles.get(i);
            int indiceOriginal = nombres.indexOf(jugadorActual);

            if (indiceOriginal != -1) {
                double precioJugador = precios2.get(indiceOriginal);

                // Verifica si el jugador se puede fichar con el presupuesto restante
                if (precioJugador <= presupuesto) {
                    System.out.println((i + 1) + ". " + posiciones.get(indiceOriginal) + " | " + jugadorActual + " | " + formatearPrecio(precioJugador));
                }
            }
        }
    }

    // Función para imprimir la lista de jugadores por posición
    public static void verPosiciones(Scanner scanner, ArrayList<String> posiciones, ArrayList<String> nombres, ArrayList<Integer> precios2) {
        boolean posicionValida = false;

        do {
            System.out.print("Ingrese la posición deseada (Base, Escolta, Alero, Ala Pivot, Pivot): ");
            String posicionDeseada = scanner.nextLine();

            // Validar si la posición ingresada es válida
            if (posicionDeseada.equalsIgnoreCase("Base") || posicionDeseada.equalsIgnoreCase("Escolta") ||
                    posicionDeseada.equalsIgnoreCase("Alero") || posicionDeseada.equalsIgnoreCase("Ala Pivot") ||
                    posicionDeseada.equalsIgnoreCase("Pivot")) {

                // Imprimir la información de los jugadores con la posición deseada
                System.out.println("\n===== Jugadores en la posición de " + posicionDeseada + " =====");
                for (int i = 0; i < posiciones.size(); i++) {
                    if (posiciones.get(i).equalsIgnoreCase(posicionDeseada)) {
                        System.out.println(posiciones.get(i) + " | " + nombres.get(i) + " | " + formatearPrecio(precios2.get(i)));
                    }
                }

                posicionValida = true; // Salir del bucle si la posición es válida
            } else {
                System.out.println("Posición no válida. Por favor, ingrese una posición válida.");
            }
        } while (!posicionValida);
    }

    // Función para fichar a un jugador
    public static void ficharJugador(Scanner scanner, ArrayList<String> posiciones, ArrayList<String> nombres, ArrayList<Integer> precios2,
    int[] presupuesto, ArrayList<String> jugadoresFichados) {
        verJugadores(posiciones, nombres, precios2, presupuesto[0]);

        int opcionJugador;
        do {
            // Solicitar al usuario que ingrese el número del jugador que desea fichar
            System.out.print("Ingrese el número del jugador que desea fichar (o 0 para cancelar): ");
            try {
                opcionJugador = scanner.nextInt();

                // Verificar si la opción es válida
                if (opcionJugador >= 0 && opcionJugador <= jugadoresDisponibles.size()) {
                    if (opcionJugador == 0) {
                        // El usuario eligió cancelar
                        System.out.println("Fichaje cancelado.");
                        return;
                    } else {
                        // El usuario eligió un jugador válido
                        String jugadorFichado = jugadoresDisponibles.get(opcionJugador - 1);
                        int indiceOriginal = nombres.indexOf(jugadorFichado);
                        double precioJugador = precios2.get(indiceOriginal);

                        // Verificar si el jugador se puede fichar con el presupuesto restante
                        if (precioJugador <= presupuesto[0]) {
                            // Realizar el fichaje
                            jugadoresDisponibles.remove(opcionJugador - 1);
                            nombresf.add(nombres.get(indiceOriginal));
                            posicionesf.add(posiciones.get(indiceOriginal));
                            preciosf.add(precioJugador);
                            jugadoresFichados.add(jugadorFichado);

                            // Actualizar el presupuesto
                            presupuesto[0] -= precioJugador;

                            // Informar al usuario
                            System.out.println("Has fichado a " + jugadorFichado + " por " + formatearPrecio(precioJugador) + ".");
                            System.out.println("Presupuesto restante: " + formatearPrecio(presupuesto[0]));

                            // Salir del bucle
                            return;
                        } else {
                            System.out.println("No tienes suficiente presupuesto para fichar a este jugador. Por favor, elige otro.");
                        }
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, ingresa un número válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido.");
                scanner.nextLine(); // Consumir entrada incorrecta
                opcionJugador = -1; // Reiniciar la opción para evitar un bucle infinito
            }
        } while (opcionJugador != 0);
    }

    // Función para devolver un jugador
    public static void devolverJugador(Scanner scanner, ArrayList<String> posiciones, ArrayList<String> nombres,
        ArrayList<Integer> precios2, int[] presupuesto, ArrayList<String> jugadoresFichados) {
    // Verificar si el usuario tiene jugadores fichados para devolver
    if (jugadoresFichados.isEmpty()) {
        System.out.println("No has fichado a ningún jugador aún.");
        return;
    }

    // Mostrar jugadores fichados con información adicional
    System.out.println("\n===== Jugadores Fichados =====");
    for (int i = 0; i < jugadoresFichados.size(); i++) {
        String jugadorFichado = jugadoresFichados.get(i);
        int indiceOriginal = nombres.indexOf(jugadorFichado);

        if (indiceOriginal != -1) {
            String posicionJugador = posiciones.get(indiceOriginal);
            double precioJugador = precios2.get(indiceOriginal);

            System.out.println((i + 1) + ". " + jugadorFichado + " | " + posicionJugador + " | "
            + formatearPrecio(precioJugador));
        }
    }

    // Solicitar al usuario que elija un jugador para devolver
    int opcionJugador;
    do {
        System.out.print("Seleccione el número del jugador que desea devolver (o 0 para cancelar): ");
        try {
            opcionJugador = scanner.nextInt();
            scanner.nextLine(); // Consumir el carácter de nueva línea restante en el búfer

            if (opcionJugador == 0) {
                System.out.println("Operación de devolución cancelada.");
                return;
            }

            if (opcionJugador < 1 || opcionJugador > jugadoresFichados.size()) {
                System.out.println("Número no válido. Por favor, ingrese un número válido.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un número válido.");
            opcionJugador = -1; // Reiniciar la opción para evitar un bucle infinito
            scanner.nextLine(); // Consumir entrada incorrecta
        }
    } while (opcionJugador < 1 || opcionJugador > jugadoresFichados.size());

    // Obtener la información del jugador seleccionado
    int indiceJugadorFichado = opcionJugador - 1; // Ajustar el índice
    if (indiceJugadorFichado >= 0 && indiceJugadorFichado < jugadoresFichados.size()) {
        String jugadorDevuelto = jugadoresFichados.get(indiceJugadorFichado);

        // Buscar el índice del jugador fichado en la lista original
        int indiceOriginal = nombres.indexOf(jugadorDevuelto);

        if (indiceOriginal != -1) {
            String posicionJugador = posiciones.get(indiceOriginal);
            double precioJugador = precios2.get(indiceOriginal);

            // Realizar la devolución del jugador
            System.out.println("Has devuelto a " + jugadorDevuelto + " | " + posicionJugador + " | "
                    + formatearPrecio(precioJugador) + " y has recuperado " + formatearPrecio(precioJugador)
                    + " a tu presupuesto.");

            // Actualizar el presupuesto y las listas de jugadores
            presupuesto[0] += precioJugador;
            jugadoresFichados.remove(indiceJugadorFichado);
            posiciones.remove(indiceOriginal);
            nombres.remove(indiceOriginal);
            precios2.remove(indiceOriginal);

            // Imprimir el nuevo presupuesto disponible
            System.out.println("Nuevo saldo disponible: " + formatearPrecio(presupuesto[0]));
        } else {
            System.out.println("Error: No se pudo encontrar el jugador en la lista original.");
        }
        } else {
            System.out.println("Error: Índice de jugador no válido.");
        }
    }

    // Función para imprimir la lista de jugadores fichados
    public static void verFichados(ArrayList<String> jugadoresFichados, ArrayList<String> posicionesF, ArrayList<Double> preciosF) {
        if (jugadoresFichados.isEmpty()) {
            System.out.println("No has fichado a ningún jugador aún.");
        } else {
            System.out.println("\n===== Jugadores Fichados =====");
            for (int i = 0; i < jugadoresFichados.size(); i++) {
                String jugadorActual = jugadoresFichados.get(i);
                int indiceOriginal = nombres.indexOf(jugadorActual);
    
                if (indiceOriginal != -1) {
                    System.out.println((i + 1) + ". " + posicionesF.get(i) + " | " + jugadorActual + " | " + formatearPrecio(preciosF.get(i)));
                } else {
                    System.out.println("Error: No se pudo encontrar información del jugador " + jugadorActual);
                }
            }
        }
    }

    // Función para formatear el precio como moneda
    public static String formatearPrecio(double precio) {
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.US);
        return formatoMoneda.format(precio);
    }
}
