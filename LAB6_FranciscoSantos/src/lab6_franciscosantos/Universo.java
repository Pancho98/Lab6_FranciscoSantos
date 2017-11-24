/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_franciscosantos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Francisco Santos
 */
public class Universo {
    private String nombre;
    private ArrayList<SeresVivos> listaSeres=new ArrayList();
    File file=null;

    public Universo() {
    }

    public Universo(String nombre,String Path) {
        this.nombre = nombre;
        file = new File(Path);
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setPersona(SeresVivos s) {
        this.listaSeres.add(s);
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        int cont = 0;
        try {
            fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            for (SeresVivos t : listaSeres) {
                bw.write(t.getRaza() + "|");
                bw.write(t.getKi()+ "|");
                bw.write(t.getAños()+ "|");
                bw.write(t.getPlaneta()+ "|");
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        if (file.exists()) {
            Scanner sc = null;
            Scanner scs = null;
            listaSeres = new ArrayList();
            try {
                sc = new Scanner(file);
                sc.useDelimiter("|");
                while (sc.hasNext()) {
                    listaSeres.add(new SeresVivos(sc.next(), sc.nextInt(), sc.nextInt(),sc.next()));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
    
}
