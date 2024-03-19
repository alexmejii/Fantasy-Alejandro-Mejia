/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fantasy1;

import java.io.Serializable;

/**
 *
 * @author Mañana
 */
public class Jugador implements Serializable{
    
    private String nombre;
    private int precio;
    private boolean fichado;

    public Jugador(String nombre,int precio){
        this.nombre=nombre;
        this.precio=precio;
        fichado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isFichado() {
        return fichado;
    }

    public void setFichado(boolean fichado) {
        this.fichado = fichado;
    }

    public void imprimir() {
        System.out.println(" " + nombre + " " + precio);
    }
}
