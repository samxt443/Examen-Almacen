package Controller;

import Model.Almacen;
import Model.Consumible;
import Model.Periferico;
import Model.Producto;

import java.awt.print.Printable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorFichero {

    public static final String FICHEROPRODUCTOS = "misproductos.csv";

    public static void grabarFichero(Almacen almacen) {
        ControladorFichero.grabarProductos(almacen.getListaP());
    }

    public static void grabarProductos(List<Producto> listaProductos) {
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new FileWriter(FICHEROPRODUCTOS));
            for (Producto producto : listaProductos) {
                pw.println(producto.toCSV());
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(pw != null){
                pw.close();
            }
        }
    }

    public static void cargarFichero(Almacen almacen) {
        ControladorFichero.cargarProductos();
    }

    public static void cargarProductos(){
        Scanner sc = null;
        try{
            sc = new Scanner(new FileReader(FICHEROPRODUCTOS));
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String [] partes = linea.split(";");

                switch(partes[0]){
                    case "Periferico": Controlador.getSingleton().addProducto(new Periferico(
                            partes[1],
                            partes[2],
                            partes[3],
                            Integer.parseInt(partes[4]),
                            Double.parseDouble(partes[5]),
                            Boolean.parseBoolean(partes[6]),
                            partes[7]));
                    break;
                    case "Consumible": Controlador.getSingleton().addProducto(new Consumible(
                            partes[1],
                            partes[2],
                            partes[3],
                            Integer.parseInt(partes[4]),
                            Double.parseDouble(partes[5]),
                            Double.parseDouble(partes[6])));
                    break;
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            if(sc != null){
                sc.close();
            }
        }
    }
}
