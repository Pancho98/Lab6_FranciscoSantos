/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_franciscosantos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Francisco Santos
 */
public class Universo {
    private String nombre;
    private ArrayList<SeresVivos> listaSeres=new ArrayList();
    private File file=null;

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

    public void setSerVivo(SeresVivos s) {
        this.listaSeres.add(s);
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
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
                sc.useDelimiter("\\|");
                while (sc.hasNext()) {
                    listaSeres.add(new SeresVivos(sc.next(), sc.nextInt(), sc.nextInt(),sc.next()));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
    public void Leer(){
        File fichero=null;
        FileReader fr = null;
        BufferedReader br = null;
        String Cadena="";
        try {
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto", "txt");
            FileNameExtensionFilter filtro2= new FileNameExtensionFilter("Imagenes", "jpg","png","bmp");
            jfc.setFileFilter(filtro);
            jfc.addChoosableFileFilter(filtro2);
            int seleccion = jfc.showOpenDialog(null);
            if (seleccion==JFileChooser.APPROVE_OPTION) {
                fichero=jfc.getSelectedFile();
                file= new File(jfc.getSelectedFile().getPath());
                fr=new FileReader(fichero);
                br = new BufferedReader(fr);
                String linea;
                Cadena+="";
                while ((linea=br.readLine())!=null) {                    
                    Cadena+=linea;
                    Cadena+="\n";
                }
            }
        } catch (Exception e) {
        }
    }
}
