/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fantasy1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañana
 */
public class Instalacion {
    static File ficheroJug = new File("jugadores.obj");
    static ArrayList<Jugador> jugadores=new ArrayList<>();
    
    static void añadirJugadoresArrayInicial() {
        String[] nombres = {"Stephen Curry", "Devin Booker", "Shai Gilgeous-Alexander", "D'Aaron-Fox", "Jalen Brunson", "Klay Thompson", "Austin Reaves", "Kentavious Caldwell-Pope", "Jayson Tatum", "Kawhi Leonard", "Khris Middleton", "OG Anunoby", "Giannis Antetokounmpo", "Kevin Durant", "Tobias Harris", "Paolo Banchero", "Nikola Jokic", "Joel Embiid", "Bam Adebayo", "Brook Loper"};
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int precio = 10 + random.nextInt(91); // Precio aleatorio entre 10 y 100
            jugadores.add(new Jugador(nombres[i], precio));
        }
    }

    static void guardarJugadores() {
        FileOutputStream ff;
        try {
            ff = new FileOutputStream(ficheroJug);
            ObjectOutputStream oos= new ObjectOutputStream(ff);
            for (Object jug:jugadores) {
                oos.writeObject(jug); 
            }
            ff.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FANTASY2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FANTASY2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
