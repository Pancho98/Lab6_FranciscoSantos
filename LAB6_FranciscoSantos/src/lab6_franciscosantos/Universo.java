/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_franciscosantos;

import java.util.ArrayList;

/**
 *
 * @author Francisco Santos
 */
public class Universo {
    private String nombre;
    private ArrayList<SeresVivos> listaSeres=new ArrayList();

    public Universo() {
    }

    public Universo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<SeresVivos> getListaSeres() {
        return listaSeres;
    }

    public void setListaSeres(ArrayList<SeresVivos> listaSeres) {
        this.listaSeres = listaSeres;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
